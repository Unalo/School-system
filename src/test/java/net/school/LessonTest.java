package net.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {

    @BeforeEach
    public void clearAll() {
        Lesson lesson = new Lesson( Subjects.ENGLISH);
        lesson.clearStudentToken();
    }

    @Test
    public void shouldValidateTeachersQualifications() {
        Teacher teacher = new Teacher("Mr Alex", "bayo", "bayo@gmail.com");
        Lesson lesson = new Lesson(Subjects.ECONOMICS);

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.HISTORY);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.ENGLISH);

        assertEquals(lesson.teacherValidSubject(teacher), true);
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

        System.out.println(lesson.attendanceList.get(2).firstName);

        assertEquals(lesson.attendanceList.toString(), "[Inam, Unalo, Asanda, Bonga]");
    }

    @Test
    public void shouldStartLessonForGivenSubject() {

        Lesson lesson = new Lesson(Subjects.PHYSICAL_SCIENCE);
        Teacher Baloyi = new Teacher("MR Max", "Baloyi", "baloyi@gmail.com");

        Learner Inam = new Learner("Inam", "bayo", "bayo@gmail.com");
        Learner unalo = new Learner("unalo", "Booi", "Booi@gmail.com");
        Learner Asiphe = new Learner("Asiphe", "khumalo", "khumalo@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

        Baloyi.registerSubjects(Subjects.ECONOMICS);
        Baloyi.registerSubjects(Subjects.HISTORY);
        Baloyi.registerSubjects(Subjects.LIFE_SCIENCE);
        Baloyi.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Inam.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Inam.registerSubjects(Subjects.ENGLISH);
        Inam.registerSubjects(Subjects.MATHEMATICS);

        unalo.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        unalo.registerSubjects(Subjects.LIFE_SCIENCE);
        unalo.registerSubjects(Subjects.MATHEMATICS);

        Asiphe.registerSubjects(Subjects.MATHEMATICS);
        Asiphe.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Asiphe.registerSubjects(Subjects.HISTORY);

        asanda.registerSubjects(Subjects.ECONOMICS);
        asanda.registerSubjects(Subjects.LIFE_SCIENCE);
        asanda.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Bonga.registerSubjects(Subjects.ENGLISH);
        Bonga.registerSubjects(Subjects.LIFE_SCIENCE);
        Bonga.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        lesson.addLearners(Inam);
        lesson.addLearners(unalo);
        lesson.addLearners(Asiphe);
        lesson.addLearners(asanda);
        lesson.addLearners(Bonga);

        assertEquals(lesson.startLesson(7, Baloyi), "successful");
    }

    @Test
    public void shouldGiveStudentsNotes() {

        Lesson lesson = new Lesson(Subjects.PHYSICAL_SCIENCE);
        Teacher Baloyi = new Teacher("MR Max", "Baloyi", "baloyi@gmail.com");

        Learner Inam = new Learner("Inam", "bayo", "bayo@gmail.com");
        Learner unalo = new Learner("unalo", "Booi", "Booi@gmail.com");
        Learner Asiphe = new Learner("Asiphe", "khumalo", "khumalo@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

        Baloyi.registerSubjects(Subjects.ECONOMICS);
        Baloyi.registerSubjects(Subjects.HISTORY);
        Baloyi.registerSubjects(Subjects.LIFE_SCIENCE);
        Baloyi.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Inam.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Inam.registerSubjects(Subjects.ENGLISH);
        Inam.registerSubjects(Subjects.MATHEMATICS);

        unalo.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        unalo.registerSubjects(Subjects.LIFE_SCIENCE);
        unalo.registerSubjects(Subjects.MATHEMATICS);

        Asiphe.registerSubjects(Subjects.MATHEMATICS);
        Asiphe.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Asiphe.registerSubjects(Subjects.HISTORY);

        asanda.registerSubjects(Subjects.ECONOMICS);
        asanda.registerSubjects(Subjects.LIFE_SCIENCE);
        asanda.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Bonga.registerSubjects(Subjects.ENGLISH);
        Bonga.registerSubjects(Subjects.LIFE_SCIENCE);
        Bonga.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        lesson.addLearners(Inam);
        lesson.addLearners(unalo);
        lesson.addLearners(Asiphe);
        lesson.addLearners(asanda);
        lesson.addLearners(Bonga);

        lesson.startLesson(7 , Baloyi);

        System.out.println(Inam.getTokenBalance());

        System.out.println(Inam.getNotes());

        System.out.println(Inam.getTokenBalance());

        assertEquals(Bonga.getNotes(), "Bonga you have PHYSICAL_SCIENCE, notes");
    }

    @Test
    public void shouldBeAbleToGiveStudentsTokensForAttendingLesson() {
        Learner Inam = new Learner("Inam","bayo","inam@gmail.com");
        Learner unalo = new Learner("unalo","bayo","unalo@gmail.com");
        Learner sive = new Learner("sive", "mjanyana", "sive@gmail.com");
        Learner anga = new Learner("anga", "bobo", "anga@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

        Teacher teacher = new Teacher("max", "funa", "funa@gmail.com");
        teacher.registerSubjects(Subjects.ENGLISH);
        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.MATHEMATICS);
        teacher.registerSubjects(Subjects.HISTORY);

        unalo.registerSubjects(Subjects.ECONOMICS);
        unalo.registerSubjects(Subjects.ENGLISH);
        unalo.registerSubjects(Subjects.MATHEMATICS);

        sive.registerSubjects(Subjects.ECONOMICS);
        sive.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        sive.registerSubjects(Subjects.LIFE_SCIENCE);

        anga.registerSubjects(Subjects.ECONOMICS);
        anga.registerSubjects(Subjects.ENGLISH);
        anga.registerSubjects(Subjects.HISTORY);

        asanda.registerSubjects(Subjects.ECONOMICS);
        asanda.registerSubjects(Subjects.LIFE_SCIENCE);
        asanda.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Bonga.registerSubjects(Subjects.ECONOMICS);
        Bonga.registerSubjects(Subjects.LIFE_SCIENCE);
        Bonga.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Inam.registerSubjects(Subjects.ECONOMICS);
        Inam.registerSubjects(Subjects.ENGLISH);
        Inam.registerSubjects(Subjects.MATHEMATICS);

        Lesson lesson = new Lesson(Subjects.ECONOMICS);
        lesson.startLesson(5, teacher);

        assertEquals(3,  Inam.getTokenBalance());
    }

    @Test
    public void shouldGiveTeacherTokens() {

        Lesson lesson = new Lesson(Subjects.PHYSICAL_SCIENCE);
        Teacher Baloyi = new Teacher("MR Max", "Baloyi", "baloyi@gmail.com");

        Learner Inam = new Learner("Inam", "bayo", "bayo@gmail.com");
        Learner unalo = new Learner("unalo", "Booi", "Booi@gmail.com");
        Learner Asiphe = new Learner("Asiphe", "khumalo", "khumalo@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

        Baloyi.registerSubjects(Subjects.ECONOMICS);
        Baloyi.registerSubjects(Subjects.HISTORY);
        Baloyi.registerSubjects(Subjects.LIFE_SCIENCE);
        Baloyi.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Inam.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Inam.registerSubjects(Subjects.ENGLISH);
        Inam.registerSubjects(Subjects.MATHEMATICS);

        unalo.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        unalo.registerSubjects(Subjects.LIFE_SCIENCE);
        unalo.registerSubjects(Subjects.MATHEMATICS);

        Asiphe.registerSubjects(Subjects.MATHEMATICS);
        Asiphe.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        Asiphe.registerSubjects(Subjects.HISTORY);

        asanda.registerSubjects(Subjects.ECONOMICS);
        asanda.registerSubjects(Subjects.LIFE_SCIENCE);
        asanda.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        Bonga.registerSubjects(Subjects.ENGLISH);
        Bonga.registerSubjects(Subjects.LIFE_SCIENCE);
        Bonga.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        lesson.addLearners(Inam);
        lesson.addLearners(unalo);
        lesson.addLearners(Asiphe);
        lesson.addLearners(asanda);
        lesson.addLearners(Bonga);

        lesson.startLesson(7,Baloyi);

        assertEquals(Baloyi.getTokenBalance(), "Mr Baloyi you have 10 Tokens");
    }
}