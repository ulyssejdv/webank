data = read.csv("C:/Users/Aaron/Documents/Esiag/ING3/PDS/R/Echantillon.csv")

View(data)
plot(model)


model <- lm(`x` ~ chomage+inflation+PIB, data = data)
summary(model)$r.squared 


#Chomage fictif + Inflation Fictive + PIB fictif
new_data <- data.frame(chomage = c(9, 10, 8, 8.5, 7), inflation = c(0.35, 0.42, 1.25, 1.48, 1.12), PIB = c(38000, 41000, 42000, 39578, 40000))
prediction <- predict(model, new_data)
View(prediction)



