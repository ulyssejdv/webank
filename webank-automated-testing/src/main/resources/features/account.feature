@featureTest
@account
Feature: We are testing an account display retrieves from the database into a SOA architecture
	
	
	@Scenario
	Scenario: The display of an account
	
	Given there are account registred in the database at "http://10.168.1.4:25000/data-access-service/account"
	When the user request an account
	Then the account with the id "1" is displaying