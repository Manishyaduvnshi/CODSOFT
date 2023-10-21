import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposited $" + amount + ". New balance: $" + balance;
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return "Withdrew $" + amount + ". New balance: $" + balance;
        } else {
            return "Insufficient funds or invalid withdrawal amount.";
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public void createAccount(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
        System.out.println("Account created.");
    }

    public String deposit(double amount) {
        if (userAccount != null) {
            return userAccount.deposit(amount);
        } else {
            return "Please create an account first.";
        }
    }

    public String withdraw(double amount) {
        if (userAccount != null) {
            return userAccount.withdraw(amount);
        } else {
            return "Please create an account first.";
        }
    }

    public String checkBalance() {
        if (userAccount != null) {
            return "Current balance: $" + userAccount.getBalance();
        } else {
            return "Please create an account first.";
        }
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    atm.createAccount(initialBalance);
                    break;

                case "2":
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println(atm.deposit(depositAmount));
                    break;

                case "3":
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println(atm.withdraw(withdrawAmount));
                    break;

                case "4":
                    System.out.println(atm.checkBalance());
                    break;

                case "5":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
