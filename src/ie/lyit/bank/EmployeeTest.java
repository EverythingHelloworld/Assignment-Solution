package ie.lyit.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	private Employee e1;
	private Employee e2;
	private Employee e3;

	//setup method runs before each test
	@Before
	public void setUp() throws Exception {
		e1 = new Employee(new Name("Miss", "Jemma", "Simmons"), new Date(10,12,1990), new Date(23, 05, 2019), 14000);
		e2 = new Employee(new Name("Miss", "Chloe", "Bennett"), new Date(5,5,1980), new Date(10, 04, 2018), 5000);
		e3 = new Employee();
	}
	
	//Tests the toString method in the employee class returns the expected string
	@Test
	public void testToString() {
		assertEquals(e1.toString(), "Miss Jemma Simmons -> date of birth: 10/12/1990, startDate: 23/5/2019, salary: 14000.0");
	}

	//Tests that the instance variables are set to the default values when the default constructor is called
	@Test
	public void testEmployee() {
	assertEquals(1, e3.getDateOfBirth().getDay());
	assertEquals(1, e3.getDateOfBirth().getMonth());
	assertEquals(1900, e3.getDateOfBirth().getYear());
	assertEquals("", e3.getName().getTitle());
	assertEquals("", e3.getName().getFirstName());
	assertEquals("", e3.getName().getSurname());
	assertTrue(0 == e3.getSalary());
	assertEquals(1, e3.getStartDate().getDay());
	assertEquals(1, e3.getStartDate().getMonth());
	assertEquals(1900, e3.getStartDate().getYear());
	}
	
	//Tests the overloaded constructor correctly sets the instance variables
	@Test
	public void testEmployeeNameDateDateDouble() {
		assertEquals(new Date(10,12,1990), e1.getDateOfBirth());
		assertEquals(new Name("Miss", "Jemma", "Simmons"), e1.getName());		
		assertTrue(14000 == e1.getSalary());
		assertEquals(new Date(23,05,2019), e1.getStartDate());
	}
	
	//Tests that an IllegalArgumentException is thrown when the value passed in for salary is higher than the max salary
	@Test(expected = IllegalArgumentException.class)
	public void testEmployeeNameDateDateDoubleThrowsIllegalArgumentExceptionWhenSalaryIsTooHigh() {
		Employee e4 = new Employee(new Name("Mr", "L", "Hunter"), new Date(10,12,2000), new Date(12,12,2018), 100000);
	}
	
	//Tests that the equals method returns true when the objects are equal
	@Test
	public void testEqualsObjectReturnsTrueWhenEmployeeObjectsEqual() {
		assertEquals(true, e1.equals(e1));
	}
	
	//Tests that the equals method returns false when the objects are not equal
	@Test
	public void testEqualsObjectReturnsFalseWhenEmployeeObjectsNotEqual() {
		assertEquals(false, e1.equals(e2));
	}

	//Tests that the set methods for salary, start date, date of birth and name correctly set the variables
	
	@Test
	public void testSetSalary() {
		e1.setSalary(5000);
		assertTrue(5000 == e1.getSalary());
	}

	@Test
	public void testSetStartDate() {
		e2.setStartDate(new Date(15,3,2010));
		assertEquals(new Date(15,3,2010), e2.getStartDate());
	}
	
	@Test
	public void testSetDateOfBirth() {
		e2.setDateOfBirth(new Date(12,10,1970));
		assertEquals(new Date(12,10,1970), e2.getDateOfBirth());
	}

	@Test
	public void testSetName() {
		e2.setName(new Name("Miss", "C.", "Bennett"));
		assertEquals(new Name("Miss", "C.", "Bennett"),e2.getName());
	}
	
	//Tests that the get methods for salary, start date, name and date of birth return the correct values
	
	@Test
	public void testGetSalary() {
		assertTrue(14000.0 == e1.getSalary());
	}

	@Test
	public void testGetStartDate() {
		assertEquals(e2.getStartDate(), new Date(10,04,2018));
	}
	
	@Test
	public void testGetName() {
		assertEquals(new Name("Miss", "Jemma", "Simmons"),e1.getName());
	}
	
	@Test
	public void testGetDateOfBirth() {
		assertEquals(new Date(10,12,1990), e1.getDateOfBirth());
	}	

	//Tests that the salary is set to 15000 when 10000 is passed in (original value of 5000 + 10000)
	@Test
	public void testIncrementSalary() {
		e2.incrementSalary(10000);
		assertTrue(15000.0 == e2.getSalary());
	}

	//Tests that the calculate wage method correctly calculates the wage to 2 decimal places. 1050 is the expected return value in this case.
	@Test
	public void testCalculateWage() {
		assertTrue(1050 == e1.calculateWage(10));
	}
	
	//Tests that the calculateWage method throws an IllegalArgumentException when the percentage passed in is less than 1
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateWageThrowsIllegalArgumentExceptionWhenPercentageIsLessThanOne() {
		e1.calculateWage(-1);
	}
	
	//Tests that the calculateWage method throws an IllegalArgumentException when the percentage passed in is greater than 100
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateWageThrowsIllegalArgumentExceptionWhenPercentageIsGreaterThanOneHundred() {
		e1.calculateWage(200);
	}
}
