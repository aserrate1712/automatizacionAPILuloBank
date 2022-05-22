package com.lulobank.apirest.certificacion.model;

public class DataUsers {

    private String name;
    private String job;
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public DataUsers(String name, String job,String id,String email, String first_name, String last_name,String avatar)
    {
        this.name=name;
        this.job=job;
        this.id=id;
        this.email=email;
        this.first_name=first_name;
        this.last_name=last_name;
        this.avatar=avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
