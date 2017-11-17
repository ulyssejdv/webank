package fr.webank.webankmodels;

import java.util.Date;



public class TransactionDto {
	
	private Integer idTransaction;
	private TransactionTypeDto transactionType;
	private AccountDto account;
	private Integer transactionAmount;
	private Date   transactionDate;
	
	public TransactionDto() {
	}

	public TransactionDto(Integer idTransaction, TransactionTypeDto transactionType,Integer transactionAmount,Date transactionDate, AccountDto account) {

		this.idTransaction		= idTransaction;
		this.transactionType 	= transactionType;
		this.transactionAmount	= transactionAmount;
		this.transactionDate 	= transactionDate;
		this.account = account;
		}
	
	
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	
	public Integer getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
    public TransactionTypeDto getTransactionType(){
        return transactionType;
    }
    public void setTransactionType(TransactionTypeDto transactionType){
        this.transactionType=transactionType;
    }
    
    public AccountDto getAccount() {return account;}
    public void setAccount(AccountDto account) {
        this.account =account;
    }

}
