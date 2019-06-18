package net.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnerTest {

    Learner thabang = new Learner("thabang", "J", "n/a");

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

        thabang.giveToken();
        thabang.giveToken();


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
    public void shouldBeAbleToBuyNotes() {
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
        lesson.addLearners(Bonga);

        lesson.startLesson(7, teacher);

        Learner learner = new Learner("siya", "mtshokotsha", "siya@live.com");

        learner.registerSubjects(Subjects.ECONOMICS);
        learner.registerSubjects(Subjects.LIFE_SCIENCE);
        learner.registerSubjects(Subjects.PHYSICAL_SCIENCE);

        assertEquals( unalo.buyNotes(learner, Subjects.ECONOMICS), unalo.getNotes());
    }
}