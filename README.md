# Backend Webank

Projet modulaire maven !

Certains des modules présent exposent des interfaces REST qui se lancent avec la commande suivante :

`mvn spring-boot:run`

D'autres modules sont des utilitaires pour porte des classes communes à différents modules

### Si vous créez de nouveaux modules, il faut les ajouter dans le POM parent 




Externalisation des parametre spring

`SPRING_APPLICATION_JSON='{"spring": {"datasource": {"url": "jdbc:postgresql://localhost:5432/webank"}}}' java -jar target/data-access-service-1.0.0.jar`



java -jar target/data-access-service-1.0.0.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/webank