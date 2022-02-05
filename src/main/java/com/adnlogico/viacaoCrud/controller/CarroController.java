/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.adnlogico.viacaoCrud.controller;

import com.adnlogico.viacaoCrud.model.Carro;
import com.adnlogico.viacaoCrud.repository.CarroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author adn
 */
@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "http://localhost:4200",
        allowedHeaders = "*")
public class CarroController {
    
    @Autowired
    private CarroRepository carroRepository;
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Carro>> findAll(){
        if(!this.carroRepository.findAll().isEmpty())
            return new ResponseEntity<>(this.carroRepository.findAll(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> salvar(@RequestBody Carro carro){
        return new ResponseEntity<>(this.carroRepository.save(carro),HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id,@RequestBody Carro carro){
        Optional<Carro> pesquisado = this.carroRepository.findById(id);
        if(pesquisado.isPresent())
            return new ResponseEntity<>(pesquisado.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/deletar")
    public ResponseEntity<?> apagar (@PathVariable Long id){
        Optional<Carro> pesquisado = this.carroRepository.findById(id);
        if(pesquisado.isPresent()){
            this.carroRepository.delete(pesquisado.get());
            return new ResponseEntity<>(HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}
