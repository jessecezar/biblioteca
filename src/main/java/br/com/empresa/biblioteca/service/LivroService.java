package br.com.empresa.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.biblioteca.model.Livro;
import br.com.empresa.biblioteca.respository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //Listar Livros
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    //Buscar Livro por ID
    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    //Cadastrar Livro
    public Livro addNew(Livro livro) {
        return livroRepository.save(livro);
    }

    //Alterar Livro
    public Livro update(Long id, Livro livroDetails) {
        Livro livro = findById(id);
        if (livro != null) {
            livro.setTitulo(livroDetails.getTitulo());
            livro.setAutor(livroDetails.getAutor());
            livro.setGenero(livroDetails.getGenero());
            livro.setAnoPublicacao(livroDetails.getAnoPublicacao());
            livro.setValor(livroDetails.getValor());
            livro.setDisponivel(livroDetails.getDisponivel());
            return livroRepository.save(livro);
        }
        return null;
    }

    //Cadastrar vários livros (lote)
    public List<Livro> addAll(List<Livro> livros) {
        return livroRepository.saveAll(livros);
    }

    //Deletar Livro
    public Boolean deleteByID(Long id) {
        Livro livro = findById(id);
        if (livro != null) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
