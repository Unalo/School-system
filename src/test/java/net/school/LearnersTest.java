package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnersTest {

    @Test
    public void shouldGetFirstName() {
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");

        assertEquals("Inam", learners.getFirstName());
    }

    @Test
    public void shouldGetLastName() {
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");

        assertEquals("bayo", learners.getLastName());
    }

    @Test
    public void shouldGetEmail() {
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");

        assertEquals("inam@gmail.com", learners.getEmaiAdress());
    }

    @Test
    public void shouldBeAbleToAddSubjects(){
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");
        learners.registerSubjects(Subjects.ECONOMICS);
        learners.registerSubjects(Subjects.ENGLISH);
        assertEquals(learners.getRegisteredSubjects().toString(),"[ECONOMICS, ENGLISH]");
    }

    @Test
    public void shouldNotAddDuplicateSubjects(){
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");
        learners.registerSubjects(Subjects.ECONOMICS);
        learners.registerSubjects(Subjects.ENGLISH);
        learners.registerSubjects(Subjects.ENGLISH);
        assertEquals(learners.getRegisteredSubjects().toString(),"[ECONOMICS, ENGLISH]");
    }
    @Test
    public void shouldGetStudentDetails() {
        Learners learners = new Learners("Inam","bayo","inam@gmail.com");
        learners.registerSubjects(Subjects.ECONOMICS);
        learners.registerSubjects(Subjects.ENGLISH);
        learners.registerSubjects(Subjects.MATHEMATICS);
        assertEquals(learners.getAllDetails(),  learners.getFirstName()+ " you have registered for the following subjects ECONOMICS, ENGLISH, MATHEMATICS, ");
    }

}