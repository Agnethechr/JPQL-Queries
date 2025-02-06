package app;

import app.DAO.EmployeeDAO;
import app.config.HibernateConfig;
import app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class Main {
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final EmployeeDAO employeeDAO = EmployeeDAO.getInstance(emf);

    public static void main(String[] args) {



        try{
            List<Employee> employees = employeeDAO.getAllEmployees();
            System.out.println("All employees; ");
            employees.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        finally
        {
            shutdown();
        }


    }
    private static void shutdown(){
        if(emf !=null && emf.isOpen()){
            emf.close();
            System.out.println("emf is closed");
        }
    }
}