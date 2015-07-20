package hibernatejsf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This Class is a POJO Class of Employees.
 * @author Matheus Silva de Almeida "almeida-matheus@hotmail.com.br".
 * @version 1.0
 * @since 17/07/2015 14:32:22
 */

/**
 * This Annotation says the Class is one Entity of database. 
 */
@Entity

/**
 * This Annotation says the Class is one Table, and the property "name" says what is name Table . 
 */
@Table(name="employees")
public class EmployeeModel {
	
	/**
	 * This Annotation says the entity is the primary key of the table.
	 */	
	@Id
	
	/**
	 * This Annotation says this entity have value incremented automatically.
	 */
	@GeneratedValue
	
	/**
	 * This Annotation says the variable is one entity, the property "name" says what is name of the table and 
	 * the property "nullable" says if the entity can be null.
	 */
	@Column(name="ID_EMPLOYEE",nullable=false)
	protected long idEmployee;
	
	@Column(name="NAME_EMPLOYEE")
	protected String nameEmployee;
	
	@Column(name="SURNAME_EMPLOYEE")
	protected String surnameEmployee;
	
	@Column(name="AGE_EMPLOYEE")
	protected int ageEmployee;
	
	@Column(name="SEX_EMPLOYEE")
	protected int sexEmployee;
	
	public long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public String getSurnameEmployee() {
		return surnameEmployee;
	}
	public void setSurnameEmployee(String surnameEmployee) {
		this.surnameEmployee = surnameEmployee;
	}
	public int getAgeEmployee() {
		return ageEmployee;
	}
	public void setAgeEmployee(int ageEmployee) {
		this.ageEmployee = ageEmployee;
	}
	public int getSexEmployee() {
		return sexEmployee;
	}
	public void setSexEmployee(int sexEmployee) {
		this.sexEmployee = sexEmployee;
	}
	
}
