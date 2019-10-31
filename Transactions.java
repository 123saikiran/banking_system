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
    public boolean canDebit(double Amount_Value)
    {
      return (Amount_Value<=customer.balance);
    }
    public void  debit(double Amount_Value)
     {
       if(canDebit(Amount_Value))
       {
         System.out.println("Current balance is Rs"+customer.balance);       
         customer.balance -= Amount_Value;
         customer.updatedebitBalance(Amount_Value);
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
  
  public  void credit(double anAmount)
   {
     System.out.println("current balance is Rs " +customer.balance);
     balance += anAmount;
     Date date= new Date();
     long time = date. getTime();
     Timestamp ts = new Timestamp(time);
     customer.updatecreditBalance(anAmount);
     System.out.println("an amount "+ anAmount+"has been credited at"+ts);
     System.out.println("current balance after the transaction is Rs"+ customer.balance);
    }

}