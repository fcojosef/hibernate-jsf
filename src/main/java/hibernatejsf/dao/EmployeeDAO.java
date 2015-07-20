package hibernatejsf.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernatejsf.factory.SessionFactoryProvider;
import hibernatejsf.model.EmployeeModel;
/**
 * This Class is responsible for provide access to data(Data Access Object). 
 * @author Matheus Silva de Almeida "almeida-matheus@hotmail.com.br".
 * @version 1.0
 * @since 17/07/2015 13:57:35
 */
public class EmployeeDAO {
	
	SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	
	/**
	 * This is the instance of EmployeeDAO.
	 */
	private static EmployeeDAO instance;
	
	public static EmployeeDAO getInstance(){
		
		if(instance == null){	
			
			instance = new EmployeeDAO();
		}		
		return instance;
	}
	
	/**
	 * This Method is responsible for insert new Employee in table Employees.
	 * @param employeeModel EmployeeModel object.
	 */	
	public void insertEmployee(EmployeeModel employeeModel){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(employeeModel);
		
		transaction.commit();
		session.close();	
	}
	
	/**
	 * This Method is responsible for delete one Employee in table Employees.
	 * @param idEmployee This parameter is primary key of Employee.
	 */	
	public void deleteEmployee(long idEmployee){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		EmployeeModel employeeModel = (EmployeeModel) session.get(EmployeeModel.class,idEmployee);
		
		session.delete(employeeModel);
						
		transaction.commit();
		session.close();
	}
	
	/**
	 * This method is responsible for Update one Employee in table Employees.
	 * @param employeeModel EmployeeModel object.
	 */	
	public void updateEmployee(EmployeeModel employeeModel){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(employeeModel);
		
		transaction.commit();
		session.close();	
	}
	
	/**
	 * This method is responsible for select all employees in table Employees.
	 * @return This return is one ArrayList of EmployeeModel, 
	 * loaded with query results to the Employees table.
	 */	
	public ArrayList<EmployeeModel> selectAllEmployees(){
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
		
		ArrayList<EmployeeModel> listEmployees = (ArrayList<EmployeeModel>) criteria.list();
		
		session.close();
		
		return listEmployees;		
	}
	
	/**
	 * This method is responsible for select one employee in table Employees.
	 * @param idEmployee This parameter is primary key of Employee.
	 * @return This return is one EmployeeModel object, 
	 * loaded with query result to the Employees table.
	 */
	public EmployeeModel selectEmployeeByID(long idEmployee){
	
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
		criteria.add(Restrictions.eq("idEmployee", idEmployee));
		
		EmployeeModel employeeModel = (EmployeeModel) criteria.uniqueResult();
		
		session.close();
		
		return employeeModel;		
	}

}
