import java.sql.*;
import java.util.*;


class BankController{

    DBConnection database = new DBConnection();
    Connection con = database.db();

    Scanner sc = new Scanner(System.in);
    BankView view = new BankView();

    public void start(){
        int choice = view.showLoginMenu();

        // User user = view.getUserDList<User> users = new ArrayList<>(
                //     Arrays.asList(
                //         new User("Jack", "2342"),
                //         new User("Nicole", "1234")
                //     )
                // );etails();

        if(choice == 1 /*&& (user.getName().equalsIgnoreCase("admin") && user.getPassword().equals("1234"))*/){

            do{
                view.showMessage("Enter choice : ");
                choice = view.showAdminMenu();

                    switch(choice){

                    case 1: 
                        view.displayAccounts(getAccounts());
                        break;

                    case 2:
                        view.showMessage("Enter search id : ");
                        int id = view.getInput();

                        Account account = searchAccount(id);
                        view.displayAccount(account);
                        break;

                    case 3:
                        view.showMessage("Enter id : ");

                        id = view.getInput();
                        deleteAccount(id);
                        break;
                        
                    case 4: 
                        view.showMessage("You have exited");
                        break;

                    default:
                        view.showMessage("Invalid choice");
                }

            }while(choice != 4);

        }
        else if(choice == 2){

            do{

                // List<User> users = new ArrayList<>(
                //     Arrays.asList(
                //         new User("Jack", "2342"),
                //         new User("Nicole", "1234")
                //     )
                // );

                // 

                // if(!users.contains(user)){
                //     view.showMessage("No user found");
                //     break;
                // }
                
                // else if(users.get(us){

                // }

                Account account = null;

                view.showMessage("Enter choice : ");
                choice = view.showUserMenu();

                switch(choice){

                    case 1:
                        account = view.getAccountDetails();
                        addAccount(account.getName(), account.getBalance());
                        break;

                    case 2: 
                        view.showMessage("Enter id : ");
                        int id = view.getInput();

                        view.displayAccount(searchAccount(id));
                        break;

                    case 3:
                        view.showMessage("Enter id ; ");
                        id = view.getInput();

                        account = searchAccount(id);
                        view.showBalance(account.getBalance());
                        break;

                    case 4:
                        view.showMessage("Enter amount : ");
                        int amount = view.getInput();

                        view.showMessage("Enter id ; ");
                        id = view.getInput();

                        Deposit(searchAccount(id), amount);
                        break;

                    case 5:
                        view.showMessage("Enter amount : ");
                        amount = view.getInput();

                        view.showMessage("Enter id ; ");
                        id = view.getInput();

                        Withdraw(searchAccount(id), amount);
                        break;

                    case 6:
                        view.showMessage("You have exited");
                        break;

                    default:
                        view.showMessage("Invalid choice");
                }
                
            }while(choice != 6);

        }
        else if(choice == 3){
            view.showMessage("You have exited login menu");
        }
        else{
            view.showMessage("Invalid choice");
        }
    }
    
    public void Withdraw(Account account, int amount){
        // if(account.getBalance() >= amount){
        //     account.setBalance(-amount);
        // }

        try{
            PreparedStatement ps = con.prepareStatement("update account set balance = ? where id = ?");
            ps.setInt(1, account.getBalance() - amount);
            ps.setInt(2, account.getId());

            int rows = ps.executeUpdate();

            if(rows > 0){
                view.showMessage("Updated successfully");
                return;
            }

        }
        catch(Exception e){
            view.showMessage(e);
            return;
        }
    }

    public void Deposit(Account account, int amount){
        // if(amount > 0){
        //     account.setBalance(amount);
        //     view.showMessage("Updated Balance : ");
        //     view.showBalance(account.getBalance());
        // }
        try{
            PreparedStatement ps = con.prepareStatement("update account set balance = ? where id = ?");
            ps.setInt(1, account.getBalance() + amount);
            ps.setInt(2, account.getId());

            int rows = ps.executeUpdate();

            if(rows > 0){
                view.showMessage("Updated successfully");
                return;
            }

        }
        catch(Exception e){
            view.showMessage(e);
            return;
        }
    }
    
    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();


        try{
            PreparedStatement ps = con.prepareStatement("select * from account");

            ResultSet rs = ps.executeQuery();

            Account account;
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int balance = rs.getInt(3);
           
                account = new Account(id, name, balance);
                accounts.add(account);
            }            
        }
        catch(Exception e){
            view.showMessage(e);
        }

        return accounts;
    }

    public void deleteAccount(int id){
        // Account account = searchAccount(id);
        
        try{
            PreparedStatement ps = con.prepareStatement("delete from account where id = ?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                view.showMessage("account Deleted successfully");
                return;
            }

        }
        catch(Exception e){
            view.showMessage(e);
            return;
        }
    }

    public void addAccount(String name, int balance){
        
        try{
            PreparedStatement ps = con.prepareStatement("insert into account(name, balance) values(?, ?)");
            ps.setString(1, name);
            ps.setInt(2, balance);

            int rows = ps.executeUpdate();
            
            if(rows > 0){
                Account account = new Account(name, balance);
                view.showMessage("Account created successfully");
                return;
            }
            else{
                view.showMessage("Failed");
            }
            ps.close();
            
        }
        catch(Exception e){
            view.showMessage(e);
            view.showMessage("No account found");
        }

    }

    public Account searchAccount(int sid){

        try{
            PreparedStatement ps = con.prepareStatement("select * from account where id = ?");
            ps.setInt(1, sid) ;

            ResultSet rs = ps.executeQuery();

            Account account;
            
            if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int balance = rs.getInt(3);
           
                account = new Account(id, name, balance);
                return account;
            }            
            ps.close();
            rs.close();
        }
        catch(Exception e){
            view.showMessage(e);
        }
        return null;
    }
    
}