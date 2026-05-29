import database.DBConnection;

public class Main{
    public static void main(String[] args){

        BankController controller = new BankController();

        DBConnection start = new DBConnection();
        
        controller.start();
    }
}