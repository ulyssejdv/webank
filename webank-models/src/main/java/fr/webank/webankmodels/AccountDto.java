package fr.webank.webankmodels;

import java.util.Date;
import java.util.List;



public class AccountDto {

    private Integer	idAccount;
    private CustomerDto customer;
    private String accountNumber;
    private String type;
	private Date   creationDate;
	private List<BalanceDto> listBalance;


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

	public AccountDto(){
    }

    public AccountDto(Integer idAccount,CustomerDto customer){
        this.idAccount=idAccount;
        this.customer=customer;
    }

    public AccountDto(Integer idAccount,CustomerDto customer,String accountNumber ){
        this.idAccount = idAccount;
        this.customer = customer;
        this.accountNumber = accountNumber;
    }


    public Integer getIdAccount() {return idAccount;}

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public CustomerDto getCustomer(){
        return customer;
    }
    public void setCustomer(CustomerDto customer){
        this.customer=customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public List<BalanceDto> getListBalance() {
        return listBalance;
    }

    public void setListBalance(List<BalanceDto> listBalance) {
        this.listBalance = listBalance;
    }


}
