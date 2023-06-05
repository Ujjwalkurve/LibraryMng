package library;
import java.util.Scanner;
public class Students  {
	
	Scanner input = new Scanner(System.in);
	Student theStudents[]=new Student[50];
	public static int count =0;
	
	public void addStudent(Student s) {
		for(int i=0;i<count;i++) {
			if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
				System.out.println("Student of Reg Num"+s.regNum+"is Already Registered");
				return;
			}
		}
		if(count<=50) {
			theStudents[count]=s;
			count++;
		}
		
	}
	public void showAllStrudent() {
		System.out.println("Student Name \t Reg Number \t FatherName \t Contact  \t University  \t City");
		for(int i=0;i<count;i++) {
			System.out.println(theStudents[i].studentName+"\t"+theStudents[i].regNum+" \t"+theStudents[i].fname+" \t"+theStudents[i].contact+" \t"+theStudents[i].uni+" \t"+theStudents[i].city);
			
		}
	}
	public int isStudent() {
		System.out.println("Enter Reg Number: ");
		String regNum = input.nextLine();
		
		for(int i=0;i<count;i++) {
			if(theStudents[i].regNum.equalsIgnoreCase(regNum)) {
				return i;
			}
		}
		System.out.println("Student is not Registered ");
		System.out.println("Get Registered First ");
		return -1;
	}
	
	public void checkOutBook(Books book) {
		int studentIndex = this.isStudent();
		
		if(studentIndex!=-1) {
			System.out.println("Checking out");
			
			book.showAllBooks();
			Book b = book.checkOutBook();
			System.out.println("checking out");
			
			if(b!=null) {
				
				if(theStudents[studentIndex].booksCount<=3) {
					System.out.println("Adding book");
					theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount]=b;
					theStudents[studentIndex].booksCount++;
					return;
				}
				else {
					System.out.println("Student Can Not Borroe more then 3 Books");
					return;
				}
			}
			System.out.println("Book is not Available");
		}
	}

	public void checkinBook(Books book) {
		
		int studentIndex = this.isStudent();
		if(studentIndex !=-1) {
			System.out.println("S No \t\t Book Name \t\t Author Name");
			Student s = theStudents[studentIndex];
			for(int i=0;i<s.booksCount;i++) {
				
				System.out.println(s.borrowedBooks[i].sNo+ "\t\t"+s.borrowedBooks[i].bookName+"\t\t"+s.borrowedBooks[i].authorName);
				
			}
			System.out.println("Enter Serial Number Of Book to be Checked in");
			int sNo = input.nextInt();
			
			for(int i =0; i<s.booksCount; i++) {
				if(sNo==s.borrowedBooks[i].sNo) {
					book.checkinBook(s.borrowedBooks[i]);
					s.borrowedBooks[i]=null;
					return;
				}
			}
			System.out.println("Book of Serial No "+sNo+" not Found");
		}
	}
}
