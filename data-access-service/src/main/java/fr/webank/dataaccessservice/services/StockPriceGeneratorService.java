package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Ayda Najjar.
 */

@Service
public class StockPriceGeneratorService {

    private Dictionary<String, StockPriceDto> listStock;

    //Constructor: initialize the static list of CAC 40
    @Autowired
    public StockPriceGeneratorService() {
        //Initialize list of stock in a hashtable
        listStock = new Hashtable<>();

        StockPriceDto stock = null;

        stock = new StockPriceDto("ACCOR","FR0000120404 AC",41.0,42.5);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("AIR LIQUIDE","FR0000120073 AI",105.0,106.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("AIRBUS","NL0000235190 AIR",85.0,87.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("ARCELORMITTAL","LU1598757687 MT",24.0,25.5);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("ATOS","FR0000051732 ATO",124.0,128.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("AXA","FR0000120628 CS",25.0,26.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("BNP PARIBAS P-A","FR0000131104 BNP",62.5,64.5);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("BOUYGUES","FR0000120503 EN",43.0,43.5);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("CAPGEMINI","FR0000125338 CAP",99.5,102.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("CARREFOUR","FR0000120172 CA",16.5,17.0);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("CREDIT AGRICOLE SA","FR0000045072 ACA",13.7,14.5);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("DANONE","FR0000120644 BN",70.5,71.8);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("NGIE","FR0010208488 ENGI",14.4,14.6);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("ESSILOR INTL","FR0000121667 EI",107.7,109.8);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("ERING (Ex: PPR)","FR0000121485 KER",390.20,392.80);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("L'OREAL","FR0000120321 OR",186.80,189.10);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("LAFARGEHOLCIM N","CH0012214059 LHN",47.080,47.630);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("MICHELIN N","FR0000121261 ML",117.25,118.50);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("ORANGE (ex: FRANCE TELECOM)","FR0000133308 ORA",14.175,14.330);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("PERNOD RICARD","FR0000120693 RI",129.10, 129.30);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("PUBLICIS_GRP","FR0000130577_PUB",54.41,55.41);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("PEUGEOT","FR0000121501_UG",18.110,18.380);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("RENAULT","FR0000131906_RNO",85.32,86.72);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SAFRAN","FR0000073272_SAF",86.44,87.13);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SAINT-GOBAIN","FR0000125007_SGO",47.650,50.210);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SANOFI","FR0000120578_SAN",76.90,77.79);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SCHNEIDER_E.SE","FR0000121972_SU",71.48,72.42);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SOCIETE_GENERALE","FR0000130809_GLE",42.780,44.000);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SODEXO","FR0000121220_SW",105.25,106.75);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("SOLVAY","BE0003470755_SOLB",118.85,120.00);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("STMICROELECTR","NL0000226223_STM",20.475,20.915);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("TECHNIPFMC","GB00BDSFG982_FTI",22.485,23.070);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("TOTAL","FR0000120271_FP",47.235,47.760);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("UNIBAIL-RODAMCO","FR0000124711_UL",217.75,219.60);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("VALEO","FR0013176526_FR",58.64,59.37);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("VEOLIA_ENVIRONNEM.","FR0000124141_VIE",21.020,21.190);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("VINCI","FR0000125486_DG",86.30,87.37);
        listStock.put(stock.getStockId(), stock);
        stock = new StockPriceDto("VIVENDI","FR0000127771_VIV",22.980,23.395);
        listStock.put(stock.getStockId(), stock);
    }


    //method to generate a random stock price
    public StockPriceDto GenerateStock(String stockId){

        StockPriceDto stockPrice = listStock.get(stockId);

        //If stockId doesn't exist in CAC 40
        if(stockPrice == null)
            return null;

        //Caculate the stock open price
        Double openPrice = GetRandomPrice(stockPrice.getStockMinPrice(), stockPrice.getStockMaxPrice());
        stockPrice.setStockOpenPrice(openPrice);

        //Calculate the stock price
        Double price = GetRandomPrice(stockPrice.getStockMinPrice(), stockPrice.getStockMaxPrice());
        stockPrice.setStockPrice(price);

        //Calculate the stock price Change
        Double stockPriceChange = GetPercent(openPrice, price);
        stockPrice.setStockPriceChange(stockPriceChange);

        return  stockPrice;
    }

    private Double GetRandomPrice(Double minPrice, Double maxPrice) {
        return minPrice + Math.random() * (maxPrice - minPrice);
    }

    private Double GetPercent(double openPrice, double price)
    {
        return (price - openPrice) / openPrice * 100;
    }
}
