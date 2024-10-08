package se.kth.ahmad_nedal.distributed_systems_java.BO;

/**
 * ProductInfo is a simple data model class representing a product with
 * an ID, name, and price.
 *
 * This class is used to store and manipulate information about a product
 * and provides getter and setter methods to access and update the product's attributes.
 */
public class ProductInfo {
    private int id;
    private String name;
    private double price;

    /**
     * Constructs a ProductInfo object with the specified id, name, and price.
     *
     * @param id    the product's unique identifier
     * @param name  the product's name
     * @param price the product's price
     */
    public ProductInfo(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the product's unique identifier.
     *
     * @return the product's id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the product's unique identifier.
     *
     * @param id the new product id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the product's name.
     *
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product's name.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product's price.
     *
     * @return the product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product's price.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
