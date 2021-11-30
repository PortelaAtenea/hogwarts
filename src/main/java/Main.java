import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {

        try {

            EntityManagerFactory enf = Persistence.createEntityManagerFactory("default");
            EntityManager em = enf.createEntityManager();
            em.getTransaction().begin();

            TypedQuery<Person> query = em.createNamedQuery("MaxPuntosDados", Person.class);
            TypedQuery<Person> query2 = em.createNamedQuery("MaxPuntosRecibidos", Person.class);
            Person pGiver = query.getSingleResult();
            Person pReceiver = query2.getSingleResult();
            commit(em, enf);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }




    public static void commit(EntityManager em, EntityManagerFactory enf) {
        em.getTransaction().commit();
        em.close();
        enf.close();
    }
}
