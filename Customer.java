import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.*;
public class Customer implements Serializable {
    private String CName;
    private double account_id;
    private String Branch_Name;
    private String Address;
    private String Gender;
    private int age;
    private double balance;
    public static final long serialVersionUID = 10l;  
    public ArrayList<Transactions> t;

    public Customer(String Cname, String Address, int age, String Branch_Name, String Gender, double balance) {
        this.CName = Cname;
        this.Branch_Name = Branch_Name;
        this.Address = Address;
        this.age = age;
        this.Gender = Gender;
        this.balance = balance;
        t = new ArrayList<Transactions>();

    }

    public Customer() {
        t = new ArrayList<Transactions>();
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String GetAddress() {
        return this.Address;
    }

    public int getAge() {
        return age;
    }

    public void setGender() {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        while (flag) {
            String sex = scan.next();
            if (sex == "male" || sex == "female") {
                flag = false;
                switch (sex) {
                case "male":
                    this.Gender = "male";
                    break;
                case "female":
                    this.Gender = "female";
                    break;
                }
            }
        }
        scan.close();
    }

    public String getGender() {
        return Gender;
    }

    public void setCname(String name) {
        this.CName = name;
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
        System.out.println("age is " + this.getAge());
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
}