/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adnlogico.viacaoCrud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Data
@Table(name = "pessoa")
@Entity
public class Pessoa implements Serializable{

    @ManyToOne
    private Carro carro;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_pessoa")
    private Long id;
    @Column(name = "bilhete_identidade",nullable = false,unique = true)
    private String identidade;
    private String nome;
    private String sobrenome;
    @Column(name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
   
    @ManyToMany(mappedBy = "pessoas")
    private List<Carro> propriedades;
    
}
