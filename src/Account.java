
import javax.swing.JOptionPane;


/**
 *
 * @author Jose Rodriguez
 */


class Account {
    public String accountNumber = "";
    public java.util.Date openDate;
    public String customerName = "";   
    public double balance = 0.0;
    

    public Account() {
        
    }

    public Account(String accountNumber, java.util.Date opendDate, String customerName, double balance) {
        this();
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.customerName = customerName;       
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public java.util.Date getOpenDate() {
        return this.openDate;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }    
     
    public void setOpenDate(java.util.Date openDate) {
        this.openDate = openDate;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }   

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void transferTo (double transferAmount, Account fromAccount, Account toAccount) {          
        fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
        toAccount.setBalance(toAccount.getBalance() + transferAmount);     
    }
        
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
   
    }

