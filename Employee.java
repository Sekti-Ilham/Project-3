//package name 
package storeManagementSystemII;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* The purpose of this class is to model an employee object, the class extends Person class and provide 
*  employee with an employee number as instance variable specific to the class
* @author Ilham Sekti
* @version 1.0
*
*/
public abstract class Employee extends Person{
	
private int empNumber;//employee number
	
	
	/**
	 * no-args constructor : constructs an employee object
	 */
	public Employee() { //no- args constructor 
		super();
	}
	
	
	/**
	 * Parameterized constructor : constructs and initializes an employee object
	 * @param firstName  first name of the instantiated  employee object
	 * @param lastName last name of the instantiated  employee object
	 * @param email  email ID  of the instantiated  employee object
	 * @param phoneNumber  phone number of the instantiated  employee object
	 * @param empNumber  the employee number of the instantiated  employee object
	 */
	public Employee (int empNumber,String firstName, String lastName, String email, long phoneNumber)  {
		super(firstName,lastName,email,phoneNumber);//calls super class parameterized constructor
		this.empNumber=empNumber;//initializes employee number 
		
	}
	
	/**
	 * reads all employee information and stores it in instance variables
	 * @param scan scanner object to read user input actual object 
	 * will be created in main method and passed to the method as parameter
	 */
	public void readEmployee(Scanner scan) {
	 boolean isBadInput=true;
	// reading Employee details 
		while(isBadInput) {
			
			try {	
				 System.out.print("Enter Employee Number: ");
				 this.empNumber=scan.nextInt();
				  if(empNumber<0) {//{ //check for valid input 
						throw new InputMismatchException();	
				  }
				  isBadInput=false;
				  scan.nextLine();
					
			} catch(InputMismatchException e)	{
				System.err.println("Invalid entry, Employee Number should be an integer greater than zero: "); 
				scan.nextLine();
			}//end of catch block
			}//end of while loop
	   
		System.out.print("Enter first name: ");//reading first name 
		super.setFirstName(scan.nextLine());
		
		
		System.out.print("Enter last name: ");//reading last name 
		super.setLastName(scan.nextLine());
		
		
		System.out.print("Enter email Id: ");//reading email ID
		super.setEmail(scan.nextLine());
		
		
		isBadInput=true;
        while(isBadInput) {
			
			try {	
				 System.out.print("Enter Phone Number: ");
				 super.setPhoneNumber(scan.nextLong());
				 //scan.nextLine();
				  if(super.getPhoneNumber()<0) {//{ //check for valid input 
						throw new InputMismatchException();	
				  }
				  isBadInput=false;
					
			} catch(InputMismatchException e)	{
				System.err.println("Invalid phone Number format. Please try again."); 
				scan.nextLine();
			}//end catch block
		}//end while
		
		      
	}//end read employee method
	
	
	
    /**
     * abstract method that will be implemented in subclasses Regular and Contractor to increment salary according to employee type
     */
    public abstract void processIncrements();
		
	
	
	/**
	 * prints details of an employee
	 */
	public void printEmployee() {
		System.out.printf("%10d |%21s | %15s | %12d |",this.empNumber,super.getFirstName() +" "+super.getLastName(),
				super.getEmail(),super.getPhoneNumber());
		
	}//end printEmployee method
	
	
	
	

}
