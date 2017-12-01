package fr.webank.dataaccessservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity(name = "balance")
public class Balance {

    /**
     * Balance
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long idBalance;
    
    @Column(name = "balance")
    private Integer balance;

    @JsonFormat(locale = "hu", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Budapest")
    @Column(name = "last_date_balance")
    private Date lastBalanceDate;
    
}
