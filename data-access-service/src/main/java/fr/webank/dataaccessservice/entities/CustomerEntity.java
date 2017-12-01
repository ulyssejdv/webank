package fr.webank.dataaccessservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity(name = "customers")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long    idCustomer;
	
	@Column(name = "phonenumber", length = 10)
	private String    phonenumber;
	
	@Column(name = "birthday", length = 13)
	private Date   birthday;
	
	@Column(name = "lastname", length = 50)
	private String lastname;
	
	@Column(name = "firstname", length = 50)
	private String firstname;
	
	@Column(name = "address", length = 50)
	private String address;
	
	@Column(name = "email", length = 50)
	private String email;
	
}



