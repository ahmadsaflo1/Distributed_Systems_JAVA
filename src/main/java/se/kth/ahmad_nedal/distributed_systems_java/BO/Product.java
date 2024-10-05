package se.kth.ahmad_nedal.distributed_systems_java.BO;

/**
 * The Product class represents a product with an ID, name, and price.
 * This class provides methods to access and modify product details.
 */
public class Product {

    /** The unique identifier for the product */
    private int id;

    /** The name of the product */
    private String name;

    /** The price of the product */
    private double price;

    /**
     * Constructs a new Product with the specified ID, name, and price.
     *
     * @param id    the unique identifier for the product
     * @param name  the name of the product
     * @param price the price of the product
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the unique identifier of the product.
     *
     * @return the product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id the new product ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the product.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the product, containing the ID, name, and price.
     *
     * @return a string in the format "id, name, price"
     */
    @Override
    public String toString() {
        return id + ", " + name + ", " + price;
    }
}
