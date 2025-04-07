package semesterProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class CarLot {
    private ArrayList<Car> inventory;

    public CarLot() {
        inventory = new ArrayList<>();
    }

    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
        Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
        inventory.add(newCar);
    }

    public void sellCar(String id, double priceSold) {
        Car car = findCarByIdentifier(id);
        if (car != null) {
            car.setPriceSold(priceSold);
            car.setSold(true);
        } else {
            System.out.println("Car not found.");
        }
    }

    public void saveToDisk() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car_inventory.dat"))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving to disk: " + e.getMessage());
        }
    }

    public void loadFromDisk() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car_inventory.dat"))) {
            inventory = (ArrayList<Car>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from disk: " + e.getMessage());
        }
    }

    public ArrayList<Car> getCarsInOrderOfEntry() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedList = new ArrayList<>(inventory);
        sortedList.sort(Comparator.comparingInt(Car::getMpg).reversed());
        return sortedList;
    }

    public Car getCarWithBestMPG() {
        return inventory.stream().max(Comparator.comparingInt(Car::getMpg)).orElse(null);
    }

    public Car getCarWithHighestMileage() {
        return inventory.stream().max(Comparator.comparingInt(Car::getMileage)).orElse(null);
    }

    public double getAverageMpg() {
        return inventory.stream().mapToInt(Car::getMpg).average().orElse(0.0);
    }

    public double getTotalProfit() {
        return inventory.stream().filter(Car::isSold).mapToDouble(Car::getProfit).sum();
    }

    private Car findCarByIdentifier(String id) {
        return inventory.stream().filter(car -> car.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}
