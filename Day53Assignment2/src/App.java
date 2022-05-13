import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<BankAccount> BankAccounts = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Hello World! Welcome to the Bank of Matt!");
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (2 == Integer.parseInt(answer)) {
                System.out.println("Let's make a new account!");
                System.out.println("What is the name for the account?");
                String name = scanner.nextLine();

                System.out.println("What is the begining balance for the account?");
                String beginBalance = scanner.nextLine();

                System.out.println("Enter your account number");
                String accountNumber = scanner.nextLine();

                BankAccounts
                        .add(new BankAccount(name, Double.parseDouble(beginBalance), Integer.parseInt(accountNumber)));
            } else if (-1 == Integer.parseInt(answer)) {
                System.exit(0);
            } else if (1 == Integer.parseInt(answer)) {
                System.out.println("Enter your bank account number : ");
                String accountNumber = scanner.nextLine();
                BankAccount BankAccount = getBankAccount(Integer.parseInt(accountNumber));
                while (true) {
                    mainMenu(BankAccount);
                }

            }
        }
    }

    private static void mainMenu(BankAccount BankAccount) {

        System.out.println("Hello " + BankAccount.getName());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        System.out.println("1. To check account balance");
        System.out.println("2. To make a withdraw");
        System.out.println("3. To make a deposit");
        System.out.println("4. To make a transfer to an another account");
        System.out.println("0. To exit");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Your account balance is : " + BankAccount.getBalance());
        } else if (userInput.equals("2")) {
            System.out.println("Enter amount to withdraw : ");
            String amount = scanner.nextLine();
            Double remainingBalance = withdraw(Double.parseDouble(amount), BankAccount.getBalance());
            BankAccount.setBalance(remainingBalance);
        } else if (userInput.equals("3")) {
            System.out.println("Enter amount to deposit : ");
            String amount = scanner.nextLine();
            Double finalBalance = deposit(Double.parseDouble(amount), BankAccount.getBalance());
            BankAccount.setBalance(finalBalance);
        } else if (userInput.equals("4")) {
            System.out.println("Please enter the account number to transfer to ");
            String accountNumber = scanner.nextLine();
            BankAccount toBankAccount = getBankAccount(Integer.parseInt(accountNumber));
            System.out.println("Please enter amount to transfer");
            String amount = scanner.nextLine();
            transfer(toBankAccount, Double.parseDouble(amount));
            BankAccount.setBalance(withdraw(Double.parseDouble(amount), BankAccount.getBalance()));
        } else if (userInput.equals("0")) {
            System.exit(0);
        }

    }

    private static BankAccount transfer(BankAccount BankAccount, double transferAmount) {
        double balance = deposit(transferAmount, BankAccount.getBalance());
        BankAccount.setBalance(balance);
        return BankAccount;
    }

    private static BankAccount getBankAccount(int BankAccountNumber) {
        BankAccount BankAccount = null;
        for (BankAccount BankAccount1 : BankAccounts) {
            if (BankAccount1.getAccountNumber() == BankAccountNumber) {
                BankAccount = BankAccount1;
                break;
            }
        }
        return BankAccount;
    }

    private static double deposit(Double newAmount, Double balance) {
        return newAmount + balance;
    }

    private static double withdraw(Double newAmount, Double balance) {
        return balance - newAmount;
    }

}
