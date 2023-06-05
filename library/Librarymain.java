package library;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Librarymain {

	public static void main(String[] args) throws FileNotFoundException {
		char ch;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Login username:");
		String username= input.next();
		System.out.println("Login Password");
		String password = input.next();
		
		if(username.equals("admin") && password.equals("123")) {
			System.out.println("\nAccess Granted Welcome");
			//date
			LocalDate dt = LocalDate.now();
			dt= LocalDate.now();
			System.out.println("Date- "+dt);
			
//It is used to print the formatted representation of objects to the text-output stream.

			try (PrintWriter out = new PrintWriter("Library Detail.txt")) {
				System.out.println("Wlcome to the Library");
				System.out.println("Please Select From The Following Options");
				
				Books ob = new Books();
				Students obStudent = new Students();
				int choice;
				int searchChoice;
				
				do {
					ob.dispMenu();
					choice = input.nextInt();
					switch(choice) {
					//Adding Book
					case 1:
						Book b = new Book();
						ob.addBook(b);
						System.out.println("Book Added");

						break;
					//Book Quantity Update
					case 2:
						ob.upgradeBookQty();
						break;
					//Search a Book
					case 3:
						System.out.println("Enter 1 to Search with Serial No");
						System.out.println("Enter 2 to Search with Author Name (Full Name)");
						
						searchChoice=input.nextInt();
						switch(searchChoice) {
						case 1:
							ob.searchBySno();
							break;
						case 2:
							ob.serchByAuthorName();
							
					}
						break;
					//Show All Books
					case 4:
						ob.showAllBooks();
						out.println(ob);
						break;
					//Register Student
					case 5:
						Student s = new Student();
						obStudent.addStudent(s);
						System.out.println("Student Added");
						break;
						
					//Show All Registerd Students
					case 6:
						obStudent.showAllStrudent();
						out.println(obStudent);
						break;
						
					//Check Out Book
					case 7:
						obStudent.checkOutBook(ob);
						out.println(obStudent);
						break;
						
					//Check in Book
					case 8:
						obStudent.checkinBook(ob);
						out.println(obStudent);
						break;
					//for Exit
					case 0:
						System.out.println("Thank You for visiting library");
						break;
						
						default:
							System.out.println("Choice Should be Between 0 to 8");
				}
					System.out.println("You want to continue Enter y");
					ch=input.next().charAt(0);
			}while(ch =='y' || ch=='Y');
			}
						
				}
					
		else if(username.equals("admin")) {
				System.out.println("Invalid Password");
			}
		else if(password.equals("123")) {
			System.out.println("Invalid Username");
		}
		else {
			System.out.println("Invalid Username && Password");
		
		}
	}
}
