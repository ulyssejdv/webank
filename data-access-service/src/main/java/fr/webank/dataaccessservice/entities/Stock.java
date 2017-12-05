package fr.webank.dataaccessservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ayda Najjar.
 */


@Entity
@Table(name = "stock", schema = "public")
public class Stock {


    private String stockId;
    private String stockDescription;

    public Stock() {
    }

    public Stock(String stockId, String stockDescription) {
        this.stockId = stockId;
        this.stockDescription = stockDescription;
    }

    @Id
    @Column(name = "stockid", length = 50)
    public String getStockId() { return stockId; }

    public void setStockId(String stockId) { this.stockId = stockId; }

    @Column(name = "stockdescription", length = 50)
    public String getStockDescription() { return stockDescription; }

    public void setStockDescription(String stockDescription) { this.stockDescription = stockDescription; }
}
