package fr.webank.webankmodels;


import java.io.Serializable;
import java.util.Date;


public class CustomerDto implements Serializable{

	private Integer    idCustomer;
	private String    phonenumber;
	private Date   birthday;
	private String lastname;
	private String firstname;
	private String address;
	private String email;

	public CustomerDto() {
	}

	public CustomerDto(Integer idCustomer, String lastname, String firstname, String address, String phonenumber,
					String email,Date birthday) {
		
		this.idCustomer		= idCustomer;
		this.lastname 		= lastname;
		this.firstname	    = firstname;
		this.address 		= address;
		this.phonenumber 	= phonenumber;
		this.email 			= email;
		this.birthday 		= birthday;
	}


	public Integer getId() {return idCustomer;}

	public void setId(Integer id) {
		this.idCustomer = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
}



