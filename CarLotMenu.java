package semesterProject1;

import java.util.Scanner;

public class CarLotMenu {
    public static void main(String[] args) {
        CarLot carLot = new CarLot();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Car Lot Main Menu ---");
            System.out.println("[1] Add a car to inventory");
            System.out.println("[2] Sell a car from inventory");
            System.out.println("[3] Save To Disk");
            System.out.println("[4] Load From Disk");
            System.out.println("[5] List inventory by order of acquisition");
            System.out.println("[6] List Inventory From Best MPG to Worst MPG");
            System.out.println("[7] Display car with best MPG");
            System.out.println("[8] Display car with the highest mileage");
            System.out.println("[9] Display overall MPG for the entire inventory");
            System.out.println("[10] Display profit for all sold cars");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Car ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter Mileage:");
                    int mileage = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter MPG:");
                    int mpg = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Cost:");
                    double cost = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter Sales Price:");
                    double salesPrice = Double.parseDouble(scanner.nextLine());
                    carLot.addCar(id, mileage, mpg, cost, salesPrice);
                    System.out.println("Car added successfully!");
                }
                case 2 -> {
                    System.out.println("Enter Car ID to sell:");
                    String id = scanner.nextLine();
                    System.out.println("Enter Sale Price:");
                    double salePrice = Double.parseDouble(scanner.nextLine());
                    carLot.sellCar(id, salePrice);
                }
                case 3 -> carLot.saveToDisk();
                case 4 -> carLot.loadFromDisk();
                case 5 -> carLot.getCarsInOrderOfEntry().forEach(System.out::println);
                case 6 -> carLot.getCarsSortedByMPG().forEach(System.out::println);
                case 7 -> System.out.println(carLot.getCarWithBestMPG());
                case 8 -> System.out.println(carLot.getCarWithHighestMileage());
                case 9 -> System.out.println("Average MPG: " + carLot.getAverageMpg());
                case 10 -> System.out.println("Total Profit: $" + carLot.getTotalProfit());
                case 0 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
