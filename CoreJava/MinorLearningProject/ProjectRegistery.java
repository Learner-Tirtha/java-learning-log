package CoreJava.MinorLearningProject;

import java.util.ArrayList;
import java.util.List;

class ProjectRegistry {
    static List<Project> register = new ArrayList<>();

    static void addProject(Project p) {
        register.add(p);
        System.out.println("Registry updated: Added '" + p.projectTitle + "'");
    }

    public static void display() {
        if (register.isEmpty()) {
            System.out.println("No projects found in registry database.");
            return;
        }
        register.forEach(p -> {
            System.out.println("----------------------------------------");
            System.out.println("Project Title : " + p.projectTitle);
            System.out.println("Technology    : " + p.technology);
            System.out.println("Description   : " + p.description);
            System.out.println("Duration      : " + p.duration + " year(s)");
            System.out.println("Availability  : " + p.emptyPosition + " open slot(s)");
            System.out.println("Mentor        : " + p.facultyName);
            System.out.println("----------------------------------------");
        });
    }

    static Project searchProject(String title) {
        for (Project p : register) {
            if (p.projectTitle.equalsIgnoreCase(title.trim())) {
                return p;
            }
        }
        return null;
    }

    static void totalProjects() {
        System.out.println("Total Projects : " + register.size());
    }
}