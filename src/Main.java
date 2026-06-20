import javax.lang.model.element.NestingKind;
import java.sql.*;

public  class Main{

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String userName = "root";
    private static final String password = "2003";

    public  static  void main(String[] args){

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            String query = "select * from students";

//            String query1 = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", "pankaj", 24, 74.5 );



//            String query2 = String.format("UPDATE students SET age = %d WHERE id = %d",20,6);

            String query3 = "DELETE FROM students WHERE id = 2";


            int rowsAffect = statement.executeUpdate(query3);
            if (rowsAffect > 0){
                System.out.println("Data inserted succesfully");
            }else{
                System.out.println("Date not insertde");
            }


//            ResultSet resultSet = statement.executeQuery(query);
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//                System.out.println("ID: "+id);
//                System.out.println("NAME: "+name);
//                System.out.println("AGE: "+age);
//                System.out.println("MARKS"+marks);
//            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        }
}