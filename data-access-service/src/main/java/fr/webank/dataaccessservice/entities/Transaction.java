package fr.webank.dataaccessservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction")
	private Long idTransaction;
	
	@JoinColumn(name = "type_transac")
	@ManyToOne(fetch = FetchType.LAZY)
	private TransactionType transactionType;
	
	@JoinColumn(name = "from_account_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Account accountFrom;
	
	@JoinColumn(name = "to_account_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Account accountTo;
	
	@Column(name = "amount")
	private Integer transactionAmount;

	@JsonFormat(locale = "hu", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Budapest")
	@Column(name = "date_transac")
	private Date   transactionDate;
}
