@featureTest
@ws-stocks
Feature: ws-stocks

  @Scenario
  Scenario: Get all stocks from data base

    Given the rest frontend service at "http://10.168.1.4:25000/data-access-service/stocks?size=10&page=2"
    When  request the list of stocks
    Then  checks the results
