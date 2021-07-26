import entity.Empleado;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

                // AGREGAR EMPLEADO

//            Empleado deiver = new Empleado();
//            deiver.setId(6);
//            deiver.setFirstName("Deiver");
//            deiver.setLastName("Rovira");
//            entityManager.persist(deiver);

                // EJECUTAR UN NAMEQUERY @NAMEQUERY --> EMPLEADO.JAVA

//            TypedQuery<Empleado> empByDeptQuery = entityManager.createNamedQuery("Empleado.ByDept", Empleado.class);
//            empByDeptQuery.setParameter(1,"Defensor Java");
//            for (Empleado hola : empByDeptQuery.getResultList()){
//                System.out.println(hola);
//            }


            Query countEmpByDept = entityManager.createNativeQuery("SELECT  COUNT(*) FROM empleado INNER JOIN  departamento d on empleado.department_id = d.id WHERE D.name=:deptName");
            countEmpByDept.setParameter("deptName", "Defensor Java");
            System.out.println("Tenemos  a " + countEmpByDept.getSingleResult() + " Defensores de Java");

            transaction.commit();
        }


        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
