package fr.webank.dataaccessservice.entities;

import javax.persistence.*;

/**
 * @author Alex
 */

@Entity(name = "Notification")
public class Notification {

    @Id
    private Long idNotification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaction")
    private Transaction transaction;

    private Boolean read;

    public Notification() {
    }

    public Notification(Long idNotification, Transaction transaction, Boolean read) {
        this.idNotification = idNotification;
        this.transaction = transaction;
        this.read = read;
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Boolean isRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
