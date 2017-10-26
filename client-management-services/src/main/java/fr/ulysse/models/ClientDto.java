package fr.ulysse.models;


import lombok.Data;

/**
 * Created by ulysse on 17/10/2017.
 */
@Data
public class ClientDto {

    private Long id;
    private String nom;
    private String prenom;

    public ClientDto() {
    }

    public ClientDto(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
