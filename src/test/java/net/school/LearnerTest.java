package net.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LearnerTest {

    @BeforeEach
    public void clearMap() {
        Lesson lesson = new Lesson( Subjects.ENGLISH);
        lesson.clearStudentToken();
    }
    @Test
    public void shouldGetFirstNameFoeStudent() {
        Learner learner = new Learner("inam","bayo","inam@gmail.com");

        assertEquals("Inam", learner.getFirstName());
    }

    @Test
    public void shouldGetLastNameForStudent() {
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");

        assertEquals("Bayo", learner.getLastName());
    }

    @Test
    public void shouldGetEmailForStudent() {
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");

        assertEquals("inam@gmail.com", learner.getEmailAddress());
    }

    @Test
    public void shouldBeAbleToAddSubjectsForStudent(){
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");
        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        assertEquals(learner.getRegisteredSubjects().toString(),"[ECONOMICS, ENGLISH]");

    }

    @Test
    public void shouldNotAddDuplicateSubjects(){
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");
        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        learner.registerSubjects(Subjects.ENGLISH);
        assertEquals(learner.getRegisteredSubjects().toString(),"[ECONOMICS, ENGLISH]");
    }
    @Test
    public void shouldGetStudentDetails() {
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");
        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.ENGLISH);
        learner.registerSubjects(Subjects.MATHEMATICS);
        assertEquals(learner.getAllDetails(),  learner.getFirstName() + " you have registered for the following subjects ECONOMICS, ENGLISH, MATHEMATICS, ");
    }

    @Test
    public void shouldBeAbleToSuccessfullyStartALesson() {
        Learner Inam = new Learner("Inam","bayo","inam@gmail.com");
        Learner sive = new Learner("sive", "mjanyana", "sive@gmail.com");
        Learner anga = new Learner("anga", "bobo", "anga@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");


        Inam.registerSubjects(Subjects.ECONOMICS);
        Inam.registerSubjects(Subjects.ENGLISH);
        Inam.registerSubjects(Subjects.MATHEMATICS);

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

        Teacher Jones = new Teacher("Mr Micheal", "Jones", "jones@gmail.com");

        Jones.registerSubjects(Subjects.ENGLISH);
        Jones.registerSubjects(Subjects.ECONOMICS);
        Jones.registerSubjects(Subjects.MATHEMATICS);
        Jones.registerSubjects(Subjects.HISTORY);

        Lesson lesson = new Lesson(Subjects.ECONOMICS);


        lesson.addLearners(sive);
        lesson.addLearners(Inam);
        lesson.addLearners(anga);
        lesson.addLearners(asanda);
        lesson.addLearners(Bonga);

        assertEquals(lesson.startLesson(7, Jones) , "successful");
    }

    @Test
    public void shouldBeToCancelLesson() {
        Lesson lesson = new Lesson(Subjects.ECONOMICS);

        Teacher teacher = new Teacher("max", "funa", "funa@gmail.com");

        Learner unalo = new Learner("unalo","bayo","unalo@gmail.com");
        Learner sive = new Learner("sive", "mjanyana", "sive@gmail.com");
        Learner anga = new Learner("anga", "bobo", "anga@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

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

        lesson.addLearners(sive);
        lesson.addLearners(unalo);
        lesson.addLearners(anga);
        lesson.addLearners(asanda);


//        System.out.println(lesson.studentTokens);
//        for (Person learner:  lesson.studentTokens.keySet()) {
//            System.out.println(learner.firstName+ " " + learner.lastName);
//        }

//        Learner learner = new Learner("siya", "mtshokotsha", "siya@live.com");
//
//        learner.registerSubjects(Subjects.ECONOMICS);
//        learner.registerSubjects(Subjects.LIFE_SCIENCE);
//        learner.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        assertEquals(lesson.startLesson(7, teacher), "cancelled");
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

}