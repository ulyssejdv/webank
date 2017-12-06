package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.StockPriceDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StockPriceGeneratorServiceTest {
    @InjectMocks
    private StockPriceGeneratorService stockPriceGeneratorServiceMock;


    @Test
    public void shouldRetrunListOfStock() {

        StockPriceDto stockPrice = stockPriceGeneratorServiceMock.GenerateStock("FR0000120404 AC");
        boolean testOk = stockPrice.getStockOpenPrice() >= stockPrice.getStockMinPrice()
                && stockPrice.getStockOpenPrice() <= stockPrice.getStockMaxPrice()
                && stockPrice.getStockPrice() >= stockPrice.getStockMinPrice()
                && stockPrice.getStockPrice() <= stockPrice.getStockMaxPrice();

        Assert.assertTrue(testOk);
    }
}
