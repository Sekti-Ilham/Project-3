package storeManagementSystemII;

import java.util.InputMismatchException;
//import statement
import java.util.Scanner;

/**
* The purpose of this class is to model a regular employee object, the class extends Employee class and provide 
* regular employee with annual salary as instance variable specific to the class
* @author Ilham Sekti
* @version 1.0
*
*/
public class Regular extends Employee {
private double salary;// annual salary of a regular employee
	
	
	/**
	 * no-args constructor : constructs a contractor employee object
	 */
	public Regular() {//nor args constructor
		super();
	}
	
	/**
	 * parametrized constructor : constructs and initializes a regular employee object
	 * @param firstName  first name of the instantiated regular employee
	 * @param lastName last name of the instantiated regular employee
	 * @param email  email ID  of the instantiated regular employee
	 * @param phoneNumber  phone number of the instantiated regular employee
	 * @param empNumber  the employee number of the instantiated regular employee
	 * @param salary  annual salary of the instantiated regular employee
	 */
	public Regular ( int empNumber,String firstName, String lastName, String email, long phoneNumber, double salary) {
		super (empNumber,firstName,lastName,email,phoneNumber);
		this.salary=salary;
	}

	
	/**
	 *  calls  readEmployee() method of the parent class. Then, reads annual salary and converts it into monthly salary
	 *  @param scan scanner object to read user input
	 */
	
	@Override 
    public void readEmployee(Scanner scan){
		boolean isBadInput=true;
		  
		super.readEmployee(scan);//calls  readEmployee() method of the parent class
		 
		
     while(isBadInput) {
			
			try {	
				System.out.print("Enter annual salary: ");
				this.salary=(scan.nextDouble())/12;//converts annual salary into monthly salary and stores it in the instance variable salary
				 //scan.nextLine();
				  	if(this.salary<0) { //check for valid input 
						throw new InputMismatchException();	
				   }
				isBadInput=false;
					
			} catch(InputMismatchException e)	{
				System.err.println("Invalid entry, Annual Salary should be  greater than zero: "); 
				scan.nextLine();
			}catch(Exception e)	{
				System.err.println("Invalid entry, Annual Salary should be  greater than zero: "); 
			}
			}
	
	}
	
	/**
	 *Increments regular employee annual salary by 3%
	 */
	@Override 
	public void processIncrements() {
		this.salary=(this.salary*1.03);//increment salary by 3%
	}
	
	
	/**
     * calls the printEmployee() of the parent class. Then, prints the monthly salary of a regular employee
	 */
	@Override
	public void printEmployee() {
		super.printEmployee();//calls printEmployee() of the parent class
		System.out.printf("%10.2f |%n",this.salary);//prints monthly salary of a regular employee
		
	}

	
	
}
