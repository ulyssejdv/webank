package fr.webank.dataaccessservice.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customers", schema = "public")
public class Customer implements Serializable{

	private Integer    idCustomer;
	private String    phonenumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   birthday;
	private String lastname;
	private String firstname;
	private String address;
	private String email;

	public Customer() {
	}

	public Customer(Integer idCustomer, String lastname, String firstname, String address, String phonenumber,
					String email,Date birthday) {
		
		this.idCustomer		= idCustomer;
		this.lastname 		= lastname;
		this.firstname	    = firstname;
		this.address 		= address;
		this.phonenumber 	= phonenumber;
		this.email 			= email;
		this.birthday 		= birthday;
	}



	@Id
	@SequenceGenerator(name = "customers_id_customer_seq", sequenceName = "customers_id_customer_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_customer_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {return idCustomer;}

	public void setId(Integer id) {
		this.idCustomer = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 13)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "lastname", length = 50)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "firstname", length = 50)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phonenumber", length = 10)
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name = "email", length = 50)
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
}



