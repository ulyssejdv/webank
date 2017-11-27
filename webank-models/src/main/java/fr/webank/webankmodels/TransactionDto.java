package fr.webank.webankmodels;

import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDto {
	private String idTransaction;
	private TypeTransactionDto transactionType;
	private AccountDto accountFrom;
	private AccountDto accountTo;
	private Integer transactionAmount;
	private Date transactionDate;
}