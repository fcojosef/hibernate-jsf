package hibernatejsf.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import hibernatejsf.dao.EmployeeDAO;
import hibernatejsf.model.EmployeeModel;

@ManagedBean
@ViewScoped
/**
 * This Class is the ManagedBean of the Employees, 
 * ManagedBean is the Class responsible for provide integration of the xhtml page with business rule(Controller). 
 * @author Matheus Silva de Almeida "almeida-matheus@hotmail.com.br".
 * @version 1.0
 * @since 18/07/2015 20:16:25
 */
public class EmployeeManagedBean extends EmployeeModel {
	
	/**
	 * This is a Employees list.
	 */
	private ArrayList<EmployeeModel> listEmployees;	
	
	/**
	 * This is a sexes list.
	 */
	private HashMap<String,Integer> listSex;	

	public ArrayList<EmployeeModel> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(ArrayList<EmployeeModel> listEmployees) {
		this.listEmployees = listEmployees;
	}

	public HashMap<String, Integer> getListSex() {
		return listSex;
	}

	public void setListSex(HashMap<String, Integer> listSex) {
		this.listSex = listSex;
	}

	/**
	 * This Annotation says the following method will executed as soon as the ManagedBean is called. 
	 */
	@PostConstruct
	public void onCreate(){		
		
		/**
		 * Instance of the listEmployees.
		 */
		listEmployees = new ArrayList<EmployeeModel>();		
		
		/**
		 * Instance of the listSex and putting the values.
		 */
		listSex = new HashMap<String, Integer>();		
		listSex.put("Female", 0);
		listSex.put("Male", 1);		
	
		/**
		 * Calling the Method loadListOfEmployess.
		 */
		loadListOfEmployess();
	}
	
	/**
	 * The aim of the method is insert new employee in database.
	 * @return Redirect to the home page.
	 * @throws IOException IOException.
	 */
	public String insertEmployee() throws IOException{
		
		EmployeeModel employeeModel = new EmployeeModel();	
		employeeModel.setAgeEmployee(ageEmployee);
		employeeModel.setNameEmployee(nameEmployee);
		employeeModel.setSurnameEmployee(surnameEmployee);
		employeeModel.setSexEmployee(sexEmployee);	
		
		EmployeeDAO.getInstance().insertEmployee(employeeModel);
		
		loadListOfEmployess();
		return "home.jsf";
	}
	
	/**
	 * The purpose of the method is delete one Employee in database.
	 * @param idEmployee This is primary key of the user in question.
	 */
	public void deleteEmployee(long idEmployee){
		
		EmployeeDAO.getInstance().deleteEmployee(idEmployee);
		loadListOfEmployess();		
	}
	
	/**
	 * The objective of the method is update one Employee.
	 * @param idEmployee This parameter is the primary key of the employee.
	 */
	public void updateEmployee(long idEmployee){	
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setAgeEmployee(this.ageEmployee);
		employeeModel.setNameEmployee(this.nameEmployee);
		employeeModel.setSurnameEmployee(this.surnameEmployee);
		employeeModel.setSexEmployee(this.sexEmployee);		
		employeeModel.setIdEmployee(idEmployee);
				
		EmployeeDAO.getInstance().updateEmployee(employeeModel);
		
		loadListOfEmployess();
	}
	
	/**
	 * 
	 * @param idEmployee This parameter is the primary key of the Employee.
	 */
	public void loadEmployeeForUpdate(long idEmployee){		
		
		EmployeeModel employeeModel = EmployeeDAO.getInstance().selectEmployeeByID(idEmployee);		
		this.nameEmployee = employeeModel.getNameEmployee();
		this.surnameEmployee = employeeModel.getSurnameEmployee();
		this.ageEmployee = employeeModel.getAgeEmployee();
		this.sexEmployee = employeeModel.getSexEmployee();
		this.idEmployee = employeeModel.getIdEmployee();
				
		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		RequestContext.getCurrentInstance().getCurrentInstance().execute("showModal();");	
	}
	
	/**
	 * The aim of the method is to load {@link #listEmployees} with the data from the table Employees.
	 */
	public void loadListOfEmployess(){		
		
		listEmployees = EmployeeDAO.getInstance().selectAllEmployees();		
		
	}

}
