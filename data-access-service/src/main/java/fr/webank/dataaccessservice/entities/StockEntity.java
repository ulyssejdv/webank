package fr.webank.dataaccessservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stock", schema = "public")
public class StockEntity {

    private String stockId;
    private String stockDescription;

    @Column(name = "stockid", length = 50)
    public String getStockId() { return stockId; }

    public void setStockId(String stockId) { this.stockId = stockId; }

    @Column(name = "stockdescription", length = 50)
    public String getStockDescription() { return stockDescription; }

    public void setStockDescription(String stockDescription) { this.stockDescription = stockDescription; }
}
