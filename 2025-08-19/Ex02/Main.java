package Ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Enter account data");
            System.out.print("Number: ");
            String account_number = scanner.nextLine();
            System.out.print("Holder: ");
            String account_holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            String account_initial_balance = scanner.nextLine();
            System.out.print("Withdraw limit: ");
            String account_withdraw_limit = scanner.nextLine();

            Account account = new Account(Integer.parseInt(account_number), account_holder, Double.parseDouble(account_initial_balance), Double.parseDouble(account_withdraw_limit));

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            String withdraw_amount = scanner.nextLine();

            account.withdraw(Double.parseDouble(withdraw_amount));

            System.out.println("New balance: " + account.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            scanner.close();
            return;
        }

        scanner.close();
    }
}
