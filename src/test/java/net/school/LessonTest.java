package net.school;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {
    @Test
    public void shouldValidateTeachersQualifications() {
        Teacher teacher = new Teacher("Mr Alex", "bayo", "bayo@gmail.com");
        Lesson lesson = new Lesson();

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.HISTORY);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.ENGLISH);

        assertEquals(lesson.teacherValidSubject(teacher, Subjects.PHYSICAL_SCIENCE), teacher.firstName +" you don't qualify to teach this subject");
    }

    @Test
    public void shouldCheckLearnersSubjectList() {
        Learner learner = new Learner("Inam", "bayo", "inam@gmail.com");
        Lesson lesson = new Lesson();

        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        assertEquals(lesson.learnerSubjectListValidation(learner), "You must register 3 or more subject to attend a lesson");
    }

    @Test
    public void shouldValidateLearnerSubjectForLesson() {
        Learner learner = new Learner("Inam", "bayo", "inam@gmail.com");
        Lesson lesson = new Lesson();

        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        assertEquals(lesson.learnerValidSubject(learner, Subjects.PHYSICAL_SCIENCE), learner.firstName + " Can't attend lesson, not registered for subject lesson");
    }

    @Test
    public void shouldAddStudentToLesson() {
        Lesson lesson = new Lesson();

        Learner learner1 = new Learner("Inam", "bayo", "inam@gmail.com");
        Learner learner2 = new Learner("unalo", "khumalo", "khumalo@gmail.com");
        Learner learner3 = new Learner("asanda", "khumalo", "khumalo@gmail.com");
        Learner learner4 = new Learner("unalo", "khumalo", "khumalo@gmail.com");

//        learner1.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner1.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner1.registerSubjects(Subjects.LIFE_SCIENCE);
//
//        learner2.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner2.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner2.registerSubjects(Subjects.LIFE_SCIENCE);
//
//        learner3.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner3.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner3.registerSubjects(Subjects.LIFE_SCIENCE);

        lesson.addLearners(learner1, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner2, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner3, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner4, Subjects.PHYSICAL_SCIENCE);

        assertEquals(lesson.addLearners(learner4, Subjects.PHYSICAL_SCIENCE), "");
        assertEquals(lesson.addLearners(learner4, Subjects.PHYSICAL_SCIENCE), "");
    }

    @Test
    public void shouldStartLessonForGivenSubject() {

        Lesson lesson = new Lesson();

        Learner learner1 = new Learner("Inam", "bayo", "inam@gmail.com");
        Learner learner2 = new Learner("unalo", "khumalo", "khumalo@gmail.com");
        Learner learner3 = new Learner("asanda", "khumalo", "khumalo@gmail.com");
        Learner learner4 = new Learner("asanda", "khumalo", "khumalo@gmail.com");
        Learner learner5 = new Learner("asanda", "khumalo", "khumalo@gmail.com");

        lesson.addLearners(learner1, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner2, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner3, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner4, Subjects.PHYSICAL_SCIENCE);
        lesson.addLearners(learner5, Subjects.PHYSICAL_SCIENCE);

        assertEquals(lesson.startLesson(), "");
    }
}