public class PayrollCalculator {


    public static double calculateWeeklyPay(String employeeType, double
            hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Error: Negative input values.");
            return 0;

    }

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double overtime = (hoursWorked - 40) * hourlyRate * 1.5;
                    return (40 * hourlyRate) + overtime;
                }
            case "PART_TIME":
                if (hoursWorked > 25) {
                    hoursWorked = 25; // cap at 25 hours
                }
                return hoursWorked * hourlyRate;
            case "CONTRACTOR":
                return hoursWorked * hourlyRate;
            case "INTERN":
                if (hoursWorked > 20) {
                    hoursWorked = 20; // cap at 20 hours
                }
                return hoursWorked * (hourlyRate * 0.8); // 20% discount
            default:
                System.out.println("Error: Invalid employee type.");
                return 0;
        }
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    // Method to process multiple employees and display payroll statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int count = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double[] netPays = new double[count];
        double totalPay = 0;
        int overtimeCount = 0;
        int highestIndex = 0;
        int lowestIndex = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Gross", "Net Pay");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true); // assuming all have health insurance
            double net = gross - tax;
            netPays[i] = net;
            totalPay += net;

            if (hours[i] > 40) {
                overtimeCount++;
            }

            if (net > netPays[highestIndex]) highestIndex = i;
            if (net < netPays[lowestIndex]) lowestIndex = i;

            System.out.printf("%-10s %-12s %-10.1f %-10.2f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], rates[i], gross, net);
        }

        double avgPay = totalPay / count;

        System.out.println("\n--- Payroll Summary ---");
        System.out.println("Highest Paid: " + names[highestIndex] + " ($" + netPays[highestIndex] + ")");
        System.out.println("Lowest Paid: " + names[lowestIndex] + " ($" + netPays[lowestIndex] + ")");
        System.out.println("Average Net Pay: $" + avgPay);
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    // Main method to test everything
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        System.out.println("Individual Calculations:");
        for (int i = 0; i < types.length; i++) {
            double gross = calculateWeeklyPay(types[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true);
            System.out.println(names[i] + ": Gross $" + gross + ", Tax $" + tax + ", Net $" + (gross - tax));
        }

        System.out.println("\nProcessing Full Payroll:");
        processPayroll(types, hours, rates, names);
    }
}

