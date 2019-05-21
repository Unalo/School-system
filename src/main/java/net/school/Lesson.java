package net.school;
import java.util.HashMap;
import java.util.Map;

public class Lesson {

    public Map<String, Subjects> attendance = new HashMap<>();

    public String teacherValidSubject(Teacher teacher, Subjects subjects) {

        if (teacher.teachersQualification.contains(subjects)) {
            return teacher.firstName + " You can start a lesson";
        } else {
            return teacher.firstName + " you don't qualify to teach this subject";
        }
    }

    public String learnerValidSubject(Learner learner, Subjects subjects) {

        if (learner.subjectLists.contains(subjects)) {
            return learner.firstName + " you can attend lesson";
        } else {
            return learner.firstName + " Can't attend lesson, not registered for subject lesson";
        }
    }

    public String learnerSubjectListValidation (Learner learner) {

        if (learner.subjectLists.size() >= 3) {
            return "Registered for 3 or more subjects";
        }
        else {
            return "You must register 3 or more subject to attend a lesson";
        }
    }

    public Map addLearners (Learner learner, Subjects subjects) {

        if (attendance.containsKey(learner)) {
            System.out.println(learner.firstName + " is attending a " + attendance.get(learner) + " lesson");
//            return learner.firstName + " is attending a " + attendance.get(learner) + " lesson";
        } else {
            attendance.put(learner.firstName, subjects);
        }
        return attendance;
    }

    public String startLesson () {

        if (attendance.size() >= 5) {
            return "successful";
        }
        else {
            return "cancelled";
        }
    }
}
