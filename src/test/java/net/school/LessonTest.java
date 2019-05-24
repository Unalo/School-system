package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {
    @Test
    public void shouldValidateTeachersQualifications() {
        Teacher teacher = new Teacher("Mr Alex", "bayo", "bayo@gmail.com");
        Lesson lesson = new Lesson(Subjects.ECONOMICS);

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.HISTORY);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.ENGLISH);

        assertEquals(lesson.teacherValidSubject(teacher), teacher.firstName + " You can start a lesson");
    }

    @Test
    public void shouldCheckLearnersSubjectList() {
        Learner learner = new Learner("Inam", "bayo", "inam@gmail.com");
        Lesson lesson = new Lesson(Subjects.MATHEMATICS);

        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);

        assertEquals(lesson.learnerSubjectListValidation(learner), false);
    }

    @Test
    public void shouldValidateLearnerSubjectForLesson() {
        Learner learner = new Learner("Inam", "bayo", "inam@gmail.com");
        Lesson lesson = new Lesson(Subjects.LIFE_SCIENCE);

        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        learner.registerSubjects(Subjects.MATHEMATICS);

        assertEquals(lesson.learnerValidSubject(learner), false);
    }

    @Test
    public void shouldAddStudentToLesson() {
        Lesson lesson = new Lesson(Subjects.ECONOMICS);

        Learner learner1 = new Learner("Inam", "bayo", "inam@gmail.com");
        Learner learner2 = new Learner("unalo", "khumalo", "khumalo@gmail.com");
        Learner learner3 = new Learner("asanda", "khumalo", "khumalo@gmail.com");
        Learner learner4 = new Learner("Bonga", "baloyi", "khumalo@gmail.com");

        learner1.registerSubjects(Subjects.ECONOMICS);
        learner1.registerSubjects(Subjects.ENGLISH);
        learner1.registerSubjects(Subjects.MATHEMATICS);

        learner2.registerSubjects(Subjects.ECONOMICS);
        learner2.registerSubjects(Subjects.LIFE_SCIENCE);
        learner2.registerSubjects(Subjects.MATHEMATICS);

        learner3.registerSubjects(Subjects.ECONOMICS);
        learner3.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        learner3.registerSubjects(Subjects.HISTORY);

        learner4.registerSubjects(Subjects.ECONOMICS);
        learner4.registerSubjects(Subjects.LIFE_SCIENCE);
        learner4.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        lesson.addLearners(learner1);
        lesson.addLearners(learner2);
        lesson.addLearners(learner3);
        lesson.addLearners(learner4);

        assertEquals(lesson.attendanceList.toString(), "[Inam, Unalo, Asanda, Bonga]");
    }

    @Test
    public void shouldStartLessonForGivenSubject() {

        Lesson lesson = new Lesson(Subjects.PHYSICAL_SCIENCE);
        Teacher teacher = new Teacher("Mr max", "Baloyi", "baloyi@gmail.com");

        Learner learner1 = new Learner("Inam", "bayo", "inam@gmail.com");
        Learner learner2 = new Learner("unalo", "khumalo", "khumalo@gmail.com");
        Learner learner3 = new Learner("Asiphe", "khumalo", "khumalo@gmail.com");
        Learner learner4 = new Learner("asanda", "khumalo", "khumalo@gmail.com");
        Learner learner5 = new Learner("Bonga", "khumalo", "khumalo@gmail.com");

        learner1.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        learner1.registerSubjects(Subjects.ENGLISH);
        learner1.registerSubjects(Subjects.MATHEMATICS);

        learner2.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        learner2.registerSubjects(Subjects.LIFE_SCIENCE);
        learner2.registerSubjects(Subjects.MATHEMATICS);

        learner3.registerSubjects(Subjects.MATHEMATICS);
        learner3.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        learner3.registerSubjects(Subjects.HISTORY);

        learner4.registerSubjects(Subjects.ECONOMICS);
        learner4.registerSubjects(Subjects.LIFE_SCIENCE);
        learner4.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        learner4.registerSubjects(Subjects.ENGLISH);
        learner4.registerSubjects(Subjects.LIFE_SCIENCE);
        learner4.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        learner5.registerSubjects(Subjects.ECONOMICS);
        learner5.registerSubjects(Subjects.HISTORY);
        learner5.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        lesson.addLearners(learner1);
        lesson.addLearners(learner2);
        lesson.addLearners(learner3);
        lesson.addLearners(learner4);
        lesson.addLearners(learner5);

        assertEquals(lesson.startLesson(7, teacher), "successful");
    }
}