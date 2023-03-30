package model;

import java.util.Scanner;

public class UserList {
    int id;
    String username;
    String password;

    public UserList() {

    }

    public UserList(int id, String classname) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserList(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public void populate_user(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Username: ");
        this.username=sc.nextLine();
        System.out.println("Enter Password: ");
        this.password=sc.next();


    }
}
