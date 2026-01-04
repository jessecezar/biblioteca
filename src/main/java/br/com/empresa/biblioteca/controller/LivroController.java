package br.com.empresa.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.biblioteca.model.Livro;
import br.com.empresa.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> findAll() { 
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        if (livro != null) {
            return ResponseEntity.ok().body(livro);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Livro> addNew(@RequestBody Livro livro) {
        Livro novoLivro = livroService.addNew(livro);
        return ResponseEntity.ok().body(novoLivro);
    }

    @PostMapping("/cadastrar/lote")
    public ResponseEntity<List<Livro>> addNewBatch(@RequestBody List<Livro> livros) {
        List<Livro> novos = livroService.addAll(livros);
        return ResponseEntity.ok().body(novos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livroAlterado) {
        Livro livroAtualizado = livroService.update(id, livroAlterado);
        if (livroAtualizado != null) {
            return ResponseEntity.ok().body(livroAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        Boolean deleted = livroService.deleteByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
