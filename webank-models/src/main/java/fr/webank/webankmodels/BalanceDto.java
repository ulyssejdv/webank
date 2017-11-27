package fr.webank.webankmodels;

import lombok.*;

import java.util.Date;

/**
 * @author RubenEdery on 19/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BalanceDto {
	private String idBalance;
	private Integer balance;
	private Date lastBalanceDate;

}
