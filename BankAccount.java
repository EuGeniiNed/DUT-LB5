public class BankAccount {
    private int accountNumber;
    private String accountName;
    private float balance;

    public BankAccount(int accountNumber,String accountName,float initialBalance) {
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.balance=initialBalance;
    }

    public void deposit(float amount) throws NegativeAmountException {
        if (amount<0){
            throw new NegativeAmountException("Сума не може бути відъємною.");}
        balance+=amount;
    }

    public void withdraw(float amount) throws InsufficientFundsException,NegativeAmountException {
        if(amount<0){
            throw new NegativeAmountException("Сума не може бути відъємною.");
        }
        if (balance<amount) {
            throw new InsufficientFundsException("На рахунку недостатньо коштів.") ;
        }
        balance-=amount;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountSummary(){
        return "Account Number: "+accountNumber+"\n"+
                "Account Name: " + accountName+"\n"+
                "Balance: "+balance;
    }
}