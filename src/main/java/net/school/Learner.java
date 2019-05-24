package net.school;

import java.util.ArrayList;
import java.util.List;

public class Learner extends Person {

    List<Subjects> subjectLists = new ArrayList<>();


    public Learner(String first, String last, String email) {
        super(first, last, email);
        firstName = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
        lastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
    }

    public String registerSubjects(Subjects subject ) {
        if (subjectLists.contains(subject)) {
            return "Oops already registered for subject";
        } else {
            subjectLists.add(subject);
        }
        return "subjects registered successfully";
    }

    public List getRegisteredSubjects() {
        return subjectLists;
    }

    public String getAllDetails() {
        String studentSubjects= "";
        for (int i= 0; i<subjectLists.size(); i++) {
           studentSubjects += subjectLists.get(i) + ", ";
        }
      return firstName + " you have registered for the following subjects " + studentSubjects;
    }
}
