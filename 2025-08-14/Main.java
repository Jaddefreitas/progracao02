import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TaxPayer {
    private final String name;
    private final Double annualIncome;

    protected TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() { return name; }
    public Double getAnnualIncome() { return annualIncome; }
    public abstract double calculateTax();
}

class Individual extends TaxPayer {
    private final Double healthExpenses;

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double calculateTax() {
        double taxRate = getAnnualIncome() < 20000.0 ? 0.15 : 0.25;
        double tax = getAnnualIncome() * taxRate;
        tax -= healthExpenses * 0.5;
        return Math.max(tax, 0.0);
    }
}

class Company extends TaxPayer {
    private final int numberOfEmployees;

    public Company(String name, Double annualIncome, int numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTax() {
        double taxRate = numberOfEmployees > 10 ? 0.14 : 0.16;
        return getAnnualIncome() * taxRate;
    }
}

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        List<TaxPayer> taxpayers = new ArrayList<>();
        int numberOfTaxPayers = getNumberOfTaxPayers();
        
        for (int i = 1; i <= numberOfTaxPayers; i++) {
            taxpayers.add(createTaxPayer(i));
        }

        printTaxes(taxpayers);
        sc.close();
    }

    private static int getNumberOfTaxPayers() {
        System.out.print("Enter the number of tax payers: ");
        return sc.nextInt();
    }

    private static TaxPayer createTaxPayer(int index) {
        System.out.println("\nTax payer #" + index + " data:");
        
        char type = getTaxPayerType();
        String name = getName();
        Double annualIncome = getAnnualIncome();

        if (type == 'i') {
            Double healthExpenses = getHealthExpenses();
            return new Individual(name, annualIncome, healthExpenses);
        } else {
            int employees = getNumberOfEmployees();
            return new Company(name, annualIncome, employees);
        }
    }

    private static char getTaxPayerType() {
        System.out.print("Individual or company (i/c)? ");
        return Character.toLowerCase(sc.next().charAt(0));
    }

    private static String getName() {
        System.out.print("Name: ");
        sc.nextLine(); // Consume newline
        return sc.nextLine();
    }

    private static Double getAnnualIncome() {
        System.out.print("Annual income: ");
        return sc.nextDouble();
    }

    private static Double getHealthExpenses() {
        System.out.print("Health expenditures: ");
        return sc.nextDouble();
    }

    private static int getNumberOfEmployees() {
        System.out.print("Number of employees: ");
        return sc.nextInt();
    }

    private static void printTaxes(List<TaxPayer> taxpayers) {
        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0.0;

        for (TaxPayer taxpayer : taxpayers) {
            double tax = taxpayer.calculateTax();
            System.out.printf("%s: $ %.2f%n", taxpayer.getName(), tax);
            totalTaxes += tax;
        }

        System.out.printf("%nTOTAL TAXES: $ %.2f%n", totalTaxes);
    }
}