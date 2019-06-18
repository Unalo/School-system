package net.school;

import java.util.ArrayList;
import java.util.List;

public class Learner extends Person {

    List<Subjects> subjectLists = new ArrayList<>();
    List<Subjects> studentNotes = new ArrayList<>();

    public int token = 0;

    public Learner(String first, String last, String email) {
        super(first, last, email);
        firstName = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
        lastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
    }

    public String buyNotes(Learner learner, Subjects subject) {
        if(learner.subjectLists.contains(subject) == true) {
            if(subjectLists.contains(subject) && learner.getTokenBalance() >= 2) { //check if unalo is registered
               int balance =  learner.getTokenBalance() - 2;
               int unalo =  getTokenBalance() + 2;
               learner.studentNotes.add(subject);
               System.out.println(learner.firstName + " uzifumene notes");
            }
        } else if (learner.subjectLists.contains(subject) == false) {
                if (subjectLists.contains(subject) && learner.getTokenBalance() >= 5) {
                //transaction
                int Balance = learner.getTokenBalance() - 5;
                int unalo = getTokenBalance() + 5;
                learner.studentNotes.add(subject);
                System.out.println(learner.firstName + " zikhona notes");
            }
        }
        System.out.println(subjectLists.contains(subject) && learner.getTokenBalance() >= 5);
        return "notes sold";
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

    public int giveToken() {
        return this.token += 3;
    }

    public void giveNotes(Subjects subjects) {
       studentNotes.add(subjects);
    }

    public int getTokenBalance() {
        return giveToken();
    }

    public String getNotes() {
        String notes= "";
        for (int i = 0; i <studentNotes.size() ; i++) {
            notes += studentNotes.get(i)+ ", ";
        }
        return this.firstName +  " you have " + notes + "notes";
    }

    public String getAllDetails() {
        String studentSubjects= "";
        for (int i= 0; i<subjectLists.size(); i++) {
           studentSubjects += subjectLists.get(i) + ", ";
        }
      return firstName + " you have registered for the following subjects " + studentSubjects ;
    }


}
