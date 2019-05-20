package net.school;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    List<Subjects> teachersQualification = new ArrayList<>();

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

    public String getAllDetails() {
        String studentSubjects= "";
        for (int i= 0; i<teachersQualification.size(); i++) {
            studentSubjects += teachersQualification.get(i) + ", ";
        }
        return firstName + " you have registered to teach the following subjects " + studentSubjects;
    }
}
