package net.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teacher extends Person {
    public  Map<String, Integer> tokenBalance = new HashMap<String, Integer>();
    List<Subjects> teachersQualification = new ArrayList<>();
    int token = 0;
    private Teacher teacher;

    public Teacher(String first, String last, String email) {
        super(first, last, email);
        lastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
    }

    public String registerSubjects(Subjects subject ) {
        if (teachersQualification.contains(subject)) {
            return "Oops already registered for subject";
        } else {
            teachersQualification.add(subject);
        }
        return "subjects registered successfully";
    }

    public List getRegisteredSubjects() {
        return teachersQualification;
    }

    public void giveToken(Teacher teacher) {
        this.teacher = teacher;
        tokenBalance.put(teacher.getLastName() , token += 5);
        System.out.println(tokenBalance.toString());
    }

    public String getTokenBalance() {
        int balance = 0;
        for (int bal : tokenBalance.values()) {
            balance = bal;
        }
        return  "Mr " + this.lastName + " you have "  + balance + " Tokens";
    }

    public String getAllDetails() {
        String studentSubjects= "";
        for (int i= 0; i<teachersQualification.size(); i++) {
            studentSubjects += teachersQualification.get(i) + ", ";
        }
        return firstName + " you have registered to teach the following subjects " + studentSubjects;
    }
}
