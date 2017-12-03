package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.controllers.StockController;
import fr.webank.dataaccessservice.services.StockPriceGeneratorService;
import fr.webank.dataaccessservice.services.StockService;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class stocksControllerTest {

    @Mock
    private StockService stockServiceMock;

    @InjectMocks
    private StockController StockControllerInjectMock;

    private Page<StockDto> pageStocks;

    @Before
    public void setup() {

        List<StockDto> listStocks = new ArrayList<>();

        listStocks.add(StockDto.builder()
                .stockId("FR0000120404 AC")
                .stockDescription("ACCOR")
                .build());
        listStocks.add(StockDto.builder()
                .stockId("FR0000120073 AI")
                .stockDescription("AIR LIQUIDE")
                .build());

        pageStocks = new PageImpl<StockDto>(listStocks);

    }

    @Test
    public void shouldRetrunListOfStock() {

        when(stockServiceMock.getAllStocks(0, 10))
                .thenReturn(pageStocks);


        ResponseEntity<List> response = StockControllerInjectMock.getAllStocks(0, 10);

        List<StockDto> body = (List<StockDto>)response.getBody();

        boolean testOk = response.getStatusCode() == HttpStatus.OK
                && body.size() == 2
                && body.get(0).getStockId() == pageStocks.getContent().get(0).getStockId()
                && body.get(0).getStockDescription() == pageStocks.getContent().get(0).getStockDescription()
                && body.get(1).getStockId() == pageStocks.getContent().get(1).getStockId()
                && body.get(1).getStockDescription() == pageStocks.getContent().get(1).getStockDescription();

        Assert.assertTrue(testOk);
    }

   
}

