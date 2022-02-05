/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.adnlogico.viacaoCrud.repository;

import com.adnlogico.viacaoCrud.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adn
 */
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    
}
