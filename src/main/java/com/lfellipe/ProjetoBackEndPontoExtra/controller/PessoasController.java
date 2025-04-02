package com.lfellipe.ProjetoBackEndPontoExtra.controller;

import com.lfellipe.ProjetoBackEndPontoExtra.entity.Pessoas;
import com.lfellipe.ProjetoBackEndPontoExtra.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//http://localhost:8080/pessoas
@Controller
@RequestMapping("/pessoas")
public class PessoasController {




    private PessoasRepository pessoasRepository;

    public PessoasController(@Autowired PessoasRepository pessoasRepository) {
        this.pessoasRepository = pessoasRepository;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return new ResponseEntity(pessoasRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping ResponseEntity post(@RequestBody Pessoas pessoa){
        return new ResponseEntity(pessoasRepository.save(pessoa), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity put(@RequestBody Pessoas pessoa){

        Optional<Pessoas> pessoasToEdit = pessoasRepository.findById(pessoa.getId());

        if(pessoasToEdit.isPresent()){
            return new ResponseEntity(pessoasRepository.save(pessoa), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        Optional<Pessoas> pessoasToEdit = pessoasRepository.findById(id);

        if(pessoasToEdit.isPresent()){
        pessoasRepository.deleteById(id);
        return new ResponseEntity("Nome removido com sucesso!", HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }
}
