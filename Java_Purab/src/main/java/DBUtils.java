import model.ClassList;
import model.UserList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static Connection connect() {
        Connection connection = null;
        String databaseUrl = "jdbc:sqlite:src/main/resources/database/attandance_management_system.db";
        try {
            connection = DriverManager.getConnection(databaseUrl);
            System.out.println("Connection Established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public void insert_user(Connection connection, String username,String password) {
        String sql = "INSERT INTO user (username,password) VALUES(?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public static List<UserList> getAllUsers(Connection connection){

        String query="SELECT * FROM user";
        List<UserList> UserListList=new ArrayList<>();
        PreparedStatement pstmt = null;
        try{

            Statement statement= connection.createStatement();
            ResultSet rs=statement.executeQuery(query);


            while(rs.next()){

                int id=rs.getInt("id");

                String username=rs.getString(("username"));
                String password=rs.getString(("password"));


                UserList new_UserList=new UserList(id,username,password);

                UserListList.add((new_UserList));


            }


        }catch (SQLException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return  UserListList;

    }
    public void insert_class(Connection connection, String classname) {
        String sql = "INSERT INTO class (classname) VALUES(?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, classname);


            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public static List<ClassList> getAllClass(Connection connection){

        String query="SELECT * FROM class";
        List<ClassList> ClassListList=new ArrayList<>();
        PreparedStatement pstmt = null;
        try{

            Statement statement= connection.createStatement();
            ResultSet rs=statement.executeQuery(query);


            while(rs.next()){

                int id=rs.getInt("id");

                String classname=rs.getString(("classname"));



                ClassList new_ClassList=new ClassList(id,classname);

                ClassListList.add(new_ClassList);


            }


        }catch (SQLException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return  ClassListList;

    }

    public void insert_attendance(Connection connection, int class_id,int user_id,Date date) {
        String sql = "INSERT INTO attandance (classid,userid,date) VALUES(?,?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, class_id);
            pstmt.setInt(2, user_id);
            pstmt.setString(3, String.valueOf(date));



            pstmt.executeUpdate();
            System.out.println("Your attendance has been marked successfully");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public int get_id(Connection connection,String username) {
        String sql = "SELECT * FROM user WHERE username=?  ";
        PreparedStatement pstmt = null;
        int id = 0;
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(id);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return id;
    }


    public boolean loginDatabase(Connection connection,String username,String password){


        boolean bool = false;
        String sql = "SELECT * FROM user WHERE username=? AND password=? ";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();


        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return bool;

    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
