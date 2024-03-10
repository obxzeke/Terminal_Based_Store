public abstract class Product {
    
    protected int productId;
    protected double price;
    protected int quantity;
    protected String name;
    protected String description;
    
    public Product(int productId, double price, int quantity, String name, String description){
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
    }

    public String toString(){
        return "Name: " + name + "\nId: " + productId + "\nPrice: $" + price + "\nQuantity: " + quantity + "\nDescription: " + description + "\n";
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[5];
        mixedArray[0] = productId;
        mixedArray[1] = price;
        mixedArray[2] = quantity;
        mixedArray[3] = name;
        mixedArray[4] = description;
        return mixedArray;
    }

    public int getProductId(){
        return this.productId;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
