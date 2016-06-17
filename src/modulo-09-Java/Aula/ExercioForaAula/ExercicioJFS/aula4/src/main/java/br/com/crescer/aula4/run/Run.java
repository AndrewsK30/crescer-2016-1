package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Carlos H. Nonnemacher
 */
public class Run {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        final EntityManager em = emf.createEntityManager();

        PessoaDAO dao = new PessoaDAO(em);

        DAO<Pessoa> dao1 = new DAO<Pessoa>(Pessoa.class) {
            @Override
            public EntityManager getEntityManager() {
               return em;
            }
        };

    }

}
