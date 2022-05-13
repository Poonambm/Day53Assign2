public class BankAccount {
    private String name;
    private Double balance;
    private Integer accountNumber;

    public BankAccount(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(String name, Double balance, Integer accountNumber) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

   
    public String toString() {
        return "Name of the bank account is : " + getName() + " and account number is :" + getAccountNumber()
                + " and they have a balance of $" + getBalance();
    }
}