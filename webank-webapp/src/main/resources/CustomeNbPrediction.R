data = read.csv("C:/Users/Aaron/Documents/Esiag/ING3/PDS/R1/R/Echantillon.csv")

View(data)
plot(model)

model <- lm(`x` ~ chomage+inflation+PIB+annee+mois, data = data)
summary(model)$r.squared 


#Chomage fictif + Inflation Fictive + PIB fictif
new_data <- data.frame(chomage = c(9, 10, 8, 8.5, 7), inflation = c(0.35, 0.42, 1.25, 1.48, 1.12), PIB = c(38000, 41000, 42000, 39578, 40000), 
annee = c(2018, 2019, 2020, 2021, 2022), mois = c(1, 1, 1, 1, 1))
prediction <- predict(model, new_data)
View(prediction)

summary(model)

# Création d'une palette de couleur personnalisée basée sur le vert
col <- colorRampPalette(c(
                        # Valeurs positives (0;1)
                        "#FFFFFF", "#8fff63", "#81e740", "#8ee725", "#6dc717", "#3b9626"))
# Création de la matrice de corrélation
r <- cor(data)
# Chargement de la librairie
library(corrplot)
# Affichage de la matrice de corrélation
corrplot(abs(r),
         type = "upper",
         method="number",
         col= col(10),
         cl.lim = c(0,1), #Echelle
         insig = "blank",
         tl.col="black", #Couleur des étiquettes
         tl.srt=45, #Rotation des étiquettes de textes
         diag = TRUE #Cacher les coefficients de corrélation sur la diagonale
)







