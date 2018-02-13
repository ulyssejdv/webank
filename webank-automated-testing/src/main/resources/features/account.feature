@featureTest
@account
Feature: We are testing an account display retrieves from the database into a SOA architecture
	
	
	@Scenario
	Scenario: The display of an account
	
	Given there are account registred in the database at "http://data-access-service:25000/data-access-service/account/1"
	When the user request an account
	Then the account with the id "1" is displaying