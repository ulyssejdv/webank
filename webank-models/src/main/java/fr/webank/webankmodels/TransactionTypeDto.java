package fr.webank.webankmodels;



public class TransactionTypeDto {
	
	private Integer idTransactionType;
	private String transactionTypeName;
	
	public TransactionTypeDto() {
	}

	public TransactionTypeDto(Integer idTransaction, String transactionTypeName) {

		this.idTransactionType	= idTransactionType;
		this.transactionTypeName= transactionTypeName;
		}
	
	public Integer getIdTransactionType() {
		return idTransactionType;
	}
	public void setIdTransactionType(Integer idTransactionType) {
		this.idTransactionType = idTransactionType;
	}
	
	public String getTransactionTypeName() {
		return transactionTypeName;
	}
	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

}
