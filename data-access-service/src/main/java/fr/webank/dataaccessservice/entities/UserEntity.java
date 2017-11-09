package fr.webank.dataaccessservice.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ulysse on 09/11/2017.
 */
@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;
}
