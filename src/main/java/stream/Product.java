package stream;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int existence;

    public Product(String name, double price, int existence) {
        this.name = name;
        this.price = price;
        this.existence = existence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExistence() {
        return existence;
    }

    public void setExistence(int existence) {
        this.existence = existence;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", existence=" + existence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                existence == product.existence &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, existence);
    }
}
