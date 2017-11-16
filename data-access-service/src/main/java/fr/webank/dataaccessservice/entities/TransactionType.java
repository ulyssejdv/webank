package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "transactionType", schema = "public")
public class TransactionType {
	
	private Integer idTransactionType;
	private String transactionTypeName;
	
	public TransactionType() {
	}

	public TransactionType(Integer idTransaction, String transactionTypeName) {

		this.idTransactionType	= idTransactionType;
		this.transactionTypeName= transactionTypeName;
		}
	
	@Id
	@SequenceGenerator(name = "transactionType_id_transactionType_seq", sequenceName = "transactionType_id_transactionType_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionType_id_transactionType_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getIdTransactionType() {
		return idTransactionType;
	}
	public void setIdTransactionType(Integer idTransactionType) {
		this.idTransactionType = idTransactionType;
	}
	
	@Column(name = "transactionTypeName", length = 50)
	public String getTransactionTypeName() {
		return transactionTypeName;
	}
	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

}
