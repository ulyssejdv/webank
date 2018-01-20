package fr.webank.webankwebapp.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.NotificationDTO;


@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

	@Mock
	private AccountDto accountDto;
	private NotificationDTO notificationDto;
	
    @InjectMocks
    private AccountController accountControllerSUT;

    @Before
    public void setup() {

    }

    @Test
    public void shouldReturnAccount() throws Exception {

        Mockito.mock(AccountDto.class);
        AccountDto accountDto= new AccountDto();
        ModelAndView response = accountControllerSUT.getAccount();
        Assert.assertTrue(response.getViewName().equals("Notifier/PersonalAccount"));
    }
    
    @Test
    public void shouldNotReturnAccount() throws Exception {

        Mockito.mock(AccountDto.class);
        AccountDto accountDto= new AccountDto();
        ModelAndView response = accountControllerSUT.getAccount();
        Assert.assertFalse(response.getViewName().equals("FausseUrl"));
    }
    
    @Test
    public void shouldReturnNotification() throws Exception {

        Mockito.mock(AccountDto.class);
        NotificationDTO notificationDto = new NotificationDTO();
        ModelAndView response = accountControllerSUT.getAccount();
        Assert.assertTrue(response.getViewName().equals("Notifier/PersonalAccount"));
    }
    
    @Test
    public void shouldNotReturnNotification() throws Exception {

        Mockito.mock(AccountDto.class);
        AccountDto accountDto= new AccountDto();
        ModelAndView response = accountControllerSUT.getAccount();
        Assert.assertFalse(response.getViewName().equals("FausseUrl"));
    }
	
}
