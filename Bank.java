import java.util.HashMap;

public class Bank {
    private HashMap<Integer, BankAccount>accounts;

    public Bank() {
        accounts=new HashMap<>();
    }

    public void createAccount(String accountName,float initialDeposit) {
        int accountNumber =accounts.size() +1 ;
        BankAccount newAccount=new BankAccount(accountNumber,accountName,initialDeposit);
        accounts.put(accountNumber,newAccount);
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Рахунок не знайдено.");
        }
        return accounts.get(accountNumber) ;
    }

    public void transferMoney(int fromAccountNumber,int toAccountNumber,float amount) throws InsufficientFundsException,AccountNotFoundException, NegativeAmountException {

        BankAccount fromAccount=findAccount(fromAccountNumber);
        BankAccount toAccount=findAccount(toAccountNumber) ;

        fromAccount.withdraw(amount);
        toAccount.deposit(amount) ;
    }
}