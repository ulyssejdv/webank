package fr.webank.dataaccessservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.webank.dataaccessservice.App;
import fr.webank.dataaccessservice.entities.BasEntity;
import fr.webank.dataaccessservice.entities.CustomerEntity;
import fr.webank.dataaccessservice.repositories.BasRepository;
import fr.webank.dataaccessservice.repositories.CustomerRepository;
import fr.webank.dataaccessservice.services.BasService;
import fr.webank.webankmodels.BasDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 06/12/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BasController.class)
public class BasControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BasService basService;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testShouldReturnBasDtoObject() throws Exception {

        String route = "/bas/{basId}";

        Optional<BasDto> basDto = Optional.of(
                BasDto.builder()
                        .createdAt(new Date().getTime())
                        .fileName("file.pdf")
                        .id(new Long(1))
                        .build()
        );

        given(this.basService.getBasById(new Long(1)))
                .willReturn(basDto);

        this.mvc.perform(
                get(route, new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(mapper.writeValueAsString(basDto.get()))
        );
    }


    @Test
    public void testShouldReturnAListOfBasDto() throws Exception {
        String route = "/bas/customer/{customerId}";

        Optional<BasDto> basDto = Optional.of(
                BasDto.builder()
                        .createdAt(new Date().getTime())
                        .fileName("file.pdf")
                        .id(new Long(1))
                        .build()
        );


        List<BasDto> basDtoList = new ArrayList<>();

        basDtoList.add(BasDto.builder()
                .createdAt(new Date().getTime())
                .fileName("file.pdf")
                .id(new Long(1))
                .build());

        basDtoList.add(BasDto.builder()
                .createdAt(new Date().getTime())
                .fileName("file2.pdf")
                .id(new Long(2))
                .build());


        given(this.basService.getBasByCustomer(new Long(1)))
                .willReturn(basDtoList);

        this.mvc.perform(
                get(route, new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(mapper.writeValueAsString(basDtoList))
        );
    }

    @Test
    public void testShouldReturnNothingAndNoContentHttpCode() throws Exception {
        String route = "/bas/customer/{customerId}";


        List<BasDto> basDtoList = new ArrayList<>();

        given(this.basService.getBasByCustomer(new Long(1)))
                .willReturn(basDtoList);

        this.mvc.perform(
                get(route, new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isNoContent()
        );
    }
}
