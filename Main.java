// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Bank bank=new Bank();

        bank.createAccount("Eugene",1000);
        bank.createAccount("Roman Fairushyn",2000);

        try {
            bank.findAccount(1).deposit(500);
            System.out.println("Депозит здійснено. Баланс Eugene: "+bank.findAccount(1).getBalance());

            bank.findAccount(1).withdraw(300);
            System.out.println("Зняття успішно. Баланс Eugene: " +bank.findAccount(1).getBalance());

            bank.transferMoney(1, 2, 200);
            System.out.println("Переказ успішно. Баланс Eugene: "+bank.findAccount(1).getBalance());
            System.out.println("Баланс Roman: " +bank.findAccount(2).getBalance());

            bank.findAccount(1).withdraw(5000);
        } catch (InsufficientFundsException | NegativeAmountException | AccountNotFoundException e) {
            System.err.println("Помилка: " +e.getMessage());
        }

        try {
            bank.findAccount(1).deposit(-100);
        } catch (NegativeAmountException e){
            System.err.println("Помилка: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);}

        try {
            bank.transferMoney(1, 99, 100);
        } catch (AccountNotFoundException e){
            System.err.println("Помилка: " +e.getMessage());
        } catch (NegativeAmountException e) {
            throw new RuntimeException(e);
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);}
}
class NegativeAmountException extends Exception {
    public NegativeAmountException(String message){
        super(message);}
}
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}