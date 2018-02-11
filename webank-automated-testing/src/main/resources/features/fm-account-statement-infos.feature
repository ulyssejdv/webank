@featureTest
@fm-account-statement-infos
Feature: fm-account-statement-infos

  @Scenario
  Scenario: get informations about account statements

    Given the rest front end url at "http://localhost:25000/baacst-service/1"
    When  request about account informations
    Then  get informations bout account with the given url
    And   retourn the information to the customer

