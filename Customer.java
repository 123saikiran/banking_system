import java.io.*;
import java.lang.*;
import java.util.*;
public class Customer implements Serializable
{
    public String CName;
    public  double account_id;
    public static double Id=10245;
    public  String Branch_Name;
    public  String Address;
    public String Gender;
    public int age;
    double balance;
    Transactions transaction;
    ArrayList<Transactions> t;
    public Customer(String Cname , String Address, int age ,String Branch_Name, String Gender,double balance)
   {
     this.CName=Cname;
     this.Branch_Name = Branch_Name;
     this.Address = Address;
     this.age=age;
     this.Gender=Gender;
     this.account_id=Id++;
     this.balance=balance;
     t = new ArrayList<Transactions>();
     
   }
   public Customer()
   {
    
   }
   public int getAge()
    {
      return age;
    }
    public String getGender() 
    {
      return Gender;
    }
     public void setCname(String name)
     {
         this.CName = name;
     } 
     public String GetBranch_Name()
     {
       return Branch_Name;
     } 
     public String getname()
     {
       return CName;
     }
     public double  GetAccount()
     {
       return account_id;
     }    
     public void setAccount(double account_id)
     {
       this.account_id=account_id;
     }   
     public void setBalance(double balance )
     {
       this.balance=balance;
     }
     public double  getbalance()
     {
       return balance;
     }
     public  void Show()
     {
       System.out.println("**********------------**************");
       System.out.println("Name of the customer :"+CName);
       System.out.println("Branch name is :"+Branch_Name);
       System.out.println("age is "+age);
       System.out.println("address is "+Address);
       System.out.println("gender :"+Gender);
       System.out.println("account number is "+account_id);
       System.out.println("current balance is"+balance);
       System.out.println("**********----------**************");
     }
     
  public void makeTransaction(double account1, double account2,double amount)
  {
      Transactions t1 = new Transactions();
      //Transactions t2 = new Transactions();
      t1.transfer(account1,account2,amount);
      t.add(t1);
      //t.add(t2);
  }
  public void debit(double amount,double account_id)
  {
    Transactions t1 = new Transactions();
    t1.debit(amount,account_id);
    t.add(t1);
  }
  public void credit(double  amount,double account_id)
  {
    Transactions t1 = new Transactions();
    t1.credit(amount,account_id);
    t.add(t1);
  }
  
}