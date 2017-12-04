//package fr.webank.webankwebapp.controllers;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.WebApplicationContext;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
//@WebAppConfiguration
//public class CustomerControllerTest {
//	 
//	    private MockMvc mockMvc;
//	 
//	    @Autowired
//	    private RestTemplate todoServiceMock;
//	 
//	    //Add WebApplicationContext field here
//	 
//	    //The setUp() method is omitted.
//	 
//	    @Test
//	    public void findById_TodoEntryNotFound_ShouldRender404View() throws Exception {
//	        when(todoServiceMock.findById(1L)).thenThrow(new TodoNotFoundException(""));
//	 
//	        mockMvc.perform(get("/todo/{id}", 1L))
//	                .andExpect(status().isNotFound())
//	                .andExpect(view().name("error/404"))
//	                .andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));
//	 
//	        verify(todoServiceMock, times(1)).findById(1L);
//	        verifyZeroInteractions(todoServiceMock);
//	    }
//	}
