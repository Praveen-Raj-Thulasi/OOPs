class User{
    private String name;
    private String password;

    User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }
}

class Account{
    private int id;
    private String name;
    private int balance;

    Account(int id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    Account(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getBalance(){
        return balance;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBalance(int amount){
        balance += amount;
    }
}
