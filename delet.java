import java.sql.*;
public class delet {
    



public static void deleteStudent(Connection con, int id){
    String sql = "DELETE FROM students WHERE id = ?";


    try{
        PreparedStatement pstmt  = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

        System.out.println("Deleted student with id: " + id);
    }
    catch (SQLException e) {
        System.err.println("Database error: " + e.getMessage());
        e.printStackTrace();
    }
}


    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "Atul@123";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(url , user , password);

                deleteStudent(con, 3);

        }
        catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
