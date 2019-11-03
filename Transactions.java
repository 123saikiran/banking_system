import java.util.*;
import java.sql.Timestamp;
import java.io.*;

class Transactions implements Serializable{
  private double from;
  private String transactions_type;
  private double to;
  // Timestamp ts;
  double Amount_Value;
  public static final long serialVersionUID = 10l;     
  public Transactions(String transactions_type) {
    this.transactions_type = transactions_type;
    // Date date= new Date();
    // long time = date. getTime();
    // this.ts = new Timestamp(time);
  }

  public void setTransaction(String transactions_type) {
    this.transactions_type = transactions_type;
  }

  public String getTransactions_type() {
    return transactions_type;
  }

  public void setFrom(double from) {
    this.from = from;
  }

  public double getFrom() {
    return this.from;
  }

  public void setTo(double to) {
    this.to = to;
  }

  public double getTo() {
    return this.to;
  }

  public void setAmount(double Amount_Value) {
    this.Amount_Value = Amount_Value;
  }

  public double getAmount() {
    return this.Amount_Value;
  }

  public void show() {
    System.out
        .println(this.getFrom() + "\t" + this.getTo() + "\t" + this.getAmount() + "\t" + this.getTransactions_type());
  }
}