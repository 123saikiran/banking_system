import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bank implements Serializable{
  public ArrayList<Customer> customers;
  public static final long serialVersionUID = 10l;  
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

  public void Debit() {
    System.out.println("enter the account number!!!");
    Scanner sc = new Scanner(System.in);
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
      } else if (amount > c1.getbalance()) {
        System.out.println("insufficient amount to withdraw:");
      }
    } else {
      System.out.println("account number invalid!!!");
    }
    sc.close();
  }

  public void credit() {
    Scanner sc = new Scanner(System.in);
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
    sc.close();
  }

  public void showAccounts() {
    for (int i = 0; i < customers.size(); i++) {
      customers.get(i).Show();
    }
  }
  public void viewAccount()
  {
    System.out.println("enter account number ");
    Scanner sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
    customers.get(y).Show();
    sc.close();
  }

  public void addAccount() {
    System.out.println("enter customer Name:");
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    System.out.println("enter address of the customer :");
    String address = sc.nextLine();
    System.out.println("enter the age of the customer:");
    int age = sc.nextInt();
    sc.nextLine();
    System.out.println("enter the branch name:");
    String branch = sc.nextLine();
    sc.nextLine();
    System.out.println("enter gender:");
    String gender = sc.nextLine();
    System.out.println("enter the balance");
    double balance = sc.nextDouble();
    Customer newcustomer = new Customer(name, address, age, branch, gender, balance);
    System.out.println("enter the account number?");
    double account_id = sc.nextDouble();
    newcustomer.setAccount(account_id);
    customers.add(newcustomer);
    System.out.println("account created:::!!!!");
    sc.close();
  }

  public void showTransactions() {
    System.out.println("enter account number@");
    Scanner sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
   customers.get(y).showtransaction();
   sc.close();
  }

  public void transfer() {
    Scanner sc = new Scanner(System.in);
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
    if (flag1 && flag2) {
      Transactions t1 = new Transactions("transfer");
      t1.setFrom(account1);
      t1.setTo(account2);
      t1.setAmount(amount);
      c1.setBalance(c1.getbalance() - amount);
      c1.t.add(t1);
      Transactions t2 = new Transactions("transfer");
      t2.setFrom(account2);
      t2.setTo(account1);
      t2.setAmount(amount);
      c2.setBalance(c2.getbalance() + amount);
      c2.t.add(t2);

    }
    sc.close();
  }
  public void RemoveAccount()
  {
    System.out.println("enter account number");
    Scanner sc = new Scanner(System.in);
    double account1 = sc.nextDouble();
    int y = searchbyID(account1);
    customers.remove(y);
    sc.close();
  } 

 }