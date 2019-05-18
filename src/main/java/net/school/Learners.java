package net.school;

import java.util.ArrayList;
import java.util.List;

public class Learners extends Person {

    List<Subjects> subjectLists = new ArrayList<>();

    public Learners(String first, String last, String email) {
        super(first, last, email);
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
