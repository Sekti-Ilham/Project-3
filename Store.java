package storeManagementSystemII;
//import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.lang.IllegalStateException;
import java.nio.file.NoSuchFileException;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author Ilham Sekti
 * The purpose of this class is to model a store, it sets the store name and the number of employees.
 * Itprovide methods to read employee details from keyboard and file and prints them to the console
 *
 */
public class Store {

	
	private static  ArrayList<Employee> employees;// an array of Employee objects
	private static int numEmployees;
	private static String name;
	
	/**
	 * no-args constructor: constructs a store object
	 */
	public Store() {}
	
	/**
	 * parametErized constructor that creates the array list of employees with the given size
     * this size will be read in main(), and will be sent here when creating the Store object)
	 * @param size size of the employees array 
	 * @param name  name of the store
	 * 
	 */
	public Store (int size, String name) {
		int num=size;//size of the array list 
		Store.name =name;
		employees=new ArrayList<Employee>(size);//initialization array list;
	}
	
	/**
	 *reads employee details. First, read the type of the employee. Based on the type of the employee, 
     *corresponding employee object is created, added to the array list, then calls readEmployee() method
	 * @param scan scanner object to read user input, the object will be created in main method and passed as parameter 
	 */
	
	public void readEmployeeDetails(Scanner scan) {
	
	int employeeType;// takes 1 for regular and 2 for contractor
	boolean isBadInput=true;//controls loop for valid input
	
	
			
	 while(isBadInput) {
		 
	      try {
	    	  	//reading employee details from user through keyboard
				 System.out.println("Enter details of employee "+ (numEmployees+1) 	);
			
				//print menu for employee type
				 System.out.print("1. Regular\n2. Contractor\nEnter Type of employee: ");
					employeeType=scan.nextInt();//read user's option
					
					if (employeeType ==1) {
				    	   Employee regular=new Regular();//create regular employee object if option 1
						
				    	   employees.add(regular);//populate employees array list with regular employee object created
				    	   employees.get(numEmployees).readEmployee(scan);//calls readEmployee() to read regular employee details 
				    	   numEmployees++;
				    } else if (employeeType==2) { 
							   	Employee contractor=new Contractor();//create contractor employee object if option 2
							   	employees.add(contractor);//populate employees array list with contractor employee object created
							   	employees.get(numEmployees).readEmployee(scan);//calls readEmployee() to read contractor employee details
							   	numEmployees++;
							   	
				           } else throw new InputMismatchException();//if users choose any option other than 1 or 2 throw InputMispatchException 
					isBadInput=false;
			 }catch(InputMismatchException   inputMismatchException) {
				 System.out.println("\n****** Type should be 1 or 2.. please try again ******\n");
				 scan.nextLine(); 
			 }catch(Exception exception) {
				 System.out.println("\n****** Type should be 1 or 2.. please try again ******\n"); 
			 }
	 }//end while
	}//end method readEmployee
			
	
	
	
	/**
	 * @param scan  scanner object directed to read data from a file
	 * @throws IOException  when file does not exist, is inaccessible or end of file reached while still trying to read from it
	 * @throws SecurityException when permissions accessing the file is denied
	 * the method reads employee details from a file given as parameter to the Scanner class object
	 */
	public void readEmployeeDetailsFromFile(Scanner scan) throws IOException, SecurityException{
		
	try {
		//Open file
		scan=new Scanner (Paths.get("C:\\Users\\user\\Desktop\\emp.txt"));
		
		
	}catch(NoSuchFileException noSuchFileException) {//thrown if file does not exist
		System.out.println(" The file you are trying to access does not exist, terminating");
	}catch(FileNotFoundException fileNotFoundException) {// thrown if file is not accessible
		System.out.println("Problem accessing the file, terminating");
	}catch(SecurityException securityException) {	//thrown in case of permission issues opening the file
		System.out.println("Permission accessing the file is denied, terminating");
	}catch( EOFException eOFException) {
		System.out.println("You have reached the end of the file, no more data to read... terminating");// thrown if other errors occur while opening the file
	}catch(IOException | IllegalArgumentException   ioException) {
		System.out.println("Error opening the file, terminating");// thrown if other errors occur while opening the file
	}
	
	//read from the file 
	try {
		while(scan.hasNext()) {//read from file as long as there is data to be read
			if(scan.hasNextInt()) {//if next token is a int store it in employeeType
				int employeeType=scan.nextInt();
				    if  (employeeType==1) {//if employeeType is equal to 1 then create regular employee and pass the rest of data to constructor
				    	Employee regular=new Regular (scan.nextInt(),scan.next(), scan.next(),scan.next(),scan.nextLong(),scan.nextDouble()/12);
				    	employees.add(regular);//add regular employee created to the array list of employees
				    	numEmployees++;//increment numEmployees to update number of employees stored in array list
				    }else if (employeeType==2) {//if employeeType is equal to 2 then create contractor employee and pass the rest of tokens to the constructor
				    	Employee contractor=new Contractor(scan.nextInt(),scan.next(), scan.next(),scan.next(),scan.nextLong(),scan.nextDouble(),scan.nextDouble());
				    	employees.add(contractor);//add contractor employee created to the array list of employees
				    	numEmployees++;//increment numEmployees to update number of employees stored in array list
				    }else throw new InputMismatchException();//if first token is  not 1 or 2  throw exception
			}else throw new InputMismatchException();//if first token is not an integer throw exception
			
			
		}//end of while 
		
		
	}catch (InputMismatchException inputMismatchException) {
		System.out.println("token retrieved from file does not match the expected type, terminating.");
	}catch (NoSuchElementException noSuchElementException)	{
		System.out.println("Element trying to access does not exist, terminating.");
	}catch(IllegalStateException illegalStateException) {
		System.out.println("Error reading from file, terminating.");
	}catch(SecurityException securityException) {	
		System.out.println("Permission reading from the file is denied, terminating.");
	}catch(Exception exception) {
		System.out.println("Error reading from file, terminating.");
		
	}
	
   }//end method ReadEmployeeDetailsFromFile
	
	
	
	/**
	 * Increments Salaries for employee objects created : 3% for regular employee and 1 dollars on hourly rate for contractor employee 
	 */
	public void processSalaryIncrements() {
		
	 
		//checks if array list is empty and prints out a warning message on screen
		  if(employees.isEmpty()){
			System.out.println("\n***** No employees to process *****\n");
		}else	for (int i=0; i<employees.size();i++) {
			employees.get(i).processIncrements();//print employee details for each employee object element of the employees arraylist
		}
	 
	}
	
	
	
	/**
	 * calls printEmployee() to print details of all employees
	 */
	public static void printEmployeeDetails() {
		
		//checks if  array list is empty
		if (employees.isEmpty()) {
			System.out.println("\n***** No employees to print *****\n");
			
		}else {
			printTitle(name);
			for (int i=0; i<employees.size();i++) {
			employees.get(i).printEmployee();//print employee details for each employee object element of the employees array
		    }//end for
		}//end else
	}//end method printEmployeeDetails
	
	/**
	 * prints line "=" for output formatting
	 */
	public static void printLine() {
	 for (int i=0;i<80;i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	
	/**
	 * prints the title of the output. This method gets the name of 
     * the store as a parameter, which will be used in the formatted print statement. printLine() 
     * method will be called from this method to print lines
	 * @param name :name of the store 
	 */
	public static void printTitle(String name) {
		
		printLine();//prints a line
		System.out.printf("%22s%-21s%n",name ," Store Management System"); //prints title 
		printLine();//prints a line
		
		System.out.printf("%10s |%21s |%16s |%13s |%11s|%n","Emp#","Name","Email","Phone", "Salary");//prints title row
		printLine();//prints a line
		
	}
	
	

}
