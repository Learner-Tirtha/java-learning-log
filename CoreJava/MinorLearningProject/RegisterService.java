package CoreJava.MinorLearningProject;

import java.util.Scanner;

public class RegisterService {
    
    static void studentRegister(Scanner Register) {
        System.out.println("Enter the UserName:");
        String Username = Register.next();
        System.out.println("Set up your Password:");
        String pass1 = Register.next();
        
        Register.nextLine(); // CLEAR BUFFER TRAP: Consumes newline before reading full line text
        System.out.println("Enter your Full Name:");
        String name = Register.nextLine();
        
        System.out.println("Enter your ABCID:");
        String abcid = Register.next();
        System.out.println("Enter your IDNo:");
        String ID = Register.next();

        LoginService.studentList.put(Username, new Student(abcid, ID, name, Username, pass1));
        System.out.println("Student registration completed successfully!");
    }

    static void facultyRegister(Scanner Register) {
        System.out.println("Enter the UserName:");
        String Username = Register.next();
        System.out.println("Set up your Password:");
        String pass2 = Register.next();
        
        Register.nextLine(); // Clear buffer
        System.out.println("Enter the full name:");
        String nameFaculty = Register.nextLine();
        
        System.out.println("Enter the Department:");
        String dept = Register.nextLine();

        LoginService.facultyList.put(Username, new Faculty(nameFaculty, dept, Username, pass2));
        System.out.println("Faculty registration completed successfully!");
    }
}