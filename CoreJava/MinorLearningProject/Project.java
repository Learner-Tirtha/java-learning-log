package CoreJava.MinorLearningProject;

class Project {
    String projectTitle;
    String technology;
    String description;
    float duration;
    int emptyPosition; 
    String facultyName;

    Project(String projectTitle, String technology, String description, float dur, int pos, String facultyName) {
        this.projectTitle = projectTitle;
        this.description = description;
        this.duration = dur;
        this.emptyPosition = pos;
        this.facultyName = facultyName;
        this.technology = technology;
    }
}