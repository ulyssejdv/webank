//package fr.webank.dataaccessservice.controllers;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import fr.webank.dataaccessservice.services.CustomerService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
//@WebAppConfiguration
//public class CustomerControllerTest {
//
//
//	    private MockMvc mockMvc;
//	 
//	    @Autowired
//	    private CustomerService customerServiceMock;
//	 
//	    //Add WebApplicationContext field here.
//	 
//	    //The setUp() method is omitted.
//	 
//	    @Test
//	    public void findById_TodoEntryNotFound_ShouldReturnHttpStatusCode404() throws Exception {
//	        when(customerServiceMock.getCustomerById(null));
//	 
//	        mockMvc.perform(get("/api/todo/{id}", 1L))
//	                .andExpect(status().isNotFound());
//	 
//	        verify(customerServiceMock, times(1)).getCustomerById(null));
//	        verifyNoMoreInteractions(customerServiceMock);
//	    }
//	}
//
