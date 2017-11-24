package fr.webank.webankmodels;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author RubenEdery on 19/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
	
	private String	idAccount;
	private CustomerDto customer;
	private String accountNumber;
	private String type;
	private Date creationDate;
	private BalanceDto balance;
	
}
