//package fr.webank.webankwebapp.controllers;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.web.servlet.ModelAndView;
//
//import fr.webank.webankmodels.AccountDto;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class AccountControllerTest {
//
//	@Mock
//	private AccountDto accountDto;
//	
//    @InjectMocks
//    private AccountController accountControllerSUT;
//
//    @Before
//    public void setup() {
//
//    }
//
//    @Test
//    public void shouldAccount() throws Exception {
//
//        Mockito.mock(AccountDto.class);
//        AccountDto accountDto= new AccountDto();
//
//        accountDto.setId(1);
//        accountDto.setAccountNumber("1");
//        accountDto.setType("Courant");
//
//        ModelAndView response = accountControllerSUT.getAccount();
//
//
//        Assert.assertTrue(response.getViewName().equals("Notifier/accountById"));
//    }
//	
//}
