import java.sql.*;

public class DBUtils{
    static Connection con;
    static Statement stmt;

    static{
        try{
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "root";

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);
            stmt= con.createStatement();
        }catch(Exception e){
            System.out.println("DB connection error : "+e.getMessage());
    //     }catch(ClassNotFoundException e){
    //     System.out.println("MySQL JDBC Driver Not Found!");
    // } 
    // catch(NullPointerException e){
    //     System.out.println("null ye");
     } 
    }

    public static ResultSet executeQuery(String query){
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery(query);   // store result
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;    // return the ResultSet
    }

    public static void executeUpdate(String query){
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ResultSet executeQueryGetResult(String query){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

}