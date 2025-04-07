# Car Lot Inventory Management System

## Author
cs-milo

## Overview
This Java console-based application simulates a car dealership inventory system. It allows users to manage a car lot by adding, selling, saving, loading, and analyzing car data through a command-line interface.

---

## 🧩 Project Structure

| File             | Description |
|------------------|-------------|
| `Car.java`       | Defines the Car class with attributes like ID, MPG, mileage, cost, and sales info. Implements `Serializable` to support saving/loading. |
| `CarLot.java`    | Manages a list of `Car` objects with methods to add, sell, sort, and analyze cars. Handles file persistence. |
| `CarLotMenu.java`| Provides a user-friendly CLI menu for interacting with the `CarLot` system. |

---

## 💡 Features

- Add a new car to inventory
- Sell a car and calculate profit
- Save and load inventory data from disk
- List inventory by order of acquisition
- List inventory sorted by MPG (best to worst)
- Display car with:
  - Best MPG
  - Highest mileage
- Calculate average MPG for all cars
- Calculate total profit from all sold cars

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or higher
- Command line or terminal

### Compile
```bash
javac Car.java CarLot.java CarLotMenu.java
```

### Run
```bash
java CarLotMenu
```

---

## 📁 Save/Load Format
- Cars are serialized and saved in `car_inventory.dat`
- The file includes full state for all cars (sold or not)

---

## 🧪 Example CLI Usage

```
--- Car Lot Main Menu ---
[1] Add a car to inventory
[2] Sell a car from inventory
...
[0] Exit
Enter your choice:
```

---

## 🚀 Future Improvements
- Implement a GUI interface
- Add VIN validation
- Support JSON or CSV file storage
- Enable filtering by MPG range, price, or mileage

---

## License
This project is for educational use only. Not for commercial deployment.
