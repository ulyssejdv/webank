package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "transactions", schema = "public")
public class Transaction {
	
	private Integer idTransaction;
	private String transactionType;
	private Integer transactionAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   transactionDate;
	
	public Transaction() {
	}

	public Transaction(Integer idTransaction, String transactionType,Integer transactionAmount,Date transactionDate) {

		this.idTransaction		= idTransaction;
		this.transactionType 	= transactionType;
		this.transactionAmount	= transactionAmount;
		this.transactionDate 	= transactionDate;
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
	
	@Column(name = "transactionType", length = 50)
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
	

}
