package model;

public class User {

    private String pass;
    private String id;
    
    public User(){}

    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    public String getPass(){return pass;}
    public String getId(){return id;}
}
