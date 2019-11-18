package ie.lyit.bank;

import ie.lyit.bank.Date;
import ie.lyit.bank.Name;

//Employee inherits from the Person class
public class Employee extends Person {
	private Date startDate;
	private double salary;
	private int number = nextNumber;
	private static int nextNumber = 1;
	//maximum_salary is a constant
	private final double MAXIMUM_SALARY = 15000;
	
	//default constructor
	public Employee() throws IllegalArgumentException {
		this.salary = 0;
		this.startDate = new Date();
		this.number = nextNumber++;
	}
	
	//Overloaded constructor
	public Employee(Name name, Date dob, Date startDate, double salary) throws IllegalArgumentException {
		//Calls the constructor of the superclass with the relevant values passed in
		super(name, dob);
		if(salary > this.MAXIMUM_SALARY) {
			throw new IllegalArgumentException("Salary must be lower than " + this.MAXIMUM_SALARY);
		} else {
			this.salary = salary;
		}
		this.startDate = startDate;
		this.number = nextNumber++;
	}	
	
	//set methods - there is no setNumber() method because the number is automatically generated
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	//get methods
	public double getSalary() {
		return this.salary;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	//toString method, overrides the method in the object class. Returns a string containing details about the object
	@Override
	public String toString() {
		return super.name + " -> date of birth: " + super.dateOfBirth + ", startDate: " + 
				this.startDate + ", salary: " + salary;
	}
	
	/*equals method, overrides the method in the object class. Tests whether the object 
	passed in is equal to the class object */
	@Override
	public boolean equals(Object obj) {
		Employee empObject;
		if (obj instanceof Employee)
			empObject = (Employee)obj;
		else
			return false;
	 
		return this.number == empObject.getNumber();
	}
	
	/*adds the amount passed in to the current salary value if the new total is less than the maximum salary. 
	 * If the new total is more than the maximum salary, an IllegalArumentException is thrown.*/
	public void incrementSalary(double incrementAmount) throws IllegalArgumentException {
		if((this.salary + incrementAmount) > MAXIMUM_SALARY)
			throw new IllegalArgumentException("Salary exceeds max salary!");
		else
			this.salary += incrementAmount;
	}
	
	/*Calculates the employee's weekly wage minus the tax they owe. An IllegalArgumentException is thrown if
	the percentage passed in is less than 0 or greater than 100*/
	public double calculateWage(double taxPercentage) throws IllegalArgumentException {
		if(taxPercentage < 0 || taxPercentage > 100)
			throw new IllegalArgumentException("Tax percentage must be between 0 and 100");
		double weeklyWage = salary/12;
		return weeklyWage - (weeklyWage * (taxPercentage/100));
	}
}
