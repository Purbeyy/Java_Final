package model;

import java.util.Date;

public class AttendanceList {
    int id;
    int classid;
    int userid;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AttendanceList(int id, int classid, int userid, Date date) {
        this.id = id;
        this.classid = classid;
        this.userid = userid;
        this.date = date;
    }
}
