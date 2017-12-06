package fr.webank.webankmodels;

/**
 * Created by Ayda Najjar.
 */

public class StockPriceDto {

    private String stockId;
    private String stockDescription;
    private Double stockPrice;
    private Double stockPriceChange;
    private Double stockOpenPrice;
    private Double stockMaxPrice;
    private Double stockMinPrice;
    private Double stockExchange;

    public StockPriceDto(String stockDescription, String stockId, Double stockMinPrice,  Double stockMaxPrice) {
        this.stockId = stockId;
        this.stockDescription = stockDescription;
        this.stockMaxPrice = stockMaxPrice;
        this.stockMinPrice = stockMinPrice;
    }

    public StockPriceDto() {
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Double getStockPriceChange() {
        return stockPriceChange;
    }

    public void setStockPriceChange(Double stockPriceChange) {
        this.stockPriceChange = stockPriceChange;
    }

    public Double getStockOpenPrice() {
        return stockOpenPrice;
    }

    public void setStockOpenPrice(Double stockOpenPrice) {
        this.stockOpenPrice = stockOpenPrice;
    }

    public Double getStockMaxPrice() {
        return stockMaxPrice;
    }

    public void setStockMaxPrice(Double stockMaxPrice) {
        this.stockMaxPrice = stockMaxPrice;
    }

    public Double getStockMinPrice() {
        return stockMinPrice;
    }

    public void setStockMinPrice(Double stockMinPrice) {
        this.stockMinPrice = stockMinPrice;
    }

    public Double getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(Double stockExchange) {
        this.stockExchange = stockExchange;
    }
}
