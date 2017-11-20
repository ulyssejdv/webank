package fr.webank.webankmodels;

import java.util.Date;

import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CustomerDto {

	    @Pattern(regexp = "[0-9]{1,}")
	    private String id;
	    private String lastName;
	    private String firstName;
		private String	phonenumber;
		private Date birthday;
		private String address;
		private String email;
	}
	
