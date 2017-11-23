package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity(name = "balance")
public class Balance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long idBalance;
    
    @Column(name = "balance")
    private Integer balance;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "last_date_balance", length = 13)
    private Date lastBalanceDate;
    
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;
    

    
}
