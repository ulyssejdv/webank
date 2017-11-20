package fr.webank.dataaccessservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "customers")
public class Customer {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "lastname")
	    private String lastName;

	    @Column(name = "firstname")
	    private String firstName;
	    
	    @Column(name = "phonenumber")
		private String	phonenumber;

	    @Column(name = "birthday")
		private Date   birthday;

	    @Column(name = "address")
		private String address;
		
	    @Column(name = "email")
		private String email;
	    
	}