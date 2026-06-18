package CoreJava.MinorLearningProject;

import java.util.HashMap;

public class LoginService {
    static HashMap<String, Student> studentList = new HashMap<>();
    static HashMap<String, Faculty> facultyList = new HashMap<>();

    public static Student studentLogin(String username, String password) {
        Student s = studentList.get(username);
        if (s != null && s.checkPassword(password)) return s;
        return null;
    }

    public static Faculty facultyLogin(String username, String password) {
        Faculty f = facultyList.get(username);
        if (f != null && f.checkPassword(password)) return f;
        return null;
    }
}