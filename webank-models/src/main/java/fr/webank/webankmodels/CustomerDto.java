package fr.webank.webankmodels;

import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author RubenEdery on 19/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String    idCustomer;
	private String    phonenumber;
	private Date birthday;
	private String lastname;
	private String firstname;
	private String address;
	private String email;
	
}
