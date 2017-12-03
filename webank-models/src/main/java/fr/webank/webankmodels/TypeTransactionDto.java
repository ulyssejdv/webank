package fr.webank.webankmodels;

import lombok.*;

/**
 * @author RubenEdery on 19/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeTransactionDto {
	private String idTransactionType;
	private String transactionTypeName;
}
