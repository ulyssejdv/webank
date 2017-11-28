package fr.webank.dataaccessservice.entities;

import javax.persistence.*;

@Entity(name = "Notification")
public class Notification {

    @Id
    private Long idNotification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaction")
    private Transaction transaction;

    private boolean read;

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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
