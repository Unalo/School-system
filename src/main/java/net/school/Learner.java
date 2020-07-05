package net.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import net.school.Lesson;

//import static net.school.Lesson.studentTokens;

public class Learner extends Person {
    public Map<String, Integer> tokenBalance = new HashMap<String, Integer>();
    List<Subjects> subjectLists = new ArrayList<>();
    List<Subjects> studentNotes = new ArrayList<>();

    public int token = 0;
    private Learner learner;

    public void clearStudentNotes() {

    }

    public Learner(String first, String last, String email) {
        super(first, last, email);
        firstName = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
        lastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
    }

    public int buyNotes(Learner learner, Subjects subject) {
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
        System.out.println("notes sold");
        return getTokenBalance();
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

    public void giveToken(Learner learner) {
        this.learner = learner;
        tokenBalance.put(learner.getFirstName() , token += 3);
        System.out.println(tokenBalance.toString());
    }

    public void giveNotes(Subjects subjects) {
       studentNotes.add(subjects);

    }

    public int getTokenBalance() {
        int balance = 0;
        for (int bal : tokenBalance.values()) {
            balance = bal;
        }
        System.out.println("Dear Student, last name : " + this.lastName + " you have "  + balance + " Tokens");
        return  balance;
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
      return firstName + " " + lastName + " Email Address : " + emailAddress + "." + " you have registered for the following subjects " + studentSubjects ;
    }
}
