package CoreJava;

import java.time.Duration;
import java.time.LocalTime;

public class Interface {

    public static void main(String[] args) {

        Employee developer = new Developer(101);
        developer.login();
        developer.attendingMeeting();
        developer.dailyTasks();
        developer.logout();

        

        HumanResources hr = new HumanResources(201);

        hr.takeInterview();
        hr.approveLeave(developer);


        TeamLead teamLead = new TeamLead(301);

        teamLead.attendingMeeting();
        teamLead.dailyTasks();
        teamLead.assignWork();
        teamLead.takeInterview();
    }
}

enum Role {
    HR,
    DEVELOPER,
    TEAM_LEAD
}


abstract class Employee {

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
        System.out.println(id + " logged in at " + loginTime);
    }

    final void logout() {
        logoutTime = LocalTime.now();
        System.out.println(id + " logged out at " + logoutTime);
        timeDuration();
    }

    private void timeDuration() {

        long hours = Duration.between(loginTime, logoutTime).toHours();

        if (hours < workingHours) {
            System.out.println("You are leaving early!");
        } else if (hours > workingHours) {
            System.out.println("You worked overtime.");
        } else {
            System.out.println("You completed your working hours.");
        }
    }

    public int getTakenLeave() {
        return takenLeave;
    }

    public void increaseLeave() {
        takenLeave++;
    }

    abstract void attendingMeeting();

    abstract void dailyTasks();
}


interface WorkAssignable {
    void assignWork();
}

interface InterviewTaker {
    void takeInterview();
}

interface LeaveApprovable {

    int MAX_LEAVE = 12;

    void approveLeave(Employee employee);

    default void notifyEmployee() {
        printMessage("Employee");
    }

    default void notifyTeamLead() {
        printMessage("Team Lead");
    }

    private void printMessage(String person) {
        System.out.println("Notification sent to " + person);
    }
}


class Developer extends Employee {

    Developer(int id) {
        super(id, Role.DEVELOPER);
    }

    @Override
    void attendingMeeting() {
        System.out.println("Developer discusses technical implementation.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Develop code, test it and deploy to production.");
    }
}



class HumanResources extends Employee
        implements LeaveApprovable, InterviewTaker {

    HumanResources(int id) {
        super(id, Role.HR);
    }

    @Override
    void attendingMeeting() {
        System.out.println("HR records meeting minutes and discusses company policies.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Recruit employees, resolve employee issues and manage HR activities.");
    }

    @Override
    public void approveLeave(Employee employee) {

        if (employee.getTakenLeave() >= MAX_LEAVE) {

            System.out.println("Leave Rejected.");
            System.out.println("Maximum leave limit reached.");

        } else {

            employee.increaseLeave();

            System.out.println("Leave Approved.");
            System.out.println("Leaves Taken : " + employee.getTakenLeave());

            notifyEmployee();
            notifyTeamLead();
        }
    }

    @Override
    public void takeInterview() {
        System.out.println("HR conducts HR and cultural fit interview.");
    }
}



class TeamLead extends Employee
        implements InterviewTaker, WorkAssignable {

    TeamLead(int id) {
        super(id, Role.TEAM_LEAD);
    }

    @Override
    void attendingMeeting() {
        System.out.println("Team Lead discusses sprint planning and project architecture.");
    }

    @Override
    void dailyTasks() {
        System.out.println("Manage developers, assign work, verify tasks and communicate with clients.");
    }

    @Override
    public void assignWork() {
        System.out.println("Team Lead assigned work to developers.");
    }

    @Override
    public void takeInterview() {
        System.out.println("Team Lead conducts technical interview.");
    }
}