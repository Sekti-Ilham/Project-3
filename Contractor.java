package storeManagementSystemII;
//import statement 
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to model a constructor employee object, the class extends Employee class and provide 
 * contractor employee with hourlyRate and number of hours worked :numHours  as instance variables specific to the class
 * @author Ilham Sekti
 * @version 1.0
 *
 */
public class Contractor extends Employee {
	
	private double hourlyRate;// hourly rate
	private double numHours;// number of hours worked by employee
	
	
	
	
	/**
	 * no-args constructor : constructs a contractor employee object
	 */
	public Contractor() {//nor args constructor
		super();
	}
	
	/**
	 * parameterized constructor : constructs and initializes a contractor employee object
	 * @param firstName  first name of the instantiated contractor employee
	 * @param lastName last name of the instantiated contractor employee
	 * @param email  email ID  of the instantiated contractor employee
	 * @param phoneNumber  phone number of the instantiated contractor employee
	 * @param empNumber  the employee number of the instantiated contractor employee
	 * @param hourlyRate  hourly rate of the instantiated contractor employee
	 * @param numHours number of hour worked of the instantiated contractor employee
	 */
	public Contractor  (int empNumber,String firstName, String lastName, String email, long phoneNumber, 
			double hourlyRate, double numHours) {
		super (empNumber,firstName,lastName,email,phoneNumber);//explicit call of the parent's class parametrized constructor
		this.hourlyRate=hourlyRate;
		this.numHours=numHours;
	}
	
	
	/**
	 *  calls  readEmployee() method of the parent class. Then, reads hourly rate and number of hours worked. 
	 *  @param scan scanner object to read user input
	 */
	@Override 
    public void readEmployee(Scanner scan){
		
		boolean isBadInput=true;
		super.readEmployee(scan);// calls readEmployee () of the parent class 
	
		
		while (isBadInput) {//loop for good input as long as input is invalid
			
		   try{
				System.out.print("Enter hourly rate: ");//read hourly rate
				this.hourlyRate=scan.nextDouble();
					if (this.hourlyRate<=0) {
						throw new InputMismatchException();//throw exception if hourlyRate is <=0
		        	}
					isBadInput=false;//stop looping for input when input is valid
		        }catch(InputMismatchException e) {
		        	System.err.println("Invalid Entry. Hourly rate should be a digit greater than 0");
		        	scan.nextLine();//clear input stream for next token
		        }
		}
		
		//Start looping again for good input for next variable numHours
		isBadInput=true;
		
		while (isBadInput) {
			try {
				System.out.print("Enter number of hours worked: ");//read number of hours worked
				this.numHours=scan.nextDouble();
					if (this.numHours<0) {
						throw new InputMismatchException();//throw exception if numHours is less than 0
				   }//end if
				isBadInput=false;   //stop looping for input when input is valid
	
			
			}catch (InputMismatchException e) {
				System.err.println("Invalid Entry. Number of hours should be a digit greater than 0");
	        	scan.nextLine();
				}//end catch block 
			}//end while
		
	}//end method readEmployee
	
	
	/**
	 *Increments contractor employee hourly rate by 1 dollar
	 */
	@Override 
	public void processIncrements() {
	this.hourlyRate=this.hourlyRate+1;
	}
	
	/**
     * calls the printEmployee() of the parent class. Then, prints salary, which is the product of hourly rate
     *  and the number of hours worked
	 */
	@Override
	public void printEmployee() {
		super.printEmployee();//calls printEmployee () of the parent class
		System.out.printf("%10.2f |%n",(this.hourlyRate*this.numHours));//calculates and print salary of a contractor employee
		
	}
	
	

}
