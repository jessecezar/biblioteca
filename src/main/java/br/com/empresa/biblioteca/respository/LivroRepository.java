package br.com.empresa.biblioteca.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
