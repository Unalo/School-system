package net.school;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson {
    public Lesson(Subjects subject) {
        this.subject = subject;
    }

    List<String> attendanceList = new ArrayList<>();
    public Map<String, Integer> studentTokens = new HashMap<>();
    public Map<String, Integer> teacherTokens = new HashMap<>();
    public Map<String, Subjects> studentNotes = new HashMap<>();
    private final Subjects subject;
    private Teacher teacher;



    public String teacherValidSubject(Teacher teacher) {

        if (teacher.teachersQualification.contains(subject)) {
            this.teacher = teacher;
            return teacher.firstName + " You can start a lesson";
        } else {
            return teacher.firstName + " you don't qualify to teach this subject";
        }
    }

    public boolean learnerValidSubject(Learner learner) {

        if (learner.subjectLists.contains(subject)) {
            return true;
//            return learner.firstName + " you can attend lesson";
        } else {
                return false;
//            return learner.firstName + " Can't attend lesson, not registered for subject lesson";
        }

//        return true;
    }

    public boolean learnerSubjectListValidation (Learner learner) {
        return learner.subjectLists.size() >= 3;
    }

    public void addLearners (Learner learner) {
        if(!attendanceList.contains(learner.firstName)) {
            if (learnerSubjectListValidation(learner) && learnerValidSubject(learner)) {
                attendanceList.add(learner.firstName);
                // return learner.firstName + " is attending a " + subject + " lesson";
            }
        } else {
            System.out.println("Oops " +  learner.firstName + " you attending a " + subject + " lesson");
        }
    }

    public String startLesson (int time, Teacher teacher) {
        this.teacher = teacher;
        if (teacher != null) {
            if (attendanceList.size() >= 5) {
                for (int i = 0; i < attendanceList.size(); i++) {
                    System.out.println(attendanceList.get(i));
                    if (studentTokens.containsKey(attendanceList.get(i))) {
                        studentTokens.put(attendanceList.get(i), studentTokens.get(attendanceList.get(i) + 3));
                    } else {
                        studentTokens.put(attendanceList.get(i), 3);
                    }
//                    if (studentNotes.containsValue(subject)) {
//                        studentNotes.put(attendanceList.get(i), studentNotes.get(attendanceList.get(i) + subject));
//                    }
//                    else {
//                        studentNotes.put(attendanceList.get(i), subject);
//                    }
                }
                if (teacherTokens.containsKey(teacher)) {
                    teacherTokens.put(teacher.firstName, teacherTokens.get(teacher) + 5);
                }
                else {
                    teacherTokens.put(teacher.firstName, 5);
                }
                System.out.println(teacherTokens.toString());
                    return "successful";
            } else {
                return "cancelled";
            }
        }
        else {
            return "No teacher for the lesson";
        }
    }

    public void getReportForLesson() {

    }
}
