import java.util.*;
import java.io.*;

public class Bank implements Serializable{
  public ArrayList<Customer> customers;
  public ArrayList<Branch> branches;  
  public static final long serialVersionUID = 42L;  
  static Scanner sc ;
    public Bank(){
        customers = new ArrayList<Customer>();
    }
  public int searchbyID(double account_id) {
    for (int i = 0; i < customers.size(); i++) {
      if (account_id == customers.get(i).GetAccount())
        return i;
    }
    return -1;
  }
 public int  checkLength(double account )
 {
   int count = 0;
    while(account!=0)
    {
      account=account/10.0;
      count++;
    }
    return count;
 }

  public void Debit() {
    System.out.println("enter the account number!!!");
    sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    System.out.println("enter the amount to debit");
    double amount = sc.nextDouble();
    Customer c1 = new Customer();
    boolean flag1 = false;
    for (int i = 0; i < customers.size(); i++) {
      if (account1 == customers.get(i).GetAccount()) {
        c1 = customers.get(i);
        flag1 = true;
      }
    }
    if (flag1 == true) {
      if (amount <= c1.getbalance()) {
        Transactions t1 = new Transactions("debit");
        t1.setFrom(account1);
        t1.setAmount(amount);
        c1.setBalance(c1.getbalance() - amount);
        c1.t.add(t1);
      } 
      else if (amount > c1.getbalance()) {
        System.out.println("insufficient amount to withdraw:");
      }
    } 
    else 
    {
      System.out.println("account number invalid!!!");
    }
  }

  public void credit() {
   sc = new Scanner(System.in);
    System.out.println("enter account number!!!!");
    double account1 = sc.nextDouble();
    System.out.println("enter the amount to credit");
    double amount = sc.nextDouble();
    Customer c1 = new Customer();
    boolean flag1 = false;
    for (int i = 0; i < customers.size(); i++) {
      if (account1 == customers.get(i).GetAccount()) {
        c1 = customers.get(i);
        flag1 = true;
      }
    }
    if (flag1 == true) {
      Transactions t1 = new Transactions("credit");
      t1.setFrom(account1);
      t1.setAmount(amount);
      c1.setBalance(c1.getbalance() + amount);
      c1.t.add(t1);
    } else {
      System.out.println("account number invalid!!!!");
    }
  }

  public void showAccounts() {
    for (int i = 0; i < customers.size(); i++) {
      customers.get(i).Show();
    }
  }
  public void viewAccount()
  {
    System.out.println("enter account number ");
    sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
    customers.get(y).Show();
  }

  public void addAccount() {
    Customer newcustomer = new Customer();
    boolean ft=false;
    while(ft!=true)
    {
    System.out.println("enter customer Name:");
    sc = new Scanner(System.in);
    String name = sc.nextLine();
    ft = isAlphabet(name);
    newcustomer.setCname(name);
    }
    boolean rt=false;
    while(rt!=true)
    {
    System.out.println("enter address of the customer :");
    String address = sc.nextLine();
    rt=isAlphabet(address);
    newcustomer.setAddress(address);
    }
    boolean rs=false;
      while(rs!=true)
      {
        System.out.println("enter the branch name:");
        String branch = sc.nextLine();
        rs=isAlphabet(branch);
        newcustomer.setBranch(branch);
      }
    int age =0;
      try {
        System.out.println("enter the age of the customer:");
          age = sc.nextInt();
      } 
      catch (InputMismatchException e)
      {
        System.out.println("enter valid age(in integer)");
        System.exit(0);
      }
      newcustomer.setAge(age);
      double balance=0;
     try
     {
     System.out.println("enter the balance");
     balance = sc.nextDouble();
     }
     catch(InputMismatchException exception)
     {
      System.out.println(exception);
      System.out.println("enter valid value nextTime");
      //System.exit(0);
     }
     newcustomer.setBalance(balance);
     sc.nextLine();
     System.out.println("enter the gender!!!");
     String gender = sc.nextLine();
     newcustomer.setGender(gender);
     double account_id=0;
     try
     {
     System.out.println("enter the account number?");
     account_id = sc.nextDouble();
     }
     catch(InputMismatchException e)
     {
      System.out.println("please re enter valid input");
      //System.exit(0);
     }
     boolean f = Account(account_id);
     if(f==true)
     {
      newcustomer.setAccount(account_id);
      customers.add(newcustomer);
      System.out.println("account created!!");
     }
     else
     {
      System.out.println("enter valid account number!");
     }


  }

  public void showTransactions() {
    System.out.println("enter account number@");
    sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
   customers.get(y).showtransaction();
  }

  public void transfer() {
   sc = new Scanner(System.in);
    System.out.println("enter sender account no!");
    double account1 = sc.nextDouble();
    System.out.println("enter reciever account no!");
    double account2 = sc.nextDouble();
    System.out.println("enter the amount to transfer");
    double amount = sc.nextDouble();
    Customer c1 = new Customer();
    Customer c2 = new Customer();
    boolean flag1 = false, flag2 = false;
    for (int i = 0; i < customers.size(); i++) {
      if (account1 == customers.get(i).GetAccount()) {
        c1 = customers.get(i);
        flag1 = true;
      }
      if (account2 == customers.get(i).GetAccount()) {
        c2 = customers.get(i);
        flag2 = true;

      }
    }
    if (flag1 && flag2) 
    {
      Transactions t1 = new Transactions("transfer");
      t1.setFrom(account1);
      t1.setTo(account2);
      t1.setAmount(amount);
      if(amount<=c1.getbalance())
      {
      c1.setBalance(c1.getbalance() - amount);
      c1.t.add(t1);
      Transactions t2 = new Transactions("transfer");
      t2.setFrom(account2);
      t2.setTo(account1);
      t2.setAmount(amount);
      c2.setBalance(c2.getbalance() + amount);
      c2.t.add(t2);
      }
      else
      {
        System.out.println("you have insufficient balance.");
      }

    }
  }
  public void RemoveAccount()
  {
    System.out.println("enter account number");
    sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
    customers.remove(y);
    System.out.println("*****account removed succesfully!!!******");
  } 
  public boolean Account(double account)
  {
    int i=searchbyID(account);
    int c = checkLength(account);
    if(c>5 && i==-1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
public void  deleteAccount()
{
  boolean f = false;
  System.out.println("enter index!");
  sc = new  Scanner(System.in);
  try{
  int i = sc.nextInt();
  customers.remove(i);
  }
  catch(Exception e)
  {
    System.out.println("exception occured!!");
    f = true;
  }
  if(f==false)
  {
  System.out.println("account removed succesfully");
  }
 } 
 public  boolean isAlphabet(String str) 
    { 
        return ((!str.equals("")) 
                && (str != null) 
                && (str.matches("^[a-zA-Z]*$"))); 
    }
}