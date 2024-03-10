import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class Store {
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Order> orderList = new ArrayList<>();
    private ArrayList<Product> cart = new ArrayList<>();
    private int currentUserId;

    public Store(String userFile, String productFile, String orderFile){
        try{
            Scanner fileScanner = new Scanner(new File(userFile));
            String line;
            line = fileScanner.nextLine();
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] lineArray = line.split(",");
                User user = new User(Integer.parseInt(lineArray[0]), lineArray[1], lineArray[2], lineArray[3], Boolean.parseBoolean(lineArray[4]), lineArray[5]);
                userList.add(user);
            }
            fileScanner.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for users.txt. Try again making sure the file name and path are correct.");
            System.exit(0);
        }

        try{
            Scanner fileScanner = new Scanner(new File(orderFile));
            String line;
            line = fileScanner.nextLine();
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] lineArray = line.split(",");
                Order order = new Order(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), LocalDate.parse(lineArray[2]));
                orderList.add(order);
            }
            fileScanner.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for orders.csv. Try again making sure the file name and path are correct.");
            System.exit(0);
        }

        try{
            Scanner fileScanner = new Scanner(new File(productFile));
            String line;
            line = fileScanner.nextLine();
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                if (line.contains("Laptop")){
                    String[] lineArray = line.split(",");
                    Laptop laptop = new Laptop(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), Integer.parseInt(lineArray[2]), lineArray[3], lineArray[4], Double.parseDouble(lineArray[6]), lineArray[7], lineArray[8], Double.parseDouble(lineArray[9]));
                    productList.add(laptop);
                }
                else if (line.contains("Merch")){
                    String[] lineArray = line.split(",");
                    Merch merch = new Merch(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), Integer.parseInt(lineArray[2]), lineArray[3], lineArray[4], lineArray[6]);
                    productList.add(merch);
                }
                else if (line.contains("Textbook")){
                    String[] lineArray = line.split(",");
                    Textbook textbook = new Textbook(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), Integer.parseInt(lineArray[2]), lineArray[3], lineArray[4], Integer.parseInt(lineArray[6]), lineArray[7], lineArray[8]);
                    productList.add(textbook);
                }
                else{
                    String[] lineArray = line.split(",");
                    Product product = new GenericProduct(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), Integer.parseInt(lineArray[2]), lineArray[3], lineArray[4]);
                    productList.add(product);
                }
            }

            fileScanner.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for Products.csv. Try again making sure the file name and path are correct.");
            System.exit(0);
        }
    }

    public void addLaptop(double price, int quantity, String name, String description, double batteryLife, String processor, String storage, double screenSize){
        int id = productList.size() + 1;
        Laptop laptop = new Laptop(id, price, quantity, name, description, batteryLife, processor, storage, screenSize);
        productList.add(laptop);
    }

    public void addTextbook(double price, int quantity, String name, String description, int isbn, String author, String publisher){
        int id = productList.size() + 1;
        Textbook textbook = new Textbook(id, price, quantity, name, description, isbn, author, publisher);
        productList.add(textbook);
    }

    public void addMerch(double price, int quantity, String name, String description, String size){
        int id = productList.size() + 1;
        Merch merch = new Merch(id, price, quantity, name, description, size);
        productList.add(merch);
    }

    public void addProduct(double price, int quantity, String name, String description){
        int id = productList.size() + 1;
        Product product = new GenericProduct(id, price, quantity, name, description);
        productList.add(product);
    }

    public void removeProduct(int id){
        for (Product p : productList){
            if (p.getProductId() == id){
                productList.remove(p);
            }
        }
    }

    public void registerUser(String firstName, String lastName, String email, String password){
        int id = userList.size() + 1;
        boolean isAdmin = false;
        User user = new User(id, firstName, lastName, email, isAdmin, password);
        userList.add(user);
        this.currentUserId = id;
    }

    public void removeUser(int id){
        for (User u : userList){
            if (u.getUserId() == id){
                userList.remove(u);
            }
        }
    }

    public void addOrder(double totalPrice){
        int id = orderList.size() + 1;
        Order order = new Order(id, totalPrice);
        orderList.add(order);
    }

    public void updateInventory(int id, int quantity){
        for(Product p : productList){
            if(p.getProductId() == id){
                p.setQuantity(quantity);
            }
        }
    }

    public Boolean validateCredentials(String email, String password){
        for (User u : userList){
            if (u.getEmail().equals(email)){
                if (u.getPassword().equals(password)){
                    this.currentUserId = u.getUserId();
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean isAdmin(){
        for (User u : userList){
            if(u.getUserId() == currentUserId){
                return u.isAdmin();
            }
        }
        return false;
    }

    public void viewProducts(int productInput) {
        switch (productInput) {
            case 1:
                for(Product p : productList){
                    if (p instanceof Laptop){
                        System.out.println(p);
                    }
                }
                break;
            case 2:
                for(Product p : productList){
                    if (p instanceof Merch){
                        System.out.println(p);
                    }
                }
                break;
            case 3:
                for(Product p : productList){
                    if (p instanceof Textbook){
                        System.out.println(p);
                    }
                }
                break;
            case 4:
                for(Product p : productList){
                    System.out.println(p);
                }
                break;
            default:
                break;
        }
    }

    public void addToCart(int cartInput) {
        for (Product p : productList){
            if (cartInput == p.productId){
                cart.add(p);
                p.setQuantity(p.getQuantity() - 1);
                System.out.println("Successfully added product to cart\n");
                return;
            }
        }
        System.out.println("Could not find a product with that id, please try again\n");
    }

    public void checkOut() {
        double subTotal = 0;
        if (cart.isEmpty()){
            System.out.println("There is nothing in your cart\n");
            return;
        }

        for (Product p : cart){
            subTotal += p.getPrice();
        }
        System.out.println("Your total is " + subTotal + "$ Thanks for your purchase\n");
        addOrder(subTotal);
        cart.clear();
    }

    public void setEmail(String emailInput) {
        for (User u : userList){
            if (u.getUserId() == currentUserId){
                u.setEmail(emailInput);
            }
        }
        System.out.println("Successfully set email\n");
    }

    public void setPassword(String passwordInput) {
        for (User u : userList){
            if (u.getUserId() == currentUserId){
                u.setPassword(passwordInput);;
            }
        }
        System.out.println("Successfully set password\n");
    }

    public void close() {
        try{
            FileOutputStream userFile = new FileOutputStream("Users.csv");
            PrintWriter outFS = new PrintWriter(userFile);

            outFS.println("userID,firstName,lastName,email,isAdmin,password");

            for (User u : userList){
                Object[] printArray = u.getAllInformation();
                outFS.println(printArray[0] + "," + printArray[1] + "," + printArray[2] + "," + printArray[3] + "," + printArray[4] + "," + printArray[5]);
            }

            outFS.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
        }

        try{
            FileOutputStream orderFile = new FileOutputStream("Orders.csv");
            PrintWriter outFS = new PrintWriter(orderFile);

            outFS.println("orderId,totalPrice,date");

            for (Order o : orderList){
                Object[] printArray = o.getAllInformation();
                outFS.println(printArray[0] + "," + printArray[2] + "," + printArray[1]);
            }

            outFS.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
        }

        try{
            FileOutputStream productFile = new FileOutputStream("Products.csv");
            PrintWriter outFS = new PrintWriter(productFile);

            outFS.println("productId,price,quantity,name,description,type,other,other,other,other");

            for (Product p : productList){
                if (p instanceof Laptop){
                    Object[] printArray = p.getAllInformation();
                    outFS.println(printArray[0] + "," + printArray[1] + "," + printArray[2] + "," + printArray[3] + "," + printArray[4] + "," + printArray[5] + "," + printArray[6] + "," + printArray[7] + "," + printArray[8] + "," + printArray[9]);
                }
                if (p instanceof Merch){
                    Object[] printArray = p.getAllInformation();
                    outFS.println(printArray[0] + "," + printArray[1] + "," + printArray[2] + "," + printArray[3] + "," + printArray[4] + "," + printArray[5] + "," + printArray[6]);
                }
                if (p instanceof Textbook){
                    Object[] printArray = p.getAllInformation();
                    outFS.println(printArray[0] + "," + printArray[1] + "," + printArray[2] + "," + printArray[3] + "," + printArray[4] + "," + printArray[5] + "," + printArray[6] + "," + printArray[7] + "," + printArray[8]);
                }  
            }

            outFS.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
        }

        System.out.println("See you soon!");
        System.exit(0);
    }

    public void setQuantity(int idInput, int quantityInput) {
        for (Product p : productList){
            if (idInput == p.getProductId()){
                p.setQuantity(quantityInput);
            }
        }
    }

    public void viewOrders(){
        for (Order o : orderList){
            System.out.println(o);
        }
    }

}
