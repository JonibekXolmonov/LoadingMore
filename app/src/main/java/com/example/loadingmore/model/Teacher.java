package com.example.loadingmore.model;

public class Teacher {
    private String name;
    private String subject;
    private Boolean isProfessor;
    private Integer profile;

    public Teacher(String name, String subject, Boolean isProfessor, Integer profile) {
        this.name = name;
        this.subject = subject;
        this.isProfessor = isProfessor;
        this.profile = profile;
    }

    public Teacher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getProfessor() {
        return isProfessor;
    }

    public void setProfessor(Boolean professor) {
        isProfessor = professor;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }
}

