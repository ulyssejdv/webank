package fr.webank.dataaccessservice.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;



@Data
@Entity(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Long	idAccount;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "id")
    private CustomerEntity customer;
	
	@Column(name = "accountNumber")
	private String accountNumber;
	
    @Column(name = "type")
    private String type;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private Date   creationDate;
	
	@ManyToOne
	@JoinColumn(name="balance_id", referencedColumnName = "id")
    private Balance balance;
	

}
