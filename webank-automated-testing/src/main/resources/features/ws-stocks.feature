@featureTest
@ws-stocks
Feature: Nous devons récupérer le nombre demandé des titre selon page et size

  @Scenario
  Scenario: Get all stocks from data base

    Given the rest frontend service at "http://10.168.1.4:25000/data-access-service/stocks?size=10&page=2"
    When  request the list of stocks
    Then  checks the results

