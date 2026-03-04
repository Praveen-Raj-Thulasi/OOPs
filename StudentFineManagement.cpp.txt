#include <bits/stdc++.h>
using namespace std;


class User{
    public:
        string role;
        string name;
        string emailId;
        string password;
};

class Payment{
    public:
        string emailId;
        string type;
        string amount;
        string date;
};

vector<User*> user;
vector<Payment*> payment;

void EditProfile(User* u){
    while(true){
        cout << "1. Name" << "\n";
        cout << "2. EmailId" << "\n";
        cout << "3. Password" << "\n";
        cout << "4. Exit\n" ;
        int n;
        cin >> n;
        switch(n){
            case 1:
                {
                    string name;
                    cout << "Enter name : "; cin >> name;
                    u->name = name;
                    break;
                }
            case 2: 
                {
                    string emailId;
                    cout << "Enter emailId : "; cin >> emailId;
                    u->emailId = emailId;
                    break;
                }
            case 3: 
                {
                    string password;
                    cout << "Enter name : "; cin >> password;
                    u->password = password;
                    break;
                }
            case 4:
                "Exited";
                return;
            default:
                cout << "Invalid option\n";
        }
    }
}
void AddPayment(){
    string emailId;
    string type;
    string amount;
    string date;
    
    cout << "Enter emailID: "; cin >> emailId;
    cout << "Enter type: "; cin >> type;
    cout << "Enter amount: "; cin >> amount;
    cout << "Enter date: "; cin >> date;
    
    Payment* p = new Payment();
    p->emailId = emailId;
    p->type = type;
    p->amount = amount;
    p->date = date;
    payment.push_back(p);
    cout << "Payment added successfully\n";
}

void UpdatePayment(Payment* p){
    
    while(true){
        cout << "1. Type\n" ;
        cout << "2. Amount\n" ;
        cout << "3. Date\n" ;
        cout << "4. Exit\n" ;
        
        int n;
        cin >> n;
        
        switch(n){
            case 1: 
                {
                    cout << "Enter type: ";
                    string type; 
                    cin >> type;  
                    p->type = type;
                    break;
                }
            case 2: 
                {
                    cout << "Enter amount: ";
                    string amount; 
                    cin >> amount;  
                    p->amount = amount;
                    break;
                }
            case 3: 
                {
                    cout << "Enter date: ";
                    string date; 
                    cin >> date;  
                    p->date = date;
                    break;
                }
            case 4: 
                {
                    "Exited";
                    return;
                }
            default:
                cout << "Invalid option\n";
        }
    }
}

void DeletePayment(Payment* p){
    for(int i = 0; i < payment.size(); i++){
        if(payment[i]->emailId == p->emailId){
            payment.erase(payment.begin() + i);
            cout << "Payment deleted successfully";
            return;
        }
    }
    cout << "No records found";
}

void Student(User* u){
    while(true){
        cout << "1. View Profile\n";
        cout << "2. Edit Profile\n";
        cout << "3. Exit\n" ;
        int n;
        cin >> n;
        switch(n){
            case 1: 
                {
                    cout << "Name :" << u->name << "\n";
                    cout << "EmailId :" << u->emailId << "\n";
                    cout << "Password :" << u->password << "\n";
                    break;
                }
            case 2: 
                {
                    EditProfile(u);
                    break;
                }
            case 3: 
                "Exited";
                return;
            default:
                cout << "Invalid option\n";
        }
    }
}

void Admin(User* u){
    while(true){
        cout << "1. View all payments\n";
        cout << "2. Filter payments by fine type\n";
        cout << "3. Filter payments by student\n" ;
        cout << "4. Filter payments by date\n";
        cout << "5. Filter payments by date range\n";
        cout << "6. Add payment\n";
        cout << "7. Update payment\n";
        cout << "8. Delete payment\n";
        cout << "9. Exit\n";
        int n;
        cin >> n;
        switch(n){
            case 1: 
                {
                    cout << "All student payments";
                    for(int i = 0; i < payment.size(); i++){
                        cout << "EmailId :" << payment[i]->emailId <<"\n";
                        cout << "Type :" << payment[i]->type <<"\n";
                        cout << "Amount :" << payment[i]->amount <<"\n";
                        cout << "Date :" << payment[i]->date <<"\n\n";
                    }
                    break;
                }
            case 2:
                {
                    string type;
                    cout << "Enter the payment type : " ;cin >> type;
                    for(int i = 0; i < payment.size(); i++){
                        if(payment[i]->type == type){
                            cout << "EmailId :" << payment[i]->emailId <<"\n";
                            cout << "Amount :" << payment[i]->amount <<"\n";
                            cout << "Date :" << payment[i]->date <<"\n\n";
                        }
                    }
                    break;
                }
            case 3:
                {
                    string emailId;
                    cout << "Enter the student mail : ";cin >> emailId;
                    for(int i = 0; i < payment.size(); i++){
                        if(payment[i]->emailId == emailId){
                            cout << "Type :" << payment[i]->type;
                            cout << "Amount :" << payment[i]->amount;
                            cout << "Date :" << payment[i]->date;
                        }
                    }
                    break;
                }
            case 4:
                {
                    string date;
                    cout << "Enter the date";cin >> date;
                    for(int i = 0; i < payment.size(); i++){
                        if(payment[i]->date == date){
                            cout << "EmailId :" << payment[i]->emailId <<"\n";
                            cout << "Type :" << payment[i]->type <<"\n";
                            cout << "Amount :" << payment[i]->amount <<"\n";
                        }
                    }
                    break;
                }
            case 5: 
                {
                    string type;
                    string startdate;
                    string enddate;
                    cout << "Enter the type : "; cin >> type;
                    cout << "Enter the startdate : "; cin >> startdate;
                    cout << "Enter the enddate : "; cin >> enddate;
                    for(int i = 0; i < payment.size(); i++){
                        if( payment[i]->type == type && ( payment[i]->date >= startdate && payment[i]->date <= enddate ) ){
                            cout << "EmailId :" << payment[i]->emailId <<"\n";
                            cout << "Type :" <<  payment[i]->type <<"\n";
                            cout << "Amount :" << payment[i]->amount <<"\n";
                        }
                    }
                    break;
                }
            case 6: 
                {
                    AddPayment();
                    break;
                }
            case 7:
                {
                    string emailId;
                    cout << "Enter student emailId : "; cin >> emailId;
                    for(int i = 0; i < payment.size(); i++){
                        if(emailId == payment[i]->emailId){
                            UpdatePayment(payment[i]);
                        }
                    }
                    break;
                }
            case 8:
                {
                    string emailId;
                    cout << "Enter student emailId : "; cin >> emailId;
                    for(int i = 0; i < payment.size(); i++){
                        if(emailId == payment[i]->emailId){
                            DeletePayment(payment[i]);
                        }
                    }
                    break;
                }
            case 9:
                {
                    "Exited\n";
                    return;
                }
            default:
                cout << "Invalid option\n";
            
        }
    }
}

void Cashier(User* u){
    while(true){
        cout << "1. Add payment\n";
        cout << "2. Update payment\n";
        cout << "3. Delete payment\n";
        cout << "4. Exit\n" ;
        int n;
        cin >> n;
        switch(n){
            case 1: 
                {
                    AddPayment();
                    break;
                }
            case 2: 
                {
                    string emailId;
                    cout << "Enter student emailId : "; cin >> emailId;
                    for(int i = 0; i < payment.size(); i++){
                        if(emailId == payment[i]->emailId){
                            UpdatePayment(payment[i]);
                        }
                    }
                    break;
                }
            case 3: 
                {
                    string emailId;
                    cout << "Enter student emailId : "; cin >> emailId;
                    for(int i = 0; i < payment.size(); i++){
                        if(emailId == payment[i]->emailId){
                            DeletePayment(payment[i]);
                        }
                    }
                    break;
                }
            case 4:
                {
                    "Exited\n";
                    return;
                }
            default:
                {
                    cout << "Invalid option\n";
                }
        }
    }
}

void Register(string role, string name, string emailId, string password){
    for(int i = 0; i < user.size(); i++){
        if(user[i]->emailId == emailId){
            cout << "User already exists\n";
            return;
        }
    }
    User* u = new User();
    u->role = role;
    u->name = name;
    u->emailId = emailId;
    u->password = password;
    user.push_back(u);
    cout << "Register Successfull\n";
}

void Login(string emailId, string password){
    for(int i = 0 ; i < user.size(); i++){
        if(user[i]->emailId == emailId && user[i]->password == password){
            cout << "Login Succcessfull\n";
            
            if(user[i]->role == "admin"){
                Admin(user[i]);
                return;
            }
            else if(user[i]->role == "cashier"){
                Cashier(user[i]);
                return;
            }
            else{
                Student(user[i]); 
                return;
            }
        }
    }
    cout << "No records found\n";
}

int main() {
    
    while(true){
        cout << "Fine Management System\n";
        cout << "1. Login\n";
        cout << "2. Register\n";
        cout << "3. Exit\n";
        int n;
        cin >> n;
        string name;
        string emailId;
        string password;
        string role;
        switch(n){
            case 1: 
                {
                    cout << "EmailId :"; cin >> emailId;
                    cout << "password :"; cin >> password;
                    Login(emailId, password);
                    break;
                }
            case 2: 
                {
                    cout << "Role :"; cin >> role;
                    cout << "Name :"; cin >> name;
                    cout << "EmailId :"; cin >> emailId;
                    cout << "password :"; cin >> password;
                    Register(role, name, emailId, password);
                    break;
                }
            case 3: 
                cout << "Thank you\n";
                return 0;
            default: 
                "Invalid option\n";
        }
    }
        
    

    return 0;
}