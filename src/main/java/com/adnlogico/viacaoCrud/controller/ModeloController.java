/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adnlogico.viacaoCrud.controller;

import com.adnlogico.viacaoCrud.model.Modelo;
import com.adnlogico.viacaoCrud.repository.ModeloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adn
 */
@RestController
@RequestMapping("/modelos")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Modelo>> listar(){
        if(this.modeloRepository.findAll().isEmpty())
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(this.modeloRepository.findAll(),HttpStatus.FOUND);
    }
    
    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Modelo salvar(@RequestBody Modelo modelo){
        return this.modeloRepository.save(modelo);
    }
    
    @PutMapping("/editar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> editar(@RequestBody Modelo modelo){
        Optional<Modelo> pesquisado = this.modeloRepository.findById(modelo.getId());
           if(pesquisado.isPresent())
            return new ResponseEntity<> (this.modeloRepository.save(modelo),HttpStatus.OK);
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> apagar(@PathVariable("id") Long id){
        Optional<Modelo> pesquisado = modeloRepository.findById(id);
        if(pesquisado.isPresent()){
            this.modeloRepository.delete(pesquisado.get());
            return new ResponseEntity<> (HttpStatus.GONE);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }
    
}
