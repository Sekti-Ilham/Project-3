//Package name 
package storeManagementSystemII;
/**
 * Class Person that models personal information of a person object, will be extended by class Employee.
 * It set first name, last name, email and phone number for each person
 * @author Ilham Sekti
 *
 */
public class Person {
	
	
	       //instance variables declaration
			private  String firstName;
			private String lastName;
			private String email;
			private long phoneNumber;
			
			//no-arg constructor
			/**
			 * no-arg constructor constructs and initializes a person object with default values
			 */
			public Person() {
				this("null","null","null",0);
			}
			//parametrized constructor
			/**
			 * Parametrized constructor: constructs and initializes a person object
			 * @param firstName the person object's first name
			 * @param lastName the person object's last name
			 * @param email the person object's email
			 * @param phoneNumber the person object's phone number
			 */
			public Person (String firstName, String lastName, String email, long phoneNumber) {
				this.firstName=firstName;
				this.lastName=lastName;
				this.email= email;
				this.phoneNumber=phoneNumber;
			}
			
			
			
			/**
			 * Setter method  for firstName
			 * @param firstName  first name of the person object
			 */
			public void setFirstName(String firstName) {
				this.firstName=firstName;
			}
			
			/**
			 * Setter method for lastName
			 * @param lastName last name of the person object
			 */
			public void setLastName(String lastName) {
				this.lastName=lastName;
			}
			
			/**
			 * Setter method for email
			 * @param email email of the person object
			 */
			public void setEmail(String email) {
				this.email=email;
			}
			
			/**
			 * Setter method for phoneNumber
			 * @param phoneNumber: phone number of the person object
			 */
			public void setPhoneNumber (long phoneNumber) {
				this.phoneNumber=phoneNumber;
			}
			
			/**
			 * getter method for name that return fist and last name
			 * @return first name and last name
			 */
			public String getFirstName() {
				return firstName;
			}
			
			public String getLastName() {
				return lastName;
			}
			/**
			 * getter method for phoneNumber
			 * @return email
			 */
			public String getEmail () {
				return email;
			}
		
			/**
			 * getter method for phoneNumber
			 * @return phone number
			 */
			public long getPhoneNumber() {
				return phoneNumber;
			}


}
