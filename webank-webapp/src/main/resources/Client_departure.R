library(rpart)


data = read.csv("C:/Users/Aaron/Downloads/Echantillon_CD.csv")
View(data)

ad.data <- rpart (`y` ~ chomage + nbmois + decouv + enfant + marie + salaire
, data)
summary(ad.data)$r.squared 


new_data <- data.frame(chomage = c(1), nbmois = c(4), decouv = c(1), 
enfant = c(2), marie = c(1), salaire = c(1400))
prediction <- predict(ad.data, new_data)

ypred = (predict(ad.data, new_data)>0.5)*1

View(ypred)


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
pred <- predict(ad.data, newdata = data)
mc <- table(data$y,pred) #matrice de confusion
print(mc)
err.resub <- 1.0 - (mc[1,1] +mc[2,2])/sum(mc)
print(err.resub)


#D�terminer le num�ro de bloc de chaque individu
n <- nrow(data) #Nombre d'observations
K <- 10 #Pour 10-validation crois�e
taille <- n%/%K #d�terminer le taille de chaque bloc
set.seed(5) #Pour obtenir la m�me s�quence tout le temps
alea <- runif(n) #G�n�rer une colonne de valeurs al�atoires
rang <- rank(alea) #Associer � chaque individu un rang
bloc <- (rang-1)%/%taille+1 #Associer � chaque individu un num�ro de bloc
bloc <- as.factor(bloc) #Transformer en facteur
print(summary(bloc)) #Impression de contr�le

#Lancer la validation crois�e
all.err <- numeric(0)
for (k in 1:K){
	#Apprendre le mod�le sur tous les individus sauf le bloc k
	arbre <- rpart(`y` ~ chomage+nbmois+decouv+enfant+marie+salaire, data = data[bloc!=k,])
	#Appliquer le mod�le sur le bloc num�ro K
	pred <- predict(arbre,newdata=data[bloc==k,])
	#Matrice de confusion
	mc <- table(data$y[bloc==k], pred)
	#Taux d'erreur
	err <- 1.0 - (mc[1,1] +mc[2,2])/sum(mc)
	#Conserver
	all.err <- rbind(all.err,err)
}
#Vecteur des erreurs recueillies
print(all.err)


#Erreur en validation crois�e
#On peut se contenter d'une moyenne non pond�r�e puisque les blocs sont
#de taille identique
err.cv <- mean(all.err)
print(err.cv)

print(head(summary(ad.data),6))


