package fr.webank.dataaccessservice.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ulysse on 28/11/2017.
 */
@Data
@Entity(name = "bank_statement")
@ToString
public class BankStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_url")
    private String fileUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(targetEntity = CustomerEntity.class)
    private CustomerEntity customer;
}
