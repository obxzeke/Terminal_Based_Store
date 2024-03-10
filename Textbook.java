public class Textbook extends Product{
    private int isbn;
    private String author;
    private String publisher;

    public Textbook(int productId, double price, int quantity, String name, String description, int isbn, String author, String publisher){
        super(productId, price, quantity, name, description);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
    }

    public String toString(){
        return "Name: " + name + "\nId: " + productId + "\nPrice: $" + price + "\nQuantity: " + quantity + "\nDescription: " + description + "\nAuthor: " + author + "\nPublisher "+ publisher + "ISBN: " + isbn + "\n";
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[9];
        mixedArray[0] = productId;
        mixedArray[1] = price;
        mixedArray[2] = quantity;
        mixedArray[3] = name;
        mixedArray[4] = description;
        mixedArray[5] = "Textbook";
        mixedArray[6] = isbn;
        mixedArray[7] = author;
        mixedArray[8] = publisher;
        return mixedArray;
    }
}
