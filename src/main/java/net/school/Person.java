package net.school;

public class Person {

    String firstName;
    String lastName;
    String emaiAdress;

    public Person(String  first, String last, String email) {
        firstName = first;
        lastName = last;
        emaiAdress = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emaiAdress;
    }
}
