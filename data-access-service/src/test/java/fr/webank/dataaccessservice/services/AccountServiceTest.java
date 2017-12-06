package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.entities.Balance;
import fr.webank.dataaccessservice.repositories.AccountRepository;
import fr.webank.webankmodels.AccountDto;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.entities.Balance;
import fr.webank.dataaccessservice.entities.UserEntity;
import fr.webank.dataaccessservice.repositories.AccountRepository;
import fr.webank.dataaccessservice.services.AccountService;
import fr.webank.webankmodels.AccountDto;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by RubenEdery on 27/11/2017.
 */
public class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;


    /**
     * Execute this code before begin unit test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // Given
        List<Account> accountEntityList = new ArrayList<Account>();


        Balance b = new Balance();
        b.setIdBalance(Long.parseLong("1"));
        b.setBalance(123);


        Account accountEntity = new Account();
        accountEntity.setIdAccount(Long.parseLong("1"));
        accountEntity.setAccountNumber("1");
        accountEntity.setBalance(b);
        accountEntity.setType("Type1");

        accountEntityList.add(accountEntity);
        accountEntityList.add(accountEntity);
        accountEntityList.add(accountEntity);


        when(accountRepository.findAll()).thenReturn(accountEntityList);

        when(accountRepository.findOne(Long.parseLong("1"))).thenReturn(accountEntity);

    }




    @BeforeClass
    public static void begin() { System.out.println("Begin Test of Account Service");
    }


    @AfterClass
    public static void end() { System.out.println("End Test of Account Service");
    }


    /**
     * Test should be return accountDto
     *
     * @throws Exception
     */
    @Test
    public void ShouldReturnGetTypeAccount() throws Exception {

        List<AccountDto> accountDto = accountService.getAll();
        accountDto.size();
        assertTrue(accountDto.get(1).getType().toString().equals("Type1"));

    }




}
