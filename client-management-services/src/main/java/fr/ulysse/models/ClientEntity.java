package fr.ulysse.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ulysse on 19/10/2017.
 */
@Data
@Entity(name = "users")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;
}
