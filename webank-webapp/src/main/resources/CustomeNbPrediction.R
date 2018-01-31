data = read.csv("C:/Users/Aaron/Documents/Esiag/ING3/PDS/R1/R/Echantillon.csv")

View(data)
plot(model)

model <- lm(`x` ~ chomage+inflation+PIB+annee+mois, data = data)
summary(model)$r.squared 

cat("Voici les prédictions pour les 5 prochaines années : ")

#Chomage fictif + Inflation Fictive + PIB fictif
new_data <- data.frame(chomage = c(9, 10, 8, 8.5, 7), inflation = c(0.35, 0.42, 1.25, 1.48, 1.12), PIB = c(38000, 41000, 42000, 39578, 40000), 
annee = c(2018, 2019, 2020, 2021, 2022), mois = c(1, 1, 1, 1, 1))
prediction <- predict(model, new_data)
View(prediction)

summary(model)

# Cr�ation d'une palette de couleur personnalis�e bas�e sur le vert
col <- colorRampPalette(c(
                        # Valeurs positives (0;1)
                        "#FFFFFF", "#8fff63", "#81e740", "#8ee725", "#6dc717", "#3b9626"))
# Cr�ation de la matrice de corr�lation
r <- cor(data)
# Chargement de la librairie
library(corrplot)
# Affichage de la matrice de corr�lation
corrplot(abs(r),
         type = "upper",
         method="number",
         col= col(10),
         cl.lim = c(0,1), #Echelle
         insig = "blank",
         tl.col="black", #Couleur des �tiquettes
         tl.srt=45, #Rotation des �tiquettes de textes
         diag = TRUE #Cacher les coefficients de corr�lation sur la diagonale
)


#Matrice de confusion et erreur en resubstituion
pred <- predict(model, newdata = data)
mc <- table(data$x,pred) #matrice de confusion
print(mc)
err.resub <- 0.25 - (mc[1,1] +mc[2,2])/sum(mc)
print(err.resub)


#Déterminer le numéro de bloc de chaque individu
n <- nrow(data) #Nombre d'observations
K <- 10 #Pour 10-validation croisée
taille <- n%/%K #déterminer le taille de chaque bloc
set.seed(5) #Pour obtenir la même séquence tout le temps
alea <- runif(n) #Générer une colonne de valeurs aléatoires
rang <- rank(alea) #Associer à chaque individu un rang
bloc <- (rang-1)%/%taille+1 #Associer à chaque individu un numéro de bloc
bloc <- as.factor(bloc) #Transformer en facteur
print(summary(bloc)) #Impression de contrôle

#Lancer la validation croisée
all.err <- numeric(0)
for (k in 1:K){
	#Apprendre le modèle sur tous les individus sauf le bloc k
	validation <-lm(`x` ~ chomage+inflation+PIB+annee+mois, data = data[bloc!=k,])
	#Appliquer le modèle sur le bloc numéro K
	pred <- predict(validation,newdata=data[bloc==k,])
	#Matrice de confusion
	mc <- table(data$x[bloc==k], pred)
	#Taux d'erreur
	err <- 0.35 - (mc[1,1] +mc[2,2])/sum(mc)
	#Conserver
	all.err <- rbind(all.err,err)
}
#Vecteur des erreurs recueillies
print(all.err)


#Erreur en validation croisée
#On peut se contenter d'une moyenne non pondérée puisque les blocs sont
#de taille identique
err.cv <- mean(all.err)
print(err.cv)





