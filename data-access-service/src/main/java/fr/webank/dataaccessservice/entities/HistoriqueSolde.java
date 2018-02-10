package fr.webank.dataaccessservice.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ayda Najjar.
 */


@Entity
@Table(name = "historiquesolde", schema = "public")
public class HistoriqueSolde {

    public HistoriqueSolde() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historiqueid")
    private Long    historiqueId;

    @Column(name = "idclient")
    private Long    idClient;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "nbchildren")
    private Integer nbChildren;

    @Column(name = "idcategorie")
    private Integer categorie;

    @Column(name = "categoriedesc", length = 50)
    private String categorieDesc;

    @Column(name = "solde")
    private Double solde;

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
