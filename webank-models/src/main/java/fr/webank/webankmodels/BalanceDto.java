package fr.webank.webankmodels;

import java.util.Date;



public class BalanceDto {

    private Integer idBalance;
    private Integer balance;
    private Date lastBalanceDate;
    private AccountDto account;
    
    public BalanceDto(){

    }

    public BalanceDto (Integer    idBalance ,Integer   balance, Date lastBalanceDate, AccountDto account){

        this.idBalance = idBalance;
        this.balance= balance;
        this.lastBalanceDate = lastBalanceDate;
        this.account =account;
    }
    
    public Integer getId() {return idBalance;}

    public void setId(Integer idBalance) {
        this.idBalance = idBalance;
    }


    public Integer getBalance() {return balance;}
    public void setBalance(Integer balance) {
        this.balance =balance;
    }

    public Date getlastBalanceDate() {
        return lastBalanceDate;
    }

    public void setlastBalanceDate(Date lastBalanceDate) {
        this.lastBalanceDate = lastBalanceDate;
    }


    public AccountDto getAccount() {return account;}
    public void setAccount(AccountDto account) {
        this.account =account;
    }
}
