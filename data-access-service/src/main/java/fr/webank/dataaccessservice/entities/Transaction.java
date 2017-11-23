package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_transac")
	private Date   transactionDate;
}
