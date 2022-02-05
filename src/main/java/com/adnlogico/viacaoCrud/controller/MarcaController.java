/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.adnlogico.viacaoCrud.controller;

import com.adnlogico.viacaoCrud.model.Marca;
import com.adnlogico.viacaoCrud.repository.MarcaRepository;
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

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")/*Permite acesso da API na front-end*/
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",methods = RequestMethod.GET)
    public ResponseEntity<List<Marca>> listar(){
        if(!this.marcaRepository.findAll().isEmpty())
            return new ResponseEntity<>(this.marcaRepository.findAll(),HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> salvar (@RequestBody Marca marca){
        return new ResponseEntity<>(this.marcaRepository.save(marca),HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Marca marca){
        Optional<Marca> pesquisado = this.marcaRepository.findById(marca.getId());
        if(pesquisado.isPresent())
            return new ResponseEntity<>(this.marcaRepository.save(marca),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        Optional<Marca> pesquisado = this.marcaRepository.findById(id);
        if(pesquisado.isPresent())
        {
            this.marcaRepository.delete(pesquisado.get());
            return new ResponseEntity<>(HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
