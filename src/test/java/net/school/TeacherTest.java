package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    public void shouldGetFirstName() {
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        assertEquals("Mr Alex", teacher.getFirstName());
    }

    @Test
    public void shouldGetLastName() {
        Teacher teacher = new Teacher("Mr Alex","Thafeni","bayo@gmail.com");

        assertEquals("Thafeni", teacher.getLastName());
    }

    @Test
    public void shouldGetEmail() {
        Teacher teacher = new Teacher("Mr Alex","Afzaal","Afzaal@gmail.com");

        assertEquals("Afzaal@gmail.com", teacher.getEmailAddress());
    }

    @Test
    public void shouldBeAbleToAddSubjects(){
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.HISTORY);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.ENGLISH);
        assertEquals(teacher.getRegisteredSubjects().toString(),"[ECONOMICS, HISTORY, LIFE_SCIENCE, ENGLISH]");
    }

    @Test
    public void shouldNotAddDuplicateSubjects(){
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.ENGLISH);
        assertEquals(teacher.getRegisteredSubjects().toString(),"[ECONOMICS, LIFE_SCIENCE, ENGLISH]");
    }
    @Test
    public void shouldGetStudentDetails() {
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.ENGLISH);
        teacher.registerSubjects(Subjects.MATHEMATICS);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        assertEquals(teacher.getAllDetails(),  teacher.getFirstName()+ " you have registered to teach the following subjects ECONOMICS, ENGLISH, MATHEMATICS, LIFE_SCIENCE, PHYSICAL_SCIENCE, ");
    }
}