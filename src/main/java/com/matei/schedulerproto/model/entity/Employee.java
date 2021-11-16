package com.matei.schedulerproto.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Employee {

    @Id
    private Long id;

    @Column(nullable = false)
    private String GBU;
    @Column(nullable = false)
    private String proiect;
    @Column(nullable = false)
    private String TGI;
    @Column(nullable = false)
    private String prenume;
    @Column(nullable = false)
    private Date dataNastere;
    @Column(nullable = false)
    private Date dataAngajare;
}
