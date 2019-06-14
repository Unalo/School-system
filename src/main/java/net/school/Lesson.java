package net.school;
import java.util.*;

public class Lesson {
    public Lesson(Subjects subject) {
        this.subject = subject;
    }

    List<Learner> attendanceList = new ArrayList<>();
    public Map<Learner, Integer> studentTokens = new HashMap<>();
//    public Map<String, Integer> teacherTokens = new HashMap<>();
//    public Map<Learner, Subjects> studentNotes = new HashMap<>();
    private final Subjects subject;
    private Teacher teacher;
    private Learner learner;


    public Boolean teacherValidSubject(Teacher teacher) {
        return teacher.teachersQualification.contains(subject);
    }

    public boolean learnerValidSubject(Learner learner) {
        return learner.subjectLists.contains(subject);
    }

    public boolean learnerSubjectListValidation (Learner learner) {
        return learner.subjectLists.size() >= 3;
    }

    public void addLearners (Learner learner) {
        if(!attendanceList.contains(learner)) {
            if (learnerSubjectListValidation(learner) && learnerValidSubject(learner)) {
                attendanceList.add(learner);
                // return learner.firstName + " is attending a " + subject + " lesson";
            }
        } else {
            System.out.println("Oops " +  learner.firstName + " you attending a " + subject + " lesson");
        }
    }


    public String startLesson (int time, Teacher teacher) {
        this.teacher = teacher;
        if (teacher != null) {
                if (attendanceList.size() >= 5 && teacherValidSubject(teacher)) {
                for (int i = 0; i < attendanceList.size(); i++) {
                    studentTokens.put(attendanceList.get(i), attendanceList.get(i).giveToken());
//                    if (studentTokens.containsKey(attendanceList.get(i))) {
//                        studentTokens.put(attendanceList.get(i), attendanceList.get(i).giveToken());
//                    } else {
//                        studentTokens.put(attendanceList.get(i), attendanceList.get(i).giveToken());
//                    }
                    attendanceList.get(i).studentNotes.add(subject);
//                    System.out.println(attendanceList.get(i).getNotes());
                    }
                    teacher.giveToken();
                    return "successful";
                } else{
                    return "cancelled";
                }
            } else {
                return "No teacher for the lesson";
            }
        }

    public String buyNotes(Learner buyingLearner, Subjects notesToBuy ) {
        if (learnerValidSubject(buyingLearner ) == true) {
            if (buyingLearner.getTokenBalance() > 2 && learnerValidSubject(receivingLearner)) {
                System.out.println(learnerValidSubject(receivingLearner ) + "*******************************");
               int balance =  buyingLearner.getTokenBalance() - 2;
               int addTokenToLearner = receivingLearner.getTokenBalance() + 2;
                System.out.println(receivingLearner.getTokenBalance() + "tokens");
                receivingLearner.studentNotes.remove(notesToBuy);
                buyingLearner.studentNotes.add(notesToBuy);
                //System.out.println(buyingLearner.firstName +  " you have " + buyingLearner.getNotes());
               return receivingLearner.firstName +  " you have sell notes to " + buyingLearner.firstName ;
            }
            else {
                return "You dont have enough tokens";
            }
        } else if (learnerValidSubject(buyingLearner) == false) {
            if (buyingLearner.getTokenBalance() > 5 && learnerValidSubject(receivingLearner)) {

            }
        }
        return "";
    }

    public void buy (Person person) {

    }
}
