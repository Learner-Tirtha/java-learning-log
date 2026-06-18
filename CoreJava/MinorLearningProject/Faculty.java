package CoreJava.MinorLearningProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Faculty extends User {
    private String department;
    private List<Project> facultyspecificlist;

    public Faculty(String name, String department, String username, String pass) {
        // Pass name safely up to parent User class storage
        super(username, pass, name);
        this.department = department;
        this.facultyspecificlist = new ArrayList<>();
    }

    public void proposeProject(Scanner sc) {
        sc.nextLine(); // Clear scanner garbage buffer
        System.out.print("Enter the Project Title: ");
        String title = sc.nextLine();
        
        System.out.print("Enter the Technology: ");
        String tech = sc.nextLine();
        
        System.out.print("Enter the Description: ");
        String desc = sc.nextLine();
        
        System.out.print("Duration (in years): ");
        float duration = sc.nextFloat();
        
        System.out.print("Positions Available: ");
        int position = sc.nextInt();
        sc.nextLine(); // Clear trailing newline

        // Using inherited 'this.name' field correctly populated by super() constructor
        Project newProj = new Project(title, tech, desc, duration, position, this.name);
        ProjectRegistry.addProject(newProj);
        this.facultyspecificlist.add(newProj);
    }

    public void removeProject(String title) {
        Project p = ProjectRegistry.searchProject(title);
        if (p != null) {
            if (!p.facultyName.equals(this.name)) {
                System.out.println("Access Denied: You are not the mentor of this project.");
            } else {
                ProjectRegistry.register.remove(p);
                this.facultyspecificlist.remove(p);
                System.out.println("Project removed successfully.");
            }
        } else {
            System.out.println("Project NOT Found");
        }
    }

    public void DisplayOwnProject() {
        if (facultyspecificlist.isEmpty()) {
            System.out.println("You haven't proposed any projects yet.");
            return;
        }
        this.facultyspecificlist.forEach(p -> {
            System.out.println("----------------------------------------");
            System.out.println("Project Title : " + p.projectTitle);
            System.out.println("Technology    : " + p.technology);
            System.out.println("Description   : " + p.description);
            System.out.println("Duration      : " + p.duration + " year(s)");
            System.out.println("Availability  : " + p.emptyPosition + " open slot(s)");
            System.out.println("----------------------------------------");
        });
    }
}