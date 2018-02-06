package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Stock;
import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.StockDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Testing the AdvisorRepository Class
 */

@RunWith(MockitoJUnitRunner.class)
public class stocksServiceTest {

    @InjectMocks
    private StockService stockServiceInjectMock;

    @Mock
    private StockRepository StockRepositoryMock;

    private Page<Stock> pageStocks;

    @Before
    public void setup() {

        List<Stock> listStocks = new ArrayList<>();

        listStocks.add(new Stock("FR0000120404 AC", "ACCOR"));
        listStocks.add(new Stock("FR0000120073 AI", "AIR LIQUIDE"));

        pageStocks = new PageImpl<Stock>(listStocks);
    }

    @Test
    public void shouldRetrunListOfStock() {

        Pageable pageable = new PageRequest(0, 10);

        //Mock the entityManager.createQuery method: every time we call this method we will return query
        when(StockRepositoryMock.findAll(pageable))
                .thenReturn(pageStocks);


        Page<StockDto> response = stockServiceInjectMock.getAllStocks(0, 10);

        boolean testOk = response.getContent().size() == 2
                && response.getTotalElements() == 2
                && response.getTotalPages() == 1
                && response.getContent().get(0).getStockId() == pageStocks.getContent().get(0).getStockId()
                && response.getContent().get(0).getStockDescription() == pageStocks.getContent().get(0).getStockDescription()
                && response.getContent().get(1).getStockId() == pageStocks.getContent().get(1).getStockId()
                && response.getContent().get(1).getStockDescription() == pageStocks.getContent().get(1).getStockDescription();

        Assert.assertTrue(testOk);
    }
}
