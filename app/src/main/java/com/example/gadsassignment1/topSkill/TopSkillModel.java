package com.example.gadsassignment1.topSkill;

public class TopSkillModel {
    private String  name,skill,country,badge;

    public TopSkillModel() {
    }

    public TopSkillModel(String name, String skill, String country, String badge) {
        this.name = name;
        this.skill = skill;
        this.country = country;
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }
}
