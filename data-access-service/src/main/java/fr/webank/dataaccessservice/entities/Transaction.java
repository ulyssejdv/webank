package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "transactions", schema = "public")
public class Transaction {
	
	private Integer idTransaction;
	private TransactionType transactionType;
	private Account account;
	private Integer transactionAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   transactionDate;
	
	public Transaction() {
	}

	public Transaction(Integer idTransaction, TransactionType transactionType,Integer transactionAmount,Date transactionDate, Account account) {

		this.idTransaction		= idTransaction;
		this.transactionType 	= transactionType;
		this.transactionAmount	= transactionAmount;
		this.transactionDate 	= transactionDate;
		this.account = account;
		}
	
	
	@Id
	@SequenceGenerator(name = "transaction_id_transaction_seq", sequenceName = "transaction_id_transaction_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_transaction_seq")
	@Column(name = "id", unique = true, nullable = false)	
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	
	@Column(name = "transactionAmount", length = 50)
	public Integer getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "transactionDate", length = 13)
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@ManyToOne
    @JoinColumn(name="idTransactionType", referencedColumnName = "id")
    public TransactionType getTransactionType(){
        return transactionType;
    }
    public void setTransactionType(TransactionType transactionType){
        this.transactionType=transactionType;
    }
    
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    public Account getAccount() {return account;}
    public void setAccount(Account account) {
        this.account =account;
    }

}
