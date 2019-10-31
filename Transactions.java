import java.util.*;
import java.sql.Timestamp;
class Transactions
{  
    String from;
    Customer customer;
    String to;
    String TimeStamp;
    double Amount_Value;
  public Transactions(String from,String to)
   {
     this.from=from;
     this.to=to;
   }
   public  Transactions()
   {
     
   }
        public void  debit(double Amount_Value,double account_no)
     {
       int y=0;
      for(int i=0;i<Bank.customers.size();i++)
      {
        if(account_no==Bank.customers.get(i).GetAccount())
        {
          y=i;
        }
      }
        Customer customer=new Customer();
       customer=Bank.customers.get(y);

       if(Amount_Value<=customer.getbalance())
       {
         System.out.println("Current balance is Rs"+customer.getbalance());       
         customer.balance -= Amount_Value;
         System.out.println("Current balance after the transaction is Rs"+ customer.balance);
         Date date= new Date();
         long time = date. getTime();
         Timestamp ts = new Timestamp(time);
         System.out.println("Amount debited at "+ts+"from account number"+customer.GetAccount());
        }
       else
        {
         System.out.println("Account number " +" has insufficient amounts to debit" +Amount_Value);
        } 
    }
  
  public  void credit(double anAmount,double account_no)
   {
      int y=0;
      for(int i=0;i<Bank.customers.size();i++)
      {
        if(account_no==Bank.customers.get(i).GetAccount())
        {
          y=i;
        }
      }
        Customer customer=new Customer();
       customer=Bank.customers.get(y);

      
     System.out.println("current balance is Rs " +customer.balance);
     customer.balance += anAmount;
     Date date= new Date();
     long time = date. getTime();
     Timestamp ts = new Timestamp(time);
     System.out.println("an amount "+ anAmount+"has been credited at"+ts);
     System.out.println("current balance after the transaction is Rs"+ customer.balance);
    }

}