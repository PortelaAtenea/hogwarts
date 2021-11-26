import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {


            EntityManagerFactory enf = Persistence.createEntityManagerFactory("default");
            EntityManager em = enf.createEntityManager();
            em.getTransaction().begin();



/*
            Query q = em.createNamedQuery("consultar_trabajadores", Employee.class);
            List<Employee> l =q.getResultList();
            for(Employee emp : l){
                System.out.println(emp);
            }*/
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
