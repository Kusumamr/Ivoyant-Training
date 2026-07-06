import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.util.Scanner;

class InSufficientFundsException extends Exception{
    InSufficientFundsException(String message){
        super(message);
    }
}
class InValidAmountException extends Exception{
    InValidAmountException(String message){
        super(message);
    }
}
class AccountFrozenException extends Exception{
    AccountFrozenException(String message){
        super(message);
    }
}
class BankAccount{
    double balance;
    boolean frozen;

    BankAccount(double balance,boolean frozen){
        this.balance=balance;
        this.frozen=frozen;
    }

    public void withdraw(double amount)
    throws InSufficientFundsException,InValidAmountException,AccountFrozenException
    {
        if(frozen){
            throw new AccountFrozenException("Account is Frozen");
        }
        if(amount<0){
            throw new InValidAmountException("Invalid Amount");
        }
        if(amount>balance){
            throw new InSufficientFundsException("InSufficient Balance");
        }
        balance-=amount;
        System.out.println("Withdraw successfull");
        System.out.println("Remanining balance is " + balance);

        try(FileWriter fw=new FileWriter("transaction.txt")){
            fw.write("Withdraw amount is " + amount + "Remaining balance is " + balance);
        }catch (IOException e){
            System.out.println("File error " + e.getMessage());
        }
    }

}
public class Day11_ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();

        System.out.print("Is Account Frozen? (true/false) : ");
        boolean frozen = sc.nextBoolean();

        BankAccount account = new BankAccount(balance, frozen);

        System.out.print("Enter Withdrawal Amount : ");
        double amount = sc.nextDouble();

        try {

            account.withdraw(amount);

        }
        catch (AccountFrozenException | InSufficientFundsException | InValidAmountException e) {

            System.out.println(e.getMessage());

        }
        finally {

            System.out.println("Thank You.");

        }

    }
}
