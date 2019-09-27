package com.spring.demo.model;

/**
 * A Teacher representation
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class TeacherModel {

    private int id;
    private String firstName;
    private String lastName;
    private String subject;

    public TeacherModel(int id, String firstName, String lastName, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
