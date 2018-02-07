package fr.webank.loadbalancingsoa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import fr.webank.loadbalancingsoa.controllers.StockController;
import fr.webank.webankmodels.StockDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoadBalancingSOATest {

    ConfigurableApplicationContext application1;
    ConfigurableApplicationContext application2;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void startApps() {
        this.application1 = startApp(25000);
        this.application2 = startApp(25010);
    }

    @After
    public void closeApps() {
        this.application1.close();
        this.application2.close();
    }

    @Test
    public void shouldNotHaveAnErrorWhenStoppingOneServerStocksList() throws InterruptedException {
        ResponseEntity<StockDto[]> response1 = testRestTemplate.getForEntity("http://localhost:" + port + "/data-access-service/stocks", StockDto[].class);

        application1.close();
        Thread.sleep(40000);

        ResponseEntity<StockDto[]> response2 = testRestTemplate.getForEntity("http://localhost:" + port + "/data-access-service/stocks", StockDto[].class);

        then(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
        then((response1.getBody()).length == 2);
        then((response1.getBody())[0].getStockId().equals("AA"));
        then(response2.getStatusCode()).isEqualTo(HttpStatus.OK);
        then((response2.getBody())[0].getStockId().equals("AA"));
        then((response2.getBody()).length == 2);

        application2.close();
    }

    @Test
    public void shouldNotHaveAnErrorWhenStoppingOneServerSotock() throws InterruptedException {
        if(application2.isActive()) {
            application2.start();
        }

        if(application1.isActive()) {
            application1.start();
        }

        Thread.sleep(40000);

        String stockId = "AA";

        ResponseEntity<StockDto> response2 = testRestTemplate.getForEntity("http://localhost:" + port + "/data-access-service/stocks/"+stockId, StockDto.class);

        then(response2.getStatusCode()).isEqualTo(HttpStatus.OK);
        then((response2.getBody()).getStockId().equals(stockId));
    }


    private ConfigurableApplicationContext startApp(int port) {
        return SpringApplication.run(TestApplication.class,
                "--server.port=" + port,
                "--spring.jmx.enabled=false");
    }

    @Configuration
    @EnableAutoConfiguration
    @RestController("data-access-service")
    static class TestApplication {

        @RequestMapping(value = "/stocks")
        public List<StockDto> stocks() {
            List listStocks = new ArrayList<StockDto>();

            listStocks.add(StockDto.builder()
                    .stockId("AA")
                    .stockDescription("Alcoa Corporation")
                    // build() : finalize the creation of new instance
                    .build());
            listStocks.add(StockDto.builder()
                    .stockId("MSFT")
                    .stockDescription("Microsoft Cooperation")
                    // build() : finalize the creation of new instance
                    .build());
            return listStocks;
        }

        @RequestMapping(value = "/stocks/{stockId}")
        public StockDto stock(@PathVariable String stockId) {
            return StockDto.builder()
                    .stockId(stockId)
                    .stockDescription("Microsoft Cooperation")
                    // build() : finalize the creation of new instance
                    .build();
        }

        @RequestMapping(value = "/")
        public String health() {
            return "ok";
        }
    }
}
