package fr.webank.dataaccessservice.services.stockprice;

import fr.webank.webankmodels.StockPriceDto;
import org.springframework.stereotype.Service;

@Service
public interface IStockPriceService {
  StockPriceDto getStockPrice(String symbole);
}
