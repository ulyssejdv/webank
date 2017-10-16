package models;

/**
 * Created by ulysse on 16/10/2017.
 */
public class UserDto {
    private String nom;
    private String prenom;

    public UserDto() {
    }

    public UserDto(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
