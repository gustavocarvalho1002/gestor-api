package com.gestor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
public class GestorController {
	
    @Autowired
    GestorRepository GestorRepository;
    
    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok(GestorRepository.findAll());
    }
    
    @GetMapping(value = "/gestor")
    public ResponseEntity getBucket(@RequestParam(value="id") Long id) {
        Optional<GestorModel> foundGestorModel = GestorRepository.findById(id);
        if(foundGestorModel.isPresent()){
            return ResponseEntity.ok(foundGestorModel.get());
        }else {
            return ResponseEntity.badRequest().body("Não foi encontrado nenhum gestor com esse ID: " + id);
        }
    }
    
    @PostMapping(value = "/")
    public ResponseEntity addToGestorModel(@RequestParam(value="nome") String nome, @RequestParam(value="matricula") String matricula, @RequestParam(value="dataDeNascimento") String dataDeNascimento, @RequestParam(value="setor") String setor ) {
        return ResponseEntity.ok(GestorRepository.save(new GestorModel(nome, matricula, dataDeNascimento, setor)));
    }
    
    @PutMapping(value = "/")
    public ResponseEntity updateGestorModel(@RequestParam(value="id") Long id, @RequestParam(value="nome") String nome,  @RequestParam(value="matricula") String matricula, @RequestParam(value="dataDeNascimento") String dataDeNascimento, @RequestParam(value="setor") String setor ) {
        Optional<GestorModel> optionalGestorModel = GestorRepository.findById(id);
        if(!optionalGestorModel.isPresent()){
            return ResponseEntity.badRequest().body("Não foi encontrado nenhum gestor com esse ID: " + id);
        }
        GestorModel foundGestorModel = optionalGestorModel.get();
        foundGestorModel.setNome(nome);
        foundGestorModel.setMatricula(matricula);
        foundGestorModel.setDataDeNascimento(dataDeNascimento);
        foundGestorModel.setSetor(setor);
        return ResponseEntity.ok(GestorRepository.save(foundGestorModel));
    }
    
    @DeleteMapping(value = "/")
    public ResponseEntity removeGestorModel(@RequestParam(value="id") Long id) {
        GestorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}