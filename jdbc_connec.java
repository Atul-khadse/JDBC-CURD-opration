import java.sql.*;

public class jdbc_connec {
    public static void main(String[] args) {

    String url = "jdbc:mysql://localhost:3306/school";
    String user = "root";
    String password = "Atul@123";

    try{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        while(rs.next()){
            System.out.println(rs.getInt("id")+ " " + rs.getString("name") + " " + rs.getInt("age"));
        }

        rs.close();
        stmt.close();
        con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

}
    
}
