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

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "balance", schema = "public")
public class Balance {

    private Integer idBalance;
    private Integer balance;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date lastBalanceDate;
    private Account account;
    
    public Balance(){

    }

    public Balance (Integer    idBalance ,Integer   balance, Date lastBalanceDate, Account account){

        this.idBalance = idBalance;
        this.balance= balance;
        this.lastBalanceDate = lastBalanceDate;
        this.account =account;
    }
    

    @Id
    @SequenceGenerator(name = "balance_id_seq", sequenceName = "balance_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {return idBalance;}

    public void setId(Integer idBalance) {
        this.idBalance = idBalance;
    }


    @Column(name = "balance")
    public Integer getBalance() {return balance;}
    public void setBalance(Integer balance) {
        this.balance =balance;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", length = 13)
    public Date getlastBalanceDate() {
        return lastBalanceDate;
    }

    public void setlastBalanceDate(Date lastBalanceDate) {
        this.lastBalanceDate = lastBalanceDate;
    }

    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    public Account getAccount() {return account;}
    public void setAccount(Account account) {
        this.account =account;
    }
}
