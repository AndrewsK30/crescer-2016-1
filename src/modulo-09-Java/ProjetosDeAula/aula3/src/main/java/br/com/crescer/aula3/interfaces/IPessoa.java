package br.com.crescer.aula3.interfaces;

import br.com.crescer.aula3.dto.Pessoa;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 */
public interface IPessoa {

    void insert(Pessoa pessoa);

    void update(Pessoa pessoa);

    void delete(Pessoa pessoa);

    List<Pessoa> listAll();

    List<Pessoa> findNome(String nome);
}
