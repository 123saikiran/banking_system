import BANKING_SYSTEM;
import java.util.*;
public class Bank
{
  static ArrayList<Customer> customers;
  static ArrayList<Account> accounts;
  static Scanner sc;
    public static void  showAccounts()
    {
      for(int i=0;i<accounts.size();i++)
      {
        accounts.get(i).show();
      }
    }

    public void addAccount()
    {
      System.out.println("enter customer Name:");
      String name = sc.nextLine();
      System.out.println("enter address of the customer :");
      String address=sc.nextLine();
      System.out.println("enter the age of the customer:");
      int age = sc.nextInt();
      System.out.println("enter the branch name:");
      String branch=sc.nextLine();
      
    }
    
}