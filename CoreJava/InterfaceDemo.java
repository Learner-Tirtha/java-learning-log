package CoreJava;

import java.time.Duration;
import java.time.LocalTime;

// Abstract Class:
// Used to store the common state (data) and common behavior shared by all employees.
// It represents what an object "IS" (Identity). It can also define mandatory behavior using abstract methods.
//
// Interface:
// Represents capabilities—what an object "CAN DO" (Behavior) rather than what it is.
public class InterfaceDemo { 

    public static void main(String[] args) {

        Employee developer = new Developer(101);
        developer.login();
        developer.attendingMeeting();
        developer.dailyTasks();
        developer.logout();

        HumanResources hr = new HumanResources(201);
        hr.login();
        hr.takeInterview();
        hr.approveLeave(developer);
        hr.logout();

        TeamLead teamLead = new TeamLead(301);
        teamLead.login();
        teamLead.attendingMeeting();
        teamLead.dailyTasks();
        teamLead.assignWork();
        teamLead.takeInterview();
        teamLead.logout();
    }
}

enum Role {
    HR,
    DEVELOPER,
    TEAM_LEAD
}

abstract class Employee {

    // Common state associated with every employee 
    protected double salary;
    protected long workingHours = 8;
    protected int takenLeave = 0;

    private int id;
    private Role role;

    private LocalTime loginTime;
    private LocalTime logoutTime;

    Employee(int id, Role role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    final void login() {
        loginTime = LocalTime.now();
        System.out.println(id + " (" + role + ") logged in at " + loginTime);
    }

    final void logout() {
        logoutTime = LocalTime.now();
        System.out.println(id + " (" + role + ") logged out at " + logoutTime);
        timeDuration();
    }

    private void timeDuration() {
        // Note: Running this instantly in main() will yield 0 hours, triggering "leaving early"
        long hours = Duration.between(loginTime, logoutTime).toHours();

        if (hours < workingHours) {
            System.out.println("Notice: Leaving early!");
        } else if (hours > workingHours) {
            System.out.println("Notice: Worked overtime.");
        } else {
            System.out.println("Notice: Completed exact working hours.");
        }
        System.out.println("---------------------------------------------");
    }

    public int getTakenLeave() {
        return takenLeave;
    }

    public void increaseLeave() {
        takenLeave++;
    }

    // Mandatory behaviors that every specific subclass MUST implement uniquely
    abstract void attendingMeeting();
    abstract void dailyTasks();
}

// Interface shows a CAPABILITY that an entity has.
// Placed separate from TeamLead because TeamLead, Manager, or Scrum Master might all assign work.
interface WorkAssignable {
    void assignWork();
}

// HR, TeamLead, and Engineering Managers may all interview candidates, 
// but all of them do it with a different purpose or perspective.
interface InterviewTaker {
    void takeInterview();
}

interface LeaveApprovable {
    // By Default, variables in interfaces are: public static final (Constants)
    int MAX_LEAVE = 12;

    // HR, Manager, Director may all approve leaves.
    void approveLeave(Employee employee);

    // JAVA 8 EVOLUTION: Default methods introduced.
    // Why? When Java maintainers wanted to add new methods to existing interfaces (like Collection), 
    // doing so would break millions of legacy production codes because interfaces forces implementation.
    // Default methods allowed libraries to scale seamlessly without breaking backward compatibility.
    default void notifyEmployee() {
        printMessage("Employee");
    }

    default void notifyTeamLead() {
        printMessage("Team Lead");
    }

    // JAVA 9 EVOLUTION: Private methods in interfaces introduced.
    // Why? Default methods often share repeating logic. To adhere to the DRY (Don't Repeat Yourself) 
    // principle and keep implementation details hidden/encapsulated, private methods were permitted.
    private void printMessage(String person) {
        System.out.println("Notification sent to " + person);
    }
}

// Developer IS-A Employee
class Developer extends Employee {

    Developer(int id) {
        super(id, Role.DEVELOPER);
    }

    @Override
    void attendingMeeting() {
        System.out.println("Developer discusses technical implementation details.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Develop code, test it, and deploy to production.");
    }
}

// HR IS-A Employee, and CAN-DO Leave approval & Interviewing
class HumanResources extends Employee implements LeaveApprovable, InterviewTaker {

    HumanResources(int id) {
        super(id, Role.HR);
    }

    @Override
    void attendingMeeting() {
        System.out.println("HR records meeting minutes and discusses company policies.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Recruit employees, resolve employee issues, and manage HR activities.");
    }

    @Override
    public void approveLeave(Employee employee) {
        if (employee.getTakenLeave() >= MAX_LEAVE) {
            System.out.println("Leave Rejected: Maximum leave limit (" + MAX_LEAVE + ") reached.");
        } else {
            employee.increaseLeave();
            System.out.println("Leave Approved.");
            System.out.println("Total Leaves Taken by Employee " + employee.getId() + ": " + employee.getTakenLeave());
            
            // Calling default interface methods
            notifyEmployee();
            notifyTeamLead();
        }
    }

    @Override
    public void takeInterview() {
        System.out.println("HR conducts behavioral and cultural-fit interview.");
    }
}

// TeamLead IS-A Employee, and CAN-DO Interviewing & Work assignment
class TeamLead extends Employee implements InterviewTaker, WorkAssignable {

    TeamLead(int id) {
        super(id, Role.TEAM_LEAD);
    }

    @Override
    void attendingMeeting() {
        System.out.println("Team Lead discusses sprint planning and project architecture.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Manage developers, assign work, verify tasks, and communicate with clients.");
    }

    @Override
    public void assignWork() {
        System.out.println("Team Lead assigned work tasks to developers.");
    }

    @Override
    public void takeInterview() {
        System.out.println("Team Lead conducts technical coding interview.");
    }
}