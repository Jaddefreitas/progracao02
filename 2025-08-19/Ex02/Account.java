package Ex02;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
        if (initialBalance < 0) {
            throw new RuntimeException("Initial balance cannot be less than zero.");
        }

        if (withdrawLimit < 0) {
            throw new RuntimeException("Withdraw limit cannot be less than zero.");
        }

        this.number = number;
        this.holder = holder;
        this.balance = initialBalance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        if (amount < 0) {
            throw new RuntimeException("Deposit error: Deposit amount cannot be less than zero.");
        }

        this.balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount < 0) {
            throw new RuntimeException("Withdraw error: Withdraw amount cannot be less than zero.");
        }

        if (amount > this.withdrawLimit) {
            throw new RuntimeException("Withdraw error: The amount exceeds withdraw limit");
        }

        if (amount > this.balance) {
            throw new RuntimeException("Withdraw error: No enough balance");
        }

        this.balance -= amount;
    }
}
