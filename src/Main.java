import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;
    private String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: $" + amount + ", Description: " + description;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount, String description) {
        Expense expense = new Expense(category, amount, description);
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("=== Expenses ===");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
}

 class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();

        while (true) {
            System.out.println("\n===== Expense Tracker System =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    expenseTracker.addExpense(category, amount, description);
                    break;

                case 2:
                    expenseTracker.viewExpenses();
                    break;

                case 3:
                    System.out.println("Exiting Expense Tracker System. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
