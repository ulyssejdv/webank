package fr.webank.dataaccessservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.webank.dataaccessservice.services.BankStatementServiceInterface;
import fr.webank.webankmodels.BankStatementDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
@WebMvcTest(BankStatementController.class)
public class BankStatementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BankStatementServiceInterface bankStatementService;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testShouldReturnBasDtoObject() throws Exception {

        String route = "/bas/{basId}";

        Optional<BankStatementDto> basDto = Optional.of(
                BankStatementDto.builder()
                        .createdAt(new Date().getTime())
                        .fileName("file.pdf")
                        .id(new Long(1))
                        .build()
        );

        given(this.bankStatementService.getBasById(new Long(1)))
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

        Optional<BankStatementDto> basDto = Optional.of(
                BankStatementDto.builder()
                        .createdAt(new Date().getTime())
                        .fileName("file.pdf")
                        .id(new Long(1))
                        .build()
        );


        List<BankStatementDto> bankStatementDtoList = new ArrayList<>();

        bankStatementDtoList.add(BankStatementDto.builder()
                .createdAt(new Date().getTime())
                .fileName("file.pdf")
                .id(new Long(1))
                .build());

        bankStatementDtoList.add(BankStatementDto.builder()
                .createdAt(new Date().getTime())
                .fileName("file2.pdf")
                .id(new Long(2))
                .build());


        given(this.bankStatementService.getBasByCustomer(new Long(1)))
                .willReturn(bankStatementDtoList);

        this.mvc.perform(
                get(route, new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(mapper.writeValueAsString(bankStatementDtoList))
        );
    }

    @Test
    public void testShouldReturnNothingAndNoContentHttpCode() throws Exception {
        String route = "/bas/customer/{customerId}";


        List<BankStatementDto> bankStatementDtoList = new ArrayList<>();

        given(this.bankStatementService.getBasByCustomer(new Long(1)))
                .willReturn(bankStatementDtoList);

        this.mvc.perform(
                get(route, new Long(1)).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isNoContent()
        );
    }
}
