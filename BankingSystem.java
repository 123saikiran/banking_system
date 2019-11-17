import java.util.*;
import java.io.*;

public class BankingSystem {
    public static void main(String args[]) {
        Bank b = new Bank();
        Scanner scan = new Scanner(System.in);
        try {
            FileInputStream filestream = new FileInputStream("filename.txt");
            ObjectInputStream os = new ObjectInputStream(filestream);
            b = (Bank) os.readObject();
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        int y=0;
        do {
            System.out.println("enter 1:to create account!!!");
            System.out.println("enter 2:to view all account details:");
            System.out.println("enter 3: to view transaction details:!!");
            System.out.println("enter 4: to credit an amount in your account!!! ");
            System.out.println("enter 5:to ]debit an amount from your bank!!!");
            System.out.println("enter 6:to make a transfer of money!!!");
            System.out.println("enter 7:to view particular account details!!!");
            System.out.println("enter 8:to delete account ");
            System.out.println("enter 9:to delete account as index ");
            System.out.println("enter 0:to exit ");
            try{
            y = scan.nextInt();
            }
            catch(InputMismatchException ex)
            {
                System.out.println("exception occured!");
            }
            switch (y) {
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
                b.transfer();
                break;
            case 7:
                b.viewAccount();
                break;
            case 8:
                b.RemoveAccount();
                break;
            case 9:
               b.deleteAccount();
               break;

            case 0:
                System.out.println("\n");
                System.out.println("********program ended********");
                try {
                    FileOutputStream f = new FileOutputStream("filename.txt");
                    ObjectOutputStream os = new ObjectOutputStream(f);
                    os.writeObject(b);
                    os.close();
                    System.out.println("visited");
                } catch (IOException ex) {
                    System.out.println("exception caught");
                    ex.printStackTrace();
                }
                System.exit(0);
                break;
            default:
                System.out.println("invalid input!!!!");
                break;  
            }

        } while (y != 0);
        scan.close();
    }

}