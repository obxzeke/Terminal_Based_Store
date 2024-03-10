public class Laptop extends Product {
    private double batteryLife;
    private String processor;
    private String storage;
    private double screenSize;

    public Laptop(int productId, double price, int quantity, String name, String description, double batteryLife, String processor, String storage, double screenSize){
        super(productId, price, quantity, name, description);
        this.batteryLife = batteryLife;
        this.processor = processor;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public String toString(){
        return "Name: " + name + "\nId: " + productId + "\nPrice: $" + price + "\nQuantity: " + quantity + "\nDescription: " + description + "\nBattery Life: " + batteryLife + " hours\nProcessor: " + processor + "\nStorage: " + storage + "gb\nScreen Size: " + screenSize + "inches\n";
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[10];
        mixedArray[0] = productId;
        mixedArray[1] = price;
        mixedArray[2] = quantity;
        mixedArray[3] = name;
        mixedArray[4] = description;
        mixedArray[5] = "Laptop";
        mixedArray[6] = batteryLife;
        mixedArray[7] = processor;
        mixedArray[8] = storage;
        mixedArray[9] = screenSize;
        return mixedArray;
    }
}
