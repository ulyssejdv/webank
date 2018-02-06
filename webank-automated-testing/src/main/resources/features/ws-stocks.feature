@featureTest
@ws-stocks
Feature: Nous devons récupérer le nombre demandé des titre selon page et size

  @Scenario
  Scenario: Get all stocks from data base

    Given the rest frontend service at "http://localhost:25000/data-access-service/stocks?size=10&page=1"
    When  request the list of stocks
    Then  checks the results

  @Scenario
  Scenario: Get all stocks from data base and paginate

    Given the rest frontend service at "http://localhost:25000/data-access-service/stocks"
    When  request the list of stocks
    Then  choose stock id from results
    Then  request the stock details
    Then  checks the stock details

  @Scenario
  Scenario: Get stocks from data base with search criteria

    Given the stoks filtred list rest frontend service at "http://localhost:25000/data-access-service/stocks?size=10&page=1&search=AA"
    When  request the list of stocks
    Then  checks the filtered results

