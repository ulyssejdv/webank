@featureTest
@ws-stocks-prices
Feature: ws-stocks-prices

  @Scenario
  Scenario: Get stock prices from data base

    Given the rest frontend stock price service at "http://10.168.1.4:25000/data-access-service/stocks/FR0000120404 AC"
    When  request the stock price
    Then  check stock price less than max price
    And   check stock price great than max price

