import java.util.*;

class BankView{

    Scanner sc = new Scanner(System.in);

    public int showAdminMenu(){

        System.out.println("------Banking System------");
        System.out.println("1. Display accounts");
        System.out.println("2. Search account");
        System.out.println("3. Delete account");
        System.out.println("4. Exit");

        return sc.nextInt();
    }

    public int showUserMenu(){

        System.out.println("------Banking System------");
        System.out.println("1. Display account details");
        System.out.println("2. Check balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");

        return sc.nextInt();
    }

    public int showLoginMenu(){

        System.out.println("------Login System------");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Exit");

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

    public int getAmount(){
        return sc.nextInt();
    }

    public void showBalance(int balance){
        System.out.println("Balance : " + balance);
    }
}