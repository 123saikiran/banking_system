import java.util.*;
import java.io.*;
public class Customer implements Serializable {
    private String CName;
    private double account_id;
    private String Branch_Name;
    private String Address;
    private String Gender;
    public static Scanner scan;
    private double balance;
    public static final long serialVersionUID = 42L;  
    public ArrayList<Transactions> t;
    public Customer() {
        t = new ArrayList<Transactions>();
    }

    public void setAddress(String Address) {
        boolean f = true;
        f = isOnlyAlphabet(Address);
        if(f==true)
        {
        this.Address = Address;
        }
        else
        {
          System.out.println("enter valid Address !");
        }   
    }

    public String GetAddress() {
        return this.Address;
    }
    public void setGender(String sex) {

        this.Gender = sex ;
    }
    public String getGender() {
        return Gender;
    }

    public void setCname(String name) {
        boolean f = true;
        f = isOnlyAlphabet(name);
        if(f==true)
        {
        this.CName = name;
        }
        else
        {
          System.out.println("enter valid name !");
        }
    }
    public void setBranch(String Branch_Name)
    {
        this.Branch_Name=Branch_Name;
    }

    
    public String GetBranch_Name() {
        return Branch_Name;
    }

    public String getname() {
        return CName;
    }

    public double GetAccount() {
        return account_id;
    }

    public void setAccount(double account_id) {
        this.account_id = account_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getbalance() {
        return balance;
    }

    public void Show() {
        System.out.println("**********------------**************");
        System.out.println("Name of the customer :" + this.getname());
        System.out.println("Branch name is :" + this.GetBranch_Name());
        System.out.println("address is " + this.GetAddress());
        System.out.println("gender :" + this.getGender());
        System.out.println("account number is " + this.GetAccount());
        System.out.println("current balance is" + this.getbalance());
        System.out.println("**********----------**************");
    }
    public void showtransaction() {
        System.out.println("The following are the transactions");
        System.out.println("From \t To \t Amount \t Transaction_Type");
        for (int i = 0; i < this.t.size(); i++)
        {
            this.t.get(i).show();
        }
    }
    public  boolean isOnlyAlphabet(String str) 
    { 
        return ((!str.equals("")) 
                && (str != null) 
                && (str.matches("^[a-zA-Z]*$"))); 
    }
}