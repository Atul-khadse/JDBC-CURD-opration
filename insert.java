import java.sql.*;


public class insert {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String user = "root";
    private static final String password  = "Atul@123";



    public static void columAdd(Connection con, String columnName, String dataType){

        String sql = "ALTER TABLE students ADD COLUMN " + columnName + " " + dataType;

        try(Statement stmt = con.createStatement()){
                stmt.executeUpdate(sql);
                System.out.println("Column " + columnName + " added successfully.");

        }
        catch (SQLException e) {
            System.err.println("Error adding column: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertStudent(Connection con, int id, String name, int age){
        String sql = "INSERT INTO students (id , name , age) VALUES (?,?,?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){

          pstmt.setInt(1, id);
          pstmt.setString(2, name);
          pstmt.setInt(3,age);

          int result = pstmt.executeUpdate();
          System.out.println("Inserted " + result + " row(s) into the students table.");

        } catch (SQLException e) {
            e.printStackTrace();
    }
    }


    public static void displayStudent(Connection con){
        String sql = "SELECT * FROM students";

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, user, password); 

            insertStudent(con, 4, "John Doe", 20);
            displayStudent(con);
            columAdd(con, "email", "VARCHAR(255)");


           

        } catch (ClassNotFoundException e) {
             System.err.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
              System.err.println("Database connection error!");
            e.printStackTrace();
        }
    }
}
