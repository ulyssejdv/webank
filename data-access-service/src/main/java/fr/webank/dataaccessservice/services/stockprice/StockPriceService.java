package fr.webank.dataaccessservice.services.stockprice;

import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPriceService implements IStockPriceService {
    IStockPriceService alphAvantageService;
    IStockPriceService iExtradingServiceService;

    @Autowired
    public StockPriceService(AlphAvantageService alphAvantageService, IExtradingServiceService iExtradingServiceService) {
        this.alphAvantageService = alphAvantageService;
        this.iExtradingServiceService = iExtradingServiceService;
    }


    @Override
    public StockPriceDto getStockPrice(String symbole) {
        try {
            return  iExtradingServiceService.getStockPrice(symbole);
        }
        catch (Exception ex) {
            return  alphAvantageService.getStockPrice(symbole);
        }
    }
}
