package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnerTest {

    @Test
    public void shouldGetFirstName() {
        Learner learner = new Learner("inam","bayo","inam@gmail.com");

        assertEquals("Inam", learner.getFirstName());
    }

    @Test
    public void shouldGetLastName() {
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");

        assertEquals("Bayo", learner.getLastName());
    }

    @Test
    public void shouldGetEmail() {
        Learner learner = new Learner("Inam","bayo","inam@gmail.com");

        assertEquals("inam@gmail.com", learner.getEmailAddress());
    }

    @Test
    public void shouldBeAbleToAddSubjects(){
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
        assertEquals(learner.getAllDetails(),  learner.getFirstName()+ " you have registered for the following subjects ECONOMICS, ENGLISH, MATHEMATICS, ");
    }
}