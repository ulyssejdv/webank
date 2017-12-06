package fr.webank.dataaccessservice.controllers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.services.AccountService;
import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.BalanceDto;
import fr.webank.webankmodels.CustomerDto;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;

/*
@Data
@Builder
@NoArgsConstructor
@ToString
*/
public class AccountControllerTest {

	  	@Mock
	    AccountService accountService;


	    @InjectMocks
	    private AccountController accountControllerSUT;
	    private AccountDto accountDto;
	    private CustomerDto customerDto;
	    private BalanceDto balanceDto;
	    private List<AccountDto> list;

	    @Before
	    public void setup() {
	    	
	        List<AccountDto> listAccountDto = new ArrayList<>();

	        listAccountDto.add(AccountDto.builder()
	                .idAccount("1")
	                .customer(customerDto)
	                .accountNumber("1")
	                .type("Courant")
	                .creationDate(new Date("10/12/1995"))
	                .balance(balanceDto)
	                .build());
	        listAccountDto.add(AccountDto.builder()
	        		.idAccount("2")
	                .customer(customerDto)
	                .accountNumber("2")
	                .type("Epargne")
	                .creationDate(new Date("10/12/2015"))
	                .balance(balanceDto)
	                .build());
	        listAccountDto.add(AccountDto.builder()
	        		.idAccount("3")
	                .customer(customerDto)
	                .accountNumber("3")
	                .type("Courant")
	                .creationDate(new Date("25/10/2017"))
	                .balance(balanceDto)
	                .build());

	        accountDto = new AccountDto();

	    }
/*
	    @Test
	    public void shouldReturnAccountList() {

	        when(accountService.getAll())
	                .thenReturn(list);


	        ResponseEntity<List> response = accountControllerSUT.getAccount();

	        List<AccountDto> body = (List<AccountDto>)response.getBody();

	        boolean success = response.getStatusCode() == HttpStatus.OK
	                && body.size() == 2
	                && body.get(1).getIdAccount() == accountDto.get(1).getIdAccount()
	                && body.get(1).getAccountNumber() == accountDto.get(1).getAccountNumber()
	    	        && body.get(2).getIdAccount() == accountDto.get(2).getIdAccount()
	    	        && body.get(2).getAccountNumber() == accountDto.get(2).getAccountNumber()
	    	        && body.get(3).getIdAccount() == accountDto.get(3).getIdAccount()
	    	        && body.get(3).getAccountNumber() == accountDto.get(3).getAccountNumber();

	        Assert.assertTrue(success);
	    }
	    */
	    /*
	    @Test
	    public void shouldReturnAccountNotFound() {
	        when(accountService.getAll())
	                .thenReturn(list);

	        ResponseEntity<AccountDto> response = null;
			try {
				response = accountControllerSUT.getAccount();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        boolean success = response.getStatusCode() == HttpStatus.FORBIDDEN;

	        Assert.assertTrue(success);
	    }
	    
	    */
	    }
	    
	    /*
	    @Test
	    public void shouldReturnAccountView() throws Exception {

	        Mockito.mock(AccountService.class);
	        AccountDto account= new AccountDto();

	        account.setId(1);
	        account.setAccountNumber("123456");
	        account.setType("Courant");
	        account.setDate("10/12/1995");

	        ResponseEntity response = accountControlerSUT.getAccount();


	        Assert.assertTrue(response.equals("data-access-service/account/{id}"));
	    }
*/





