import java.util.*;

class BankView{

    Scanner sc = new Scanner(System.in);

    public int showAdminMenu(){

        System.out.println("------Banking System------");
        System.out.println("1. Display accounts");
        System.out.println("2. Search account");
        System.out.println("3. Delete account");
        System.out.println("4. Exit");
        System.out.println("Enter choice : ");

        return sc.nextInt();
    }

    public int showUserMenu(){

        System.out.println("------Banking System------");
        System.out.println("1. Create account");
        System.out.println("2. Display account details");
        System.out.println("3. Check balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
        System.out.println("Enter choice : ");

        return sc.nextInt();
    }

    public int showLoginMenu(){

        System.out.println("------Login System------");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Exit");
        System.out.println("Enter choice : ");

        return sc.nextInt();
    }

    public void displayAccounts(List<Account> accounts){

        if(!accounts.isEmpty()){
            for(Account account : accounts){
                System.out.println("Id : " + account.getId() + " | Name : " + account.getName() + " | Balance : "+ account.getBalance());
            }
            return;
        }
        
        System.out.println("No account found");
    }

    public void displayAccount(Account account){

        System.out.println("Id : " + account.getId() + " | Name : " + account.getName() + " | Balance : "+ account.getBalance());

    }

    public void showMessage(String msg){

        System.out.println(msg);

    }

    public void showMessage(Exception e){
        System.out.println(e);
    }

    public int getInput(){
        return sc.nextInt();

    }

    public Account getAccountDetails(){

        System.out.print("Enter name : ");
        String name = sc.next();

        System.out.print("Enter balance : ");
        int balance = sc.nextInt();

        Account account = new Account(name, balance);

        return account;
    } 

    public void showBalance(int balance){
        System.out.println("Balance : " + balance);

    }

}