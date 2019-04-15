package fr.formation.beans;

import java.sql.Date;

/**
 * 
 * @author pn
 *
 */
public class Employee {
	private Integer empId;
	private String firstName;
	private String lastName;
	private String title;
	private Date startDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Employee( String firstName, String lastName, String title) {		
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", StartDate="+ startDate+"]";
	}
	
	
	

}
