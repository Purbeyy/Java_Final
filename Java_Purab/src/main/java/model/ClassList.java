package model;

import java.util.Scanner;

public class ClassList {
    int id;
    String classname;

    public ClassList() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public ClassList(int id, String classname) {
        this.id = id;
        this.classname = classname;
    }
    public void populate_class(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Classname: ");
        this.classname=sc.nextLine();
    }

}
