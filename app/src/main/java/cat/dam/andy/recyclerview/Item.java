package cat.dam.andy.recyclerview;

public class Item {
    private int id;
    private String name;
    private String description;
    private int imageResourceID;
    private double price;

    public Item(int id, String name, String description, int imageResourceID, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageResourceID = imageResourceID;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
