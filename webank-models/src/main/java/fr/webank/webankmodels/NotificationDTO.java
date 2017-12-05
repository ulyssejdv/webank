package fr.webank.webankmodels;

import java.math.BigDecimal;
import java.util.Date;

public class NotificationDTO {

    private String idAccount;
    private BigDecimal amount;
    private String date;
    private String transactionType;
    private boolean read;

    public NotificationDTO() {
    }

    public NotificationDTO(String idAccount, BigDecimal amount, String date, String transactionType, boolean read) {
        this.idAccount = idAccount;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
        this.read = read;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
