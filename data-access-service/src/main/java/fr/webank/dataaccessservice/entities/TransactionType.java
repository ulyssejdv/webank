package fr.webank.dataaccessservice.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "transactiontype")
public class TransactionType {

	/**
	 * Type transaction
	 */



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long idTransactionType;
	
	@Column(name = "transactionTypeName", length = 50)
	private String transactionTypeName;
}
