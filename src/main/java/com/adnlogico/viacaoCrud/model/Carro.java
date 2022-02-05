/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adnlogico.viacaoCrud.model;

import com.adnlogico.viacaoCrud.model.Modelo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "carro")
@Entity
public class Carro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_carro")
    private Long id;
    private String matricula;
    @OneToOne
    @JoinColumn(name = "fk_modelo",referencedColumnName = "pk_modelo")
    private Modelo modelo;   
    @ManyToMany
    @JoinTable(name = "pessoa_carro",
            joinColumns = @JoinColumn(name = "fk_carro"),
            inverseJoinColumns = @JoinColumn(name = "fk_pessoa"))
    private List<Pessoa> pessoas;
}
