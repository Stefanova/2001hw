package com.example._hw;
import jakarta.persistence.*;

@Entity
@Table(name = "tutorials")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "grade")
    private int grade;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

    public Student(String fullName, int grade, String email, boolean active) {
        this.fullName = fullName;
        this.grade = grade;
        this.email = email;
        this.active = active;
    }
    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + fullName + "]";
    }
}
