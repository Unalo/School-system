package net.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    public void shouldGetFirstNameForTeacher() {
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        assertEquals("Mr Alex", teacher.getFirstName());
    }

    @Test
    public void shouldGetLastNameForTeacher() {
        Teacher teacher = new Teacher("Mr Alex","Thafeni","bayo@gmail.com");

        assertEquals("Thafeni", teacher.getLastName());
    }

    @Test
    public void shouldGetEmailForTeacher() {
        Teacher teacher = new Teacher("Mr Alex","Afzaal","Afzaal@gmail.com");

        assertEquals("Afzaal@gmail.com", teacher.getEmailAddress());
    }

    @Test
    public void shouldBeAbleToAddSubjectsForTeacher(){
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
    public void shouldGetTeacherDetails() {
        Teacher teacher = new Teacher("Mr Alex","bayo","bayo@gmail.com");

        teacher.registerSubjects(Subjects.ECONOMICS);
        teacher.registerSubjects(Subjects.ENGLISH);
        teacher.registerSubjects(Subjects.MATHEMATICS);
        teacher.registerSubjects(Subjects.LIFE_SCIENCE);
        teacher.registerSubjects(Subjects.PHYSICAL_SCIENCE);
        assertEquals(teacher.getAllDetails(),  teacher.getFirstName()+ " you have registered to teach the following subjects ECONOMICS, ENGLISH, MATHEMATICS, LIFE_SCIENCE, PHYSICAL_SCIENCE, ");
    }
    @Test
    public void shouldBeAbleToGiveTeacherTokensForLesson() {
        Learner Inam = new Learner("Inam","bayo","inam@gmail.com");
        Learner unalo = new Learner("unalo","bayo","unalo@gmail.com");
        Learner sive = new Learner("sive", "mjanyana", "sive@gmail.com");
        Learner anga = new Learner("anga", "bobo", "anga@gmail.com");
        Learner asanda = new Learner("asanda", "Ndesi", "Ndesi@gmail.com");
        Learner Bonga = new Learner("Bonga", "Mpani", "Mpani@gmail.com");

        Teacher Msiyana = new Teacher("max", "funa", "funa@gmail.com");
        Lesson lesson = new Lesson(Subjects.ECONOMICS);

        Msiyana.registerSubjects(Subjects.ENGLISH);
        Msiyana.registerSubjects(Subjects.ECONOMICS);
        Msiyana.registerSubjects(Subjects.MATHEMATICS);
        Msiyana.registerSubjects(Subjects.HISTORY);

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

        lesson.addLearners(unalo);
        lesson.addLearners(sive);
        lesson.addLearners(anga);
        lesson.addLearners(asanda);
        lesson.addLearners(Bonga);
        lesson.addLearners(Inam);

        lesson.startLesson(5, Msiyana);

        System.out.println(Msiyana.getTokenBalance());
        assertEquals(Msiyana.getTokenBalance(),  "Mr Funa you have 5 Tokens");
    }
}
