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
     t = new ArrayList<Transactions>();
     Transactions t1=new Transactions(balance);
     t.add(t1);
   }
   public Customer()
   {
      t = new ArrayList<Transactions>();
      this.account_id=Id++;
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
       transaction=new Transactions();
        transaction.setbalance(balance);
        t.add(transaction);
     }
     public void showBalance()
     {
       transaction = new Transactions();

       System.out.println(t.get(0)
       .Getbalance());
     }
     public  void Show()
     {
       System.out.println();
       System.out.println("Name of the customer :"+CName);
       System.out.println("Branch name is :"+Branch_Name);
       System.out.println("age is "+age);
       System.out.println("address is "+Address);
       System.out.println("gender :"+Gender);
       System.out.println("account number is "+account_id);
     }
  public void makeTransaction(String from, String to)
  {
      Transactions t1 = new Transactions(from, to);
      Transactions t2 = new Transactions(from, to); 
      t.add(t1);
      t.add(t2);
  }
  public void debit(double amount)
  {
    Transactions t1 = new Transactions();
    t1.debit(amount);
    t.add(t1);
  }
  public void credit(double  amount)
  {
    Transactions t1 = new Transactions();
    t1.credit(amount);
    t.add(t1);
  }
  
}