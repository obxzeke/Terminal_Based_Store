public class Merch extends Product {
    private String size;
    public Merch(int productId, double price, int quantity, String name, String description, String size){
        super(productId, price, quantity, name, description);
        this.size = size;
    }
    
    public String toString(){
        return "Name: " + name + "\nId: " + productId + "\nPrice: $" + price + "\nQuantity: " + quantity + "\nDescription: " + description + "\nSize: " + size + "\n";
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[7];
        mixedArray[0] = productId;
        mixedArray[1] = price;
        mixedArray[2] = quantity;
        mixedArray[3] = name;
        mixedArray[4] = description;
        mixedArray[5] = "Merch";
        mixedArray[6] = size;
        return mixedArray;
    }
}
