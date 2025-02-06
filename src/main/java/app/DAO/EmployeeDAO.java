package app.DAO;

import app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeDAO
{

    private static EntityManagerFactory emf;
    private static EmployeeDAO instance;

    private EmployeeDAO(){}

    public static EmployeeDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new EmployeeDAO();
        }
        return instance;
    }

    public List<Employee> getAllEmployees(){
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employee = query.getResultList();
            return employee;
        }
    }
}
