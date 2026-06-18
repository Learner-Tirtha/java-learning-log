package CoreJava.MinorLearningProject;

class Student extends User {
    protected String abcID;
    protected String IdNo;

    Student(String abcID, String ID, String name, String username, String pass) {
        super(username, pass, name);
        this.abcID = abcID;
        this.IdNo = ID;
    }

    public void viewProjects() {
        ProjectRegistry.display();
    }

    public void applyProject(String title) {
        Project p = ProjectRegistry.searchProject(title);

        if (p == null) {
            System.out.println("Project '" + title + "' not found.");
            return;
        }

        if (p.emptyPosition <= 0) {
            System.out.println("Sorry! No positions available.");
            return;
        }

        p.emptyPosition--;
        System.out.println("--------------------------------");
        System.out.println(this.name + " successfully applied.");
        System.out.println("Project : " + p.projectTitle);
        System.out.println("Guide   : " + p.facultyName);
        System.out.println("Remaining Positions : " + p.emptyPosition);
        System.out.println("--------------------------------");
    }
}