//package fr.webank.dataaccessservice.controllers;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.servlet.ModelAndView;
//
//import fr.webank.dataaccessservice.entities.Account;
//import fr.webank.dataaccessservice.services.AccountService;
//import fr.webank.webankmodels.AccountDto;
//
//
//@Data
//@Builder
//@NoArgsConstructor
//@ToString
//public class AccountControllerTest {
//
//	  	@Mock
//	    AccountService accountService;
//
//
//	    @InjectMocks
//	    private AccountController accountControlerSUT;
//
//	    @Before
//	    public void setup() {
//
//	    }
//
//	    @Test
//	    public void shouldReturnAccountView() throws Exception {
//
//	        Mockito.mock(AccountService.class);
//	        AccountDto account= new AccountDto();
//
//	        account.setId(1);
//	        account.setAccountNumber("123456");
//	        account.setType("Courant");
//	        account.setDate("10/12/1995");
//
//	        ResponseEntity response = accountControlerSUT.getAccount();
//
//
//	        Assert.assertTrue(response.equals("data-access-service/account/{id}"));
//	    }
//
//
//
//	}
//
//
