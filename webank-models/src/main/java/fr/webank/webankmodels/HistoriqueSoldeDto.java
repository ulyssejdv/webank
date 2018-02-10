package fr.webank.webankmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@Builder
@ToString
public class HistoriqueSoldeDto {
    private Long    historiqueId;
    private Long    idClient;
    private String name;
    private Integer month;
    private Integer year;
    private Integer nbChildren;
    private Integer categorie;
    private String categorieDesc;
    private Double solde;

    public HistoriqueSoldeDto() {
    }

    public HistoriqueSoldeDto(Long historiqueId, Long idClient, String name, Integer month, Integer year, Integer nbChildren, Integer categorie, String categorieDesc, Double solde) {
        this.historiqueId = historiqueId;
        this.idClient = idClient;
        this.name = name;
        this.month = month;
        this.year = year;
        this.nbChildren = nbChildren;
        this.categorie = categorie;
        this.categorieDesc = categorieDesc;
        this.solde = solde;
    }

    public HistoriqueSoldeDto(Long idClient, Integer month, Integer year, Double solde) {
        this.historiqueId = Long.parseLong("0");
        this.idClient = idClient;
        this.name = "";
        this.month = month;
        this.year = year;
        this.nbChildren = 0;
        this.categorie = 0;
        this.categorieDesc = "";
        this.solde = solde;
    }

    public Long getHistoriqueId() {
        return historiqueId;
    }

    public void setHistoriqueId(Long historiqueId) {
        this.historiqueId = historiqueId;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNbChildren() {
        return nbChildren;
    }

    public void setNbChildren(Integer nbChildren) {
        this.nbChildren = nbChildren;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public String getCategorieDesc() {
        return categorieDesc;
    }

    public void setCategorieDesc(String categorieDesc) {
        this.categorieDesc = categorieDesc;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
