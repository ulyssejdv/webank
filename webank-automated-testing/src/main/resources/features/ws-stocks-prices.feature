@featureTest
@ws-stocks-prices
Feature: test la génération des cours de titre

  @Scenario
  Scenario: Get stock prices from data base

    Given the rest frontend stock price service at "http://localhost:25000/data-access-service/stocks/MSFT"
    When  request the stock price
    Then  check stock price less than max price
    And   check stock price great than max price

