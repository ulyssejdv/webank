@featureTest
@baacst
Feature : les relevés de compte de l’utilisateurs doivent être accessibles de manière pérenne (>= 5 ans) sur un système de fichier redondé

  @Scenario
  Scenario: Les PDF sont accessibles quand tous les datanode du cluster sont fonctionnel
    Given the customer 1 have a bank account statement in DFS
    And all datanodes are up
    When baacst-service is requested at "/baacst-service/1/customer/1"
    Then the response is an array og byte
    And the http response code is 200

  #@Scenario
  #Scenario: Les PDF sont accessibles si il reste au moins un datanode actif sur le cluster
  #  Given le customer 1 possède un relevé de compte en PDF dans le cluster DFS
  #  And un datanode du cluster est up
  #  When le service est appelé sur l’URL /baacst-service/1/customer/1
  #  Then la réponse du service est un pdf

  #@Scenario
  #Scenario : Les PDF ne sont pas accessible si aucun datanode n’est actif
  #  Given le customer 1 possède un relevé de compte en PDF dans le cluster DFS
  #  And aucun datanode du cluster est up
  #  When le service est appelé sur l’URL /baacst-service/1/customer/1
  #  Then la réponse du service est un code erreur 404
