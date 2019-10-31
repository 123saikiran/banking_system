import java.util.ArrayList;
import java.util.Scanner;
public class Bank
{
  static ArrayList<Customer> customers;
  static ArrayList<Transactions> t;
  static Scanner sc;
    public int  searchbyID(double account_id)
    {
      for(int i=0;i<customers.size();i++)
      {
        if(account_id==customers.get(i).GetAccount())
         return i;
      }
        return -1;
    }
    public void Debit()
    {
      System.out.println("enter the account id:");
      double id = sc.nextDouble();
      int index=searchbyID(id); 
      if(index==-1)
      {
        System.out.println("account not found!!!");
        return;
      }
       System.out.println("enter the amount to withdraw!!!!");
       double amount = sc.nextDouble();
       customers.get(index).debit(amount);
        System.out.println("operation successfull !!!@@===");
      
    }
    public void credit()
    {
      System.out.println("enter the account number??");
      double id=sc.nextDouble();
      int index=searchbyID(id);
      if(index==-1)
      {
        System.out.println("account not found !!!!!");
        return;
      }
      System.out.println("enter the amount to credit!!!!");
      double amount = sc.nextDouble();
      customers.get(index).credit(amount);
      
        System.out.println("amount successfully credited !!!@@===");
      
    }
    public void showAccounts()
    {
      for(int i=0;i<customers.size();i++)
       {
         customers.get(i).Show();
       }
    }
    
    public  void addAccount()
    {
      sc.nextLine();
      System.out.println("enter customer Name:");
      String name = sc.nextLine();
      System.out.println("enter address of the customer :");
      String address=sc.nextLine();
      System.out.println("enter the age of the customer:");
      int age = sc.nextInt();
      sc.nextLine();
      System.out.println("enter the branch name:");
      String branch=sc.nextLine();
      sc.nextLine();
      System.out.println("enter gender:");
      String gender=sc.nextLine();
       System.out.println("enter the balance");
       double balance=sc.nextDouble();
       Customer newcustomer = new Customer(name,address,age,branch,gender,balance);
       System.out.println("enter the account number?");
       double account_id=sc.nextDouble();
       newcustomer.setAccount(account_id);
        customers.add(newcustomer);
        System.out.println("account created:::!!!!");
    }
    public void showTransactions()
    {
      for(int i=0;i<t.size();i++)
      {
      
      }
    }
    public void makeTransactions()
    {

    }


     public static void main(String args[])
     {
       Bank b = new Bank();
      customers = new ArrayList<Customer>();
      t = new ArrayList<Transactions>();
       sc=new Scanner(System.in);
        
        int y;
        do 
        {
          System.out.println("enter 1:to create account!!!");
        System.out.println("enter 2:to view account details:");
        System.out.println("enter 3: to view transaction details:!!");
        System.out.println("enter 4: to credit an amount in your account!!! ");
        System.out.println("enter 5:to ]debit an amount from your bank!!!");
        System.out.println("enter 6:to make a transfer of money!!!");
        System.out.println("enter 0:to exit ");
           y = sc.nextInt();
          switch(y)
          {
            case 1:
            b.addAccount();
            break;
            case 2:
            b.showAccounts();
            break;
            case 3:
            b.showTransactions();
            break;
            case 4:
            b.credit();
            break;
            case 5:
            b.Debit();
            break;
            case 6:
            b.makeTransactions();
            break;
            
            case 0:
            System.out.println("\n");
            System.out.println("********program ended********");
            System.exit(0);
            break;
            default:
            System.out.println("invalid input!!!!");
            System.out.println("enter 7 to display menu :");
            

          }
          
          
        }while(y!=0);
        sc.close();
       
     } 
    }