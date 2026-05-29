package database;
import java.sql.*;

public class DBConnection{
    public Connection db(){
        Connection con = null;

    try{

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_db", "root", "praveen");

        if(con != null){
            System.out.println("DB connected");
            return con;
        }
        else{
            System.out.println("Db unsuccess");
        }
        // Statement st = con.createStatement();

        // ResultSet rs = st.executeQuery("select * from e1");

        // while(rs.next()){
        //     int eid = rs.getInt("eid");
        //     String ename = rs.getString("ename");
        //     System.out.println("Id : "+ eid + "Name : " + ename);
        // }
        //     con.close();
        //     st.close();
        //     rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}