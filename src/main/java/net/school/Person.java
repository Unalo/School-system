package net.school;

public class Person {

    String firstName;
    String lastName;
    String emailAddress;

    public Person(String  first, String last, String email) {
        firstName = first;
        lastName = last;
        emailAddress = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
