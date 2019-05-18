package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeachersTest {

    @Test
    public void shouldGetFirstName() {
        Teachers teachers = new Teachers("Mr Alex","bayo","bayo@gmail.com");

        assertEquals("Mr Alex", teachers.getFirstName());
    }

    @Test
    public void shouldGetLastName() {
        Teachers teachers = new Teachers("Mr Alex","Thafeni","bayo@gmail.com");

        assertEquals("Thafeni", teachers.getLastName());
    }

    @Test
    public void shouldGetEmail() {
        Teachers teachers = new Teachers("Mr Alex","bayo","Afzaal@gmail.com");

        assertEquals("Afzaal@gmail.com", teachers.getEmaiAdress());
    }

    @Test
    public void shouldBeAbleToAddSubjects(){
        Teachers teachers = new Teachers("Mr Alex","bayo","bayo@gmail.com");

        teachers.registerSubjects(Subjects.ECONOMICS);
        teachers.registerSubjects(Subjects.HISTORY);
        teachers.registerSubjects(Subjects.LIFE_SCIENCE);
        teachers.registerSubjects(Subjects.ENGLISH);
        assertEquals(teachers.getRegisteredSubjects().toString(),"[ECONOMICS, HISTORY, LIFE_SCIENCE, ENGLISH]");
    }

    @Test
    public void shouldNotAddDuplicateSubjects(){
        Teachers teachers = new Teachers("Mr Alex","bayo","bayo@gmail.com");

        teachers.registerSubjects(Subjects.ECONOMICS);
        teachers.registerSubjects(Subjects.LIFE_SCIENCE);
        teachers.registerSubjects(Subjects.LIFE_SCIENCE);
        teachers.registerSubjects(Subjects.ENGLISH);
        assertEquals(teachers.getRegisteredSubjects().toString(),"[ECONOMICS, LIFE_SCIENCE, ENGLISH]");
    }
    @Test
    public void shouldGetStudentDetails() {
        Teachers teachers = new Teachers("Mr Alex","bayo","bayo@gmail.com");

        teachers.registerSubjects(Subjects.ECONOMICS);
        teachers.registerSubjects(Subjects.ENGLISH);
        teachers.registerSubjects(Subjects.MATHEMATICS);
        teachers.registerSubjects(Subjects.LIFE_SCIENCE);
        assertEquals(teachers.getAllDetails(),  teachers.getFirstName()+ " you have registered for the following subjects ECONOMICS, ENGLISH, MATHEMATICS, LIFE_SCIENCE, ");
    }
}