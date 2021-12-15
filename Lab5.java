package storeManagementSystemII;

//import statement
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
* the main method : reads the name of the store and the number of employees,
* calls readEmployeeDetails() method to read details of all employees
* prints the title and the header row and calls printEmployee() method to print details of all employees
* @author Ilham Sekti
* @version 1.0
*
*/

public class Lab5 {

	public static void main(String[] args) throws IOException{
	
		
		  String storeName;//name of the store
		  int numEmployees;//number of employees
		  int option;
		  Scanner scan =new Scanner(System.in);//scanner object to read user input 
		  
		  boolean isBadInput=true;//boolean variable to control looping while user input is invalid
		  boolean shouldContinue=true;//boolean variable to control menu looping
				  
	  
			System.out.print("Enter name of store: ");//prompt user for store name
			 storeName=scan.nextLine();
			 //while input is bad keep prompting user for valid input 
	do {		 
			 System.out.print("How many employees do you have ? ");//prompt user for number of employees
	
		try {
			 numEmployees=scan.nextInt();
			 //throw exception if number of employees given by user is less than or equal to 0
			   if(numEmployees <=0) {
				   throw new InputMismatchException();//exception  will be caught by method main
			   }
			 Store store =new Store(numEmployees,storeName);//creation of store object
			
			 
		 while (shouldContinue) {//while user choose to continue operating the menu, keep showing menu and processing 
			  System.out.print("1. Read employee details from keyboard  \n2. Read employee details from file \n3. Process increments  \n4. Print employee details  \n5. exit  \n Enter your choice: ");
			  option=scan.nextInt();
			
		       // case statement to process menu options
			  switch(option) {
			  	 case 1:
			  		 store.readEmployeeDetails(scan);//calls readEmployeeDetails from keyboard
			  		 break;
			  	 case 2:
			  		 store.readEmployeeDetailsFromFile(scan);//calls readEmployeeDetailsFromFile method
			  		 break;
			  	case 3:
			  		 store.processSalaryIncrements();//calls processSalaryIncrements method 
			  		 break;
			  	 case 4:
					Store.printEmployeeDetails();//print employee details 
			  		 break;
			  	 case 5:
			  		 System.out.println("Goodbye...Have a nice day!");//of user chooses to quit program, set boolean variable to false to stop looping 
			  		 shouldContinue =false;// stop looping through menu
			  		 break;
			  	 default :// if menu option out of range inform user
			  		 System.out.println("Invalid choice... choice should be a positive integer from 1-5... please try again");//program will continue prompting user for valid input if not valid 
			  
			  
			  }//end switch statement
			
		 }//end while statement
		 isBadInput=false;// if input is valid set boolean variable to false and stop looping for valid input
		 
	    }//end try block
		catch (InputMismatchException e) {
				System.err.println("Number of employees should be an integer greater than zero... please try again");
				scan.nextLine();
			}//End of catch block
		
	}while (isBadInput);		  
	
	
	//close Scanner object
	try{
		if (scan!=null) {
			scan.close();			
		}
	}catch(Exception e) {
		System.out.println("Error closing Scanner object");
		
	}//end catch block

	}//end main

}//end class Lab5
