#!/usr/bin/env Rscript
args = commandArgs(trailingOnly=TRUE)

data <- read.csv(file=args[1], header=TRUE, sep=",", encoding="UTF-8")
datapred <- read.csv(file=args[2], header=TRUE, sep=",", encoding="UTF-8")
library(methods)
library(Matrix)
library(lme4)
model2 <- lmer(data = data, SOLDE ~ MOIS + ENFANTS + ANNEE + (1| IDCLIENT))
datapred[,"SOLDE"] = predict(model2, newdata = datapred)
write.csv(datapred, file = args[2]);
