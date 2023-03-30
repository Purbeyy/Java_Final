import model.ClassList;
import model.UserList;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBUtils.connect();
        Scanner sc = new Scanner(System.in);
        DBUtils db= new DBUtils();

        System.out.println("Enter you Username: ");
        String email = sc.next();

        System.out.println("Enter you Password: ");
        String password = sc.next();
        boolean bool=db.loginDatabase(connection,email,password);
        UserList ul=new UserList();
        ClassList cl=new ClassList();
        if (email.equalsIgnoreCase("admin") && (password.equalsIgnoreCase("adminhero"))) {
            while(true){
                System.out.println("What would you like to do? (1/2/3/4/5)");
                System.out.println("1. Add User");
                System.out.println("2. View User");
                System.out.println("3. Add Class");
                System.out.println("4. View Class");
                System.out.println("5. Log out");
                String res=sc.next();

                if(res.equals("1")){
                    ul.populate_user();
                    db.insert_user(connection,ul.getUsername(), ul.getPassword());
                }
                else if(res.equals("2")){
                    List<UserList> new_UserList=DBUtils.getAllUsers(connection);
                    System.out.println("+----+------------------------+----------------+");
                    System.out.println("| ID |       User Name        |     Password   |");
                    System.out.println("+----+------------------------+----------------+");

                    for(UserList b:new_UserList){
                        System.out.printf("| %-2d | %-22s | %-14s |\n", b.getId(), b.getUsername(), b.getPassword());


                    } System.out.println("+----+------------------------+----------------+");

                }else if(res.equals("3")){
                    cl.populate_class();
                    db.insert_class(connection,cl.getClassname());
                }else if(res.equals("4")){
                    List<ClassList> new_ClassList=DBUtils.getAllClass(connection);
                    System.out.println("+----+------------------------+");
                    System.out.println("| ID |       Class Name       |");
                    System.out.println("+----+------------------------+");

                    for(ClassList b:new_ClassList){
                        System.out.printf("| %-2d | %-22s |\n", b.getId(), b.getClassname());


                    } System.out.println("+----+-----------------------+");
                }else if(res.equals("5")){
                    break;
                }


            }

        } else if(bool){
            int user_id=db.get_id(connection,email);
            List<ClassList> new_ClassList=DBUtils.getAllClass(connection);
            System.out.println("+----+------------------------+");
            System.out.println("| ID |       Class Name       |");
            System.out.println("+----+------------------------+");

            for(ClassList b:new_ClassList){
                System.out.printf("| %-2d | %-22s |\n", b.getId(), b.getClassname());


            } System.out.println("+----+-----------------------+");

            System.out.println("\n\n Enter your Class id:");
            int class_id=sc.nextInt();
            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            db.insert_attendance(connection,class_id,user_id,date);



        }else{
            System.out.println("Incorrect Credentials");
        }
        System.out.println("End OF Program");
    }

}
