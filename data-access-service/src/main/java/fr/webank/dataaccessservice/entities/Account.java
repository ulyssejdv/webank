package fr.webank.dataaccessservice.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "account", schema = "public")
public class Account {

    private Integer	idAccount;
    private Customer customer;
    private String accountNumber;
    private String type;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   creationDate;
	private List<Balance> listBalance;

    public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Account(){
    }

    public Account(Integer idAccount,Customer customer){
        this.idAccount=idAccount;
        this.customer=customer;
    }

    public Account(Integer idAccount,Customer customer,String accountNumber ){
        this.idAccount = idAccount;
        this.customer = customer;
        this.accountNumber = accountNumber;
    }



    @Id
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {return idAccount;}

    public void setId(Integer idAccount) {
        this.idAccount = idAccount;
    }

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }


    @Column(name = "accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    @OrderBy("date DESC")
    public List<Balance> getListBalance() {
        return listBalance;
    }

    public void setListBalance(List<Balance> listBalance) {
        this.listBalance = listBalance;
    }


}
