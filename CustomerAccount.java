//////////////////////////////////
///SOLUTION TO PROBLEM #2 ////////
//////////////////////////////////

public class CustomerAccount {

    private String cusName;
    private int accountNum;
    private double balance;

    public CustomerAccount(String cusName, int accountNum, double balance){
        this.accountNum =accountNum;
        this.balance=balance;
        this.cusName=cusName;
    }
    public boolean deposit (double amount){
        if (amount < 0){
            return false;
        }
        balance+=amount;
        return true;
    }

    public boolean withdraw(double amount) throws InsufficientWithdrowBalanceException, LowerHundredBucksException {
        if (amount > balance){
            throw new InsufficientWithdrowBalanceException("No enough balance to withdrew amount: " + amount);
        }
        if (balance - amount <100){
            throw new LowerHundredBucksException("Balance will reach lower than 100$ if " + amount + " will be withdrawn ");
        }
        balance-=amount;
        return true;
    }

    public double getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        CustomerAccount c = new CustomerAccount("Omar", 23086402, 102);
        try{
            c.deposit(500);
            c.withdraw(1000);
            c.withdraw(509);
        } catch (InsufficientWithdrowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
            try{
                c.withdraw(509);
            } catch (InsufficientWithdrowBalanceException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (LowerHundredBucksException ex) {
                System.out.println("Warning: " + ex.getMessage());
            }
        } catch (LowerHundredBucksException e) {
            System.out.println("Warning: " + e.getMessage());
        }

    }

}

class InsufficientWithdrowBalanceException extends Exception {
    public InsufficientWithdrowBalanceException(String message) {
        super(message);
    }
}

class LowerHundredBucksException extends Exception {
    public LowerHundredBucksException(String message) {
        super(message);
    }
}
