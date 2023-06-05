package library;

import java.util.Scanner;

public class Student {
	Scanner input = new Scanner(System.in);
	
	String studentName, address,city,uni,bi;
	String regNum, fname;
	String contact;
	
	Book borrowedBooks[] = new Book[3];
	public int booksCount=0;
	
	public Student() {
		System.out.println("Enter student Name");
		this.studentName = input.nextLine();
		
		System.out.println("Enter reg Number");
		this.regNum=input.nextLine();
		
		System.out.println("Enter Father Name");
		this.fname = input.nextLine();
		
		System.out.println("Enter Contect");
		this.contact=input.nextLine();
		
		System.out.println("Enter university Name");
		this.uni = input.nextLine();
		
		System.out.println("Enter city Name");
		this.city = input.nextLine();
		
		System.out.println("Book of Interest");
		this.bi=input.nextLine();
		
	}

}
