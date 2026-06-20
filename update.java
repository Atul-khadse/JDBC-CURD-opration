import java.sql.*;

public class update {


    public static void displayStudent(Connection con){
        String sql = " SELECT * FROM students";

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("email"));

            }
        }
        catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public static void updateStudent(Connection con, int id, String name, String email){
            String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?";

            try{
                PreparedStatement pstmt = con.prepareStatement(sql);
              pstmt.setString(1, name);
              pstmt.setString(2, email);
                pstmt.setInt(3, id);

                int result = pstmt.executeUpdate();
                System.out.println("Updated " + result + " row(s) in the students table.");
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
                e.printStackTrace();
            }
    }



    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "Atul@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            updateStudent(con, 1, "pink", "pink@gmail.com");
            displayStudent(con);

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
