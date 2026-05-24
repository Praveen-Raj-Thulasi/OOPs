import java.util.*;

class BankController{

    List<Account> accounts = new ArrayList<>(
        Arrays.asList(new Account(1, "Bill", 1200000),
        new Account(2, "John", 230000),
        new Account(3, "Nick", 3230000))
    );

    Scanner sc = new Scanner(System.in);
    BankView view = new BankView();

    public void start(){
        int choice = view.showLoginMenu();

        if(choice == 1){
            do{
                choice = view.showAdminMenu();

                    switch(choice){

                    case 1: 
                        view.displayAccounts(getAccounts());
                        break;

                    case 2:
                        Account account = searchAccount(getAccountId());
                        view.displayAccount(account);
                        break;

                    case 3:
                        deleteAccount(getAccountId());
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
                
                Account account = new Account(4, "Depp" , 120000);

                choice = view.showUserMenu();
                switch(choice){

                    case 1: 
                        view.displayAccount(account);
                        break;

                    case 2:
                        view.showBalance(account.getBalance());
                        break;

                    case 3:
                        int amount = view.getAmount();
                        Deposit(account, amount);
                        break;

                    case 4:
                        amount = view.getAmount();
                        Withdraw(account, amount);
                        break;

                    case 5:
                        view.showMessage("You have exited");
                        break;

                    default:
                        view.showMessage("Invalid choice");
                }
                
            }while(choice != 5);
        }
        else if(choice == 3){
            view.showMessage("You have exited login menu");
        }
        else{
            view.showMessage("Invalid choice");
        }
    }
    
    public void Withdraw(Account account, int amount){
        if(account.getBalance() >= amount){
            account.setBalance(-amount);
        }
    }

    public void Deposit(Account account, int amount){
        if(amount > 0){
            account.setBalance(amount);
            view.showMessage("Updated Balance : ");
            view.showBalance(account.getBalance());
        }
    }
    
    public List<Account> getAccounts(){
        return accounts;
    }

    public void deleteAccount(int id){
        Account account = searchAccount(id);
        
        if(account != null){
            accounts.remove(account);
            return;
        }

        view.showMessage("No account found");
    }

    public Account searchAccount(int id){

        for(Account account : accounts){
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }
    
    public int getAccountId(){
        return sc.nextInt();
    }
    
}