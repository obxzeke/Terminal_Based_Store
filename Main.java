import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store("Users.csv", "Products.csv", "Orders.csv");

        System.out.println("Welcome to the store\n");
        
        while(true){
            System.out.println("Please select an option");
            System.out.println("1: log-in");
            System.out.println("2: Register");

            try{
                int input = sc.nextInt();
                sc.nextLine();
                if (input < 1 || input > 2){
                    throw new Exception("Invalid seleciton");
                }

                if (input == 1){
                    System.out.println("email: ");
                    String emailInput = sc.nextLine();
                    System.out.println("password: ");
                    String passwordInput = sc.nextLine();
                    if(store.validateCredentials(emailInput, passwordInput)){
                        System.out.println("Successfully logged in");
                        break;
                    }
                    else{
                        System.out.println("Credentials are not correct, please try again");
                    }
                }
                else if (input == 2){
                    System.out.println("First Name");
                    String firstNameInput = sc.nextLine();
                    System.out.println("Last Name: ");
                    String lastNameInput = sc.nextLine();
                    System.out.println("Email: ");
                    String emailInput = sc.nextLine();
                    System.out.println("Password: ");
                    String passwordInput = sc.nextLine();
                    store.registerUser(firstNameInput, lastNameInput, emailInput, passwordInput);
                    System.out.println("Successfully registered");
                    break;
                }
            }
            catch (InputMismatchException ex){
                sc.nextLine();
                System.out.println("Invalid type entered. Please try again!\n");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Please try again\n");
            }
        }
        
        while(true){
            System.out.println("Please select an option");
            System.out.println("\t1: View products");
            System.out.println("\t2: Check out");
            System.out.println("\t3: Change email");
            System.out.println("\t4: Change password");
            System.out.println("\t5: Exit");

            if (store.isAdmin()){
                System.out.println("\nAdmin options");
                System.out.println("\t6: Add product");
                System.out.println("\t7: Edit Inventory");
                System.out.println("\t8: Order History");
            }
            
            try{
                int selectInput = sc.nextInt();
                sc.nextLine();

                if (selectInput < 1 || selectInput > 8){
                    if (selectInput > 5 && !store.isAdmin()){
                        throw new Exception("Invalid seleciton");
                    }
                }

                if (selectInput == 1){
                    System.out.println("\nPlease select an option");
                    System.out.println("\t1: Laptops");
                    System.out.println("\t2: Merch");
                    System.out.println("\t3: Textbooks");
                    System.out.println("\t4: All products");
                    int productInput = sc.nextInt();
                    sc.nextLine();

                    if (productInput < 1 || productInput > 4){
                        throw new Exception("Invalid seleciton");
                    }

                    store.viewProducts(productInput);

                    System.out.println("Would you like to add any products to your cart?");
                    System.out.println("Select 0 to go home");
                    int cartInput = sc.nextInt();
                    sc.nextLine();

                    if (cartInput != 0){
                        store.addToCart(cartInput);
                    }
                    
                }
                else if(selectInput == 2){
                    store.checkOut();
                }
                else if(selectInput == 3){
                    System.out.println("Enter new email address");
                    String emailInput = sc.nextLine();
                    store.setEmail(emailInput);
                }
                else if(selectInput == 4){
                    System.out.println("Enter new password");
                    String passwordInput = sc.nextLine();
                    store.setPassword(passwordInput);
                }
                else if(selectInput == 5){
                    store.close();
                }
                else if(selectInput == 6){
                    System.out.println("What type of product do you want to add?");
                    System.out.println("\t1: Laptop");
                    System.out.println("\t2: Merch");
                    System.out.println("\t3: Textbook");
                    System.out.println("\t4: Generic");
                    int typeInput = sc.nextInt();
                    sc.nextLine();
                    if (typeInput < 1 || typeInput > 4){
                        throw new Exception("Invalid seleciton");
                    }

                    System.out.println("Name: ");
                    String nameInput = sc.nextLine();
                    System.out.println("Price: ");
                    double priceInput = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Quantity: ");
                    int quantityInput = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Description: ");
                    String descInput = sc.nextLine();

                    if (typeInput == 1){
                        System.out.println("Battery Life: ");
                        double batteryInput = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Processor: ");
                        String processorInput = sc.nextLine();
                        System.out.println("Storage: ");
                        String storageInput = sc.nextLine();
                        System.out.println("Screen size ");
                        double screenInput = sc.nextDouble();
                        sc.nextLine();
                        store.addLaptop(priceInput, quantityInput, nameInput, descInput, batteryInput, processorInput, storageInput, screenInput);
                    }
                    else if(typeInput == 2){
                        System.out.println("Size: ");
                        String sizeInput = sc.nextLine();
                        store.addMerch(priceInput, quantityInput, nameInput, descInput, sizeInput);
                    }
                    else if(typeInput == 3){
                        System.out.println("ISBN: ");
                        int isbnInput = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Author: ");
                        String authorInput = sc.nextLine();
                        System.out.println("Publisher: ");
                        String publisherInput = sc.nextLine();
                        store.addTextbook(priceInput, quantityInput, nameInput, descInput, isbnInput, authorInput, publisherInput);
                    }
                    else{
                        store.addProduct(priceInput, quantityInput, nameInput, descInput);
                    }
                }
                else if(selectInput == 7){
                    System.out.println("\nPlease select an option");
                    System.out.println("\t1: Laptops");
                    System.out.println("\t2: Merch");
                    System.out.println("\t3: Textbooks");
                    System.out.println("\t4: All products");
                    int productInput = sc.nextInt();
                    sc.nextLine();

                    if (productInput < 1 || productInput > 4){
                        throw new Exception("Invalid seleciton");
                    }

                    store.viewProducts(productInput);

                    System.out.println("Which product id would you like to edit the inventory for?");
                    int idInput = sc.nextInt();
                    sc.nextLine();
                    System.out.println("What is the new quantity?");
                    int quantityInput = sc.nextInt();
                    sc.nextLine();

                    store.setQuantity(idInput, quantityInput);
                }
                else if(selectInput == 8){
                    store.viewOrders();
                }
            }
            catch (InputMismatchException ex){
                sc.nextLine();
                System.out.println("Invalid type entered. Please try again!\n");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Please try again\n");
            }
        } //main loop
    } //main
}// main class
