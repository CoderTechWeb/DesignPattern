package org.design.creational.prototype;

public class Resume implements Document{

    private String candidateName;
    private String skills;

    public Resume(String candidateName, String skills) {
        this.candidateName = candidateName;
        this.skills = skills;
    }

    @Override
    public Document clone() {
        return new Resume(candidateName, skills);
    }

    @Override
    public void printContent() {
        System.out.println("Resume of " + candidateName + " - Skills: " + skills);
    }
}
