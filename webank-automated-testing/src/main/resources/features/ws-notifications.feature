@featureTest @ws-notifications
Feature: ws-notifications

  @Scenario
  Scenario: Get a client's transaction notifications by calling the dedicated web service


    Given the rest notifications web service at "http://localhost:25000/data-access-service/notifications/1"
    When  request the customer with the id notifications
    Then  check that the received data is consistent with the created transaction

