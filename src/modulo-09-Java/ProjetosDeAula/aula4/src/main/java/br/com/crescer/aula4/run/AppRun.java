package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Amigo;
import br.com.crescer.aula4.entity.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Carlos H. Nonnemacher
 */
public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        em.getTransaction().begin();
        
        Usuario usuarioAmigo = new Usuario();
        usuarioAmigo.setNome("Teste");
        em.persist(usuarioAmigo);
        
        
        Usuario usuario = em.find(Usuario.class, 2l);
        Amigo amigo = new Amigo();
        amigo.setData(new Date());
        amigo.setUsuario(usuario);
        amigo.setUsuarioAmigo(usuarioAmigo);
        usuario.getAmigos().add(amigo);

        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
