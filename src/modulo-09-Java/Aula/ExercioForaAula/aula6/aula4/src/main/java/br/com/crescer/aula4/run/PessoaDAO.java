package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Pessoa;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDAO extends DAO<Pessoa> {

    final EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        super(Pessoa.class);
        this.entityManager = entityManager;
        
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
