package CoreJava.MinorLearningProject;

import java.util.Scanner;

public class Menu {
    public static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: Login(); break;
                case 2: Register(); break;
                case 3: System.exit(0);
                default: System.out.println("Enter a valid choice."); break;
            }
        }
    }

    private static void StudentPortal(Student s) {
        while (true) {
            System.out.println("\n--- Student Portal ---");
            System.out.println("1. Display ProjectList");
            System.out.println("2. Apply For Project");
            System.out.println("3. Search Project");
            System.out.println("4. Total Project");
            System.out.println("5. Return to Login");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // CLEAR TRAP: Wipes out residual integer key newline token!
            
            switch (choice) {
                case 1: s.viewProjects(); break;
                case 2: 
                    System.out.print("Enter Project Title to Apply: ");
                    s.applyProject(sc.nextLine()); 
                    break;
                case 3:
                    System.out.print("Enter Project Title to Search: ");
                    Project p = ProjectRegistry.searchProject(sc.nextLine());
                    if (p != null) {
                        System.out.println("Found! Technology: " + p.technology + " | Slots: " + p.emptyPosition);
                    } else {
                        System.out.println("Project matches zero records.");
                    }
                    break;
                case 4: ProjectRegistry.totalProjects(); break;
                case 5: return;
                default: System.out.println("Invalid selection.");
            }
        }
    }

    private static void FacultyPortal(Faculty F) {
        while (true) {
            System.out.println("\n--- Faculty Portal ---");
            System.out.println("1. Display ProjectList");
            System.out.println("2. Add Project");
            System.out.println("3. Remove Project");
            System.out.println("4. Display Your Project");
            System.out.println("5. Total Project");
            System.out.println("6. Return to Login");
            System.out.print("Choice: ");
    
            int choice = sc.nextInt();
            switch (choice) {
                case 1: ProjectRegistry.display(); break;
                case 2: F.proposeProject(sc); break;
                case 3: 
                    sc.nextLine(); // Clear buffer
                    System.out.print("Enter Title to Remove: ");
                    F.removeProject(sc.nextLine()); 
                    break;
                case 4: F.DisplayOwnProject(); break;
                case 5: ProjectRegistry.totalProjects(); break;
                case 6: return;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }

    private static void Login() {
        while (true) {
            System.out.println("\n--- Login Portal ---");
            System.out.println("1. Student");
            System.out.println("2. Faculty");
            System.out.println("3. Return");
            System.out.print("Choice: ");
            
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Continue? (1 for Yes, 0 for No): ");
                    if (sc.nextInt() == 0) break;
                    System.out.print("Enter Username: ");
                    String sUser = sc.next();
                    System.out.print("Enter Password: ");
                    String sPass = sc.next();
                    Student S = LoginService.studentLogin(sUser, sPass);
                    if (S == null) {
                        System.out.println("Wrong Details entered.");
                    } else {
                        StudentPortal(S);
                    }
                    break;
                case 2:
                    System.out.print("Continue? (1 for Yes, 0 for No): ");
                    if (sc.nextInt() == 0) break;
                    System.out.print("Enter Username: ");
                    String fUser = sc.next();
                    System.out.print("Enter Password: ");
                    String fPass = sc.next();
                    Faculty F = LoginService.facultyLogin(fUser, fPass);
                    if (F == null) {
                        System.out.println("Wrong Details entered.");
                    } else {
                        FacultyPortal(F);
                    }
                    break;
                case 3: return;
                default: System.out.println("Invalid Option."); break;
            }
        }
    }

    private static void Register() {
        while (true) {
            System.out.println("\n--- Register Portal ---");
            System.out.println("1. Student");
            System.out.println("2. Faculty");
            System.out.println("3. Return");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); 
            switch (choice) {
                case 1: RegisterService.studentRegister(sc); break;
                case 2: RegisterService.facultyRegister(sc); break;
                case 3: return;
                default: System.out.println("Invalid option."); break;
            }  
        }
    }
}