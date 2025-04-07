package semesterProject1;

import java.io.Serializable;

public class Car implements Serializable {
    private String id;
    private int mileage;
    private int mpg;
    private double cost;
    private double salesPrice;
    private boolean isSold;
    private double priceSold;

    public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.isSold = false;
        this.priceSold = 0.0;
    }

    public String getId() {
        return id;
    }

    public int getMileage() {
        return mileage;
    }

    public int getMpg() {
        return mpg;
    }

    public double getCost() {
        return cost;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public boolean isSold() {
        return isSold;
    }

    public double getPriceSold() {
        return priceSold;
    }

    public double getProfit() {
        return isSold ? priceSold - cost : 0;
    }

    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }

    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", mileage=" + mileage +
                ", mpg=" + mpg +
                ", cost=" + cost +
                ", salesPrice=" + salesPrice +
                ", isSold=" + isSold +
                ", priceSold=" + priceSold +
                '}';
    }
}
