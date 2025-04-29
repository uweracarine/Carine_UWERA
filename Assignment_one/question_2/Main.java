package TaxEnforcementManagementSystem;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TaxDeclaration> declarations = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Declare PAYE\n2. Declare VAT\n3. Declare Withholding Tax\n4. View Declarations\n5. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Enter ID, Name, TIN, Date(YYYY-MM-DD), Salary: ");
                    String id = sc.next(); String name = sc.next(); String tin = sc.next();
                    LocalDate date = LocalDate.parse(sc.next()); double salary = sc.nextDouble();

                    if (tin.length() != 9) throw new IllegalArgumentException("TIN must be 9 digits");

                    PAYEDeclaration paye = new PAYEDeclaration(id, name, tin, date, salary);
                    paye.validateDeclaration();
                    paye.calculateTax();
                    paye.generateReceipt();
                    paye.enforceCompliance();
                    declarations.add(paye);

                } else if (choice == 2) {
                    System.out.print("Enter ID, Name, TIN, Date(YYYY-MM-DD), Sales, Purchases: ");
                    String id = sc.next(); String name = sc.next(); String tin = sc.next();
                    LocalDate date = LocalDate.parse(sc.next()); double sales = sc.nextDouble(); double purchases = sc.nextDouble();

                    if (tin.length() != 9) throw new IllegalArgumentException("TIN must be 9 digits");

                    VATDeclaration vat = new VATDeclaration(id, name, tin, date, sales, purchases);
                    vat.validateDeclaration();
                    vat.calculateTax();
                    vat.generateReceipt();
                    vat.enforceCompliance();
                    declarations.add(vat);

                } else if (choice == 3) {
                    System.out.print("Enter ID, Name, TIN, Date(YYYY-MM-DD), Category, Amount: ");
                    String id = sc.next(); String name = sc.next(); String tin = sc.next();
                    LocalDate date = LocalDate.parse(sc.next()); String category = sc.next(); double amount = sc.nextDouble();

                    if (tin.length() != 9) throw new IllegalArgumentException("TIN must be 9 digits");

                    WithholdingTaxDeclaration withhold = new WithholdingTaxDeclaration(id, name, tin, date, category, amount);
                    withhold.validateDeclaration();
                    withhold.calculateTax();
                    withhold.generateReceipt();
                    withhold.enforceCompliance();
                    declarations.add(withhold);

                } else if (choice == 4) {
                    for (TaxDeclaration td : declarations) {
                        td.generateReceipt();
                    }
                } else if (choice == 5) {
                    System.out.println("Exiting system.");
                    break;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // clear buffer
            }
        }
        sc.close();
    }
}
