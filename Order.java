import java.time.LocalDate;

public class Order {
    private int orderId;
    private LocalDate date;
    private double totalPrice;

    public Order(int orderId, double totalPrice){
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.date = LocalDate.now();
    }

    public Order(int orderId, double totalPrice, LocalDate date){
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public String toString(){
        return "Order Id: " + orderId + "\nDate: " + date + "\nTotal: " + totalPrice + "$\n";
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[3];
        mixedArray[0] = orderId;
        mixedArray[1] = date;
        mixedArray[2] = totalPrice;
        return mixedArray;
    }
}
