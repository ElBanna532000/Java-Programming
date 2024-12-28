import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    Library l = new Library();
    Scanner input = new Scanner(System.in);

    public void displayMainMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("========== Welcome to Library Management System ==========");
            System.out.println("================= Displaying Main Menu =================");
            System.out.println("1: Client Section");
            System.out.println("2: Item Section");
            System.out.println("3: Borrow/Return Section");
            System.out.println("Exit: Press 0");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
                input.nextLine(); // Clear the buffer
                switch (choice) {
                    case 1:
                        displayClientMenu();
                        break;
                    case 2:
                        displayItemMenu();
                        break;
                    case 3:
                        displayBorrowReturnMenu();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }

    /*public void displayMainMenu(){
        //Library l = new Library();
        System.out.println();
        System.out.println("========== Welcome to Library Management System ==========");
        System.out.println("================= Displaying Main Menu =================");
        System.out.println("1: Add a Client");
        System.out.println("2: Add an Item");
        System.out.println("3: Display All Clients");
        System.out.println("4: Display All Items");
        System.out.println("5: Search for a Client");
        System.out.println("6: Search for an Item");
        System.out.println("7: Delete a Client");
        System.out.println("8: Delete an Item");
        System.out.println("9: Rent an Item");
        System.out.println("10: Return an Item");
        System.out.println("11: List Borrowed Items");
        System.out.println("12: Update a Client");
        System.out.println("13: Update an Item");
        System.out.println("Exit: Press 0");
    }*/

    public void displayClientMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("========== Client Section ==========");
            System.out.println("1: Add a Client");
            System.out.println("2: Search for a Client");
            System.out.println("3: Display All Clients");
            System.out.println("4: Delete a Client");
            System.out.println("5: Update a Client");
            System.out.println("Exit: Press 0");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
                input.nextLine(); // Clear the buffer
                switch (choice) {
                    case 1:
                        addClient();
                        break;
                    case 2:
                        displayAllClients();
                        break;
                    case 3:
                        searchClient();
                        break;
                    case 4:
                        deleteClient();
                        break;
                    case 5:
                        updateClient();
                        break;
                    case 0:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }

    public void displayItemMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("========== Item Section ==========");
            System.out.println("1: Add an Item");
            System.out.println("2: Display All Items");
            System.out.println("3: Search for an Item");
            System.out.println("4: Delete an Item");
            System.out.println("5: Update an Item");
            System.out.println("Exit: Press 0");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
                input.nextLine(); // Clear the buffer
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        displayAllItems();
                        break;
                    case 3:
                        searchItem();
                        break;
                    case 4:
                        deleteItem();
                        break;
                    case 5:
                        updateItem();
                        break;
                    case 0:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }

    public void displayBorrowReturnMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("========== Borrow/Return Section ==========");
            System.out.println("1: Rent an Item");
            System.out.println("2: Return an Item");
            System.out.println("3: List Borrowed Items");
            System.out.println("Exit: Press 0");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
                input.nextLine(); // Clear the buffer
                switch (choice) {
                    case 1:
                        rentItem();
                        break;
                    case 2:
                        returnItem();
                        break;
                    case 3:
                        displayBorrowedItem();
                        break;
                    case 0:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }



    // Add a Client Method for Menu
    public void addClient(){
        System.out.println("==== Add a Client ====");
        Client c = new Client();        
        int id = 0;
        String name = "";
        String email = "";
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Enter Client ID: ");
                id = input.nextInt();
                input.nextLine();
                if(id<=0 || l.isDuplcateClientID(id)){
                    throw new Exception ("Invalid ID, Please Enter a Valid ID!");
                }
                flag = false;
            }catch(Exception e){
                System.out.println("Invalid ID, Please Enter a Valid ID!");
                input.nextLine();
            }
        }
        flag = true;

        while (flag) {
            try {
                System.out.println("Enter Client Name: ");
                name = input.nextLine();
                if (name.isEmpty() || !name.matches("^[a-zA-Z\\\\s]+$")) {
                    throw new Exception("Invalid Name, Please Enter a Valid Name!");
                }
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        flag = true;

        while (flag) {
            try {
                System.out.println("Enter Client Email: ");
                email = input.nextLine();
                if (email.isEmpty() || !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                    throw new Exception("Invalid Email, Please Enter a Valid Email!");
                }
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        l.addClient(id, name, email, c);
        System.out.println("Client Added Successfully!");
    }

    public void addItem(){
        
        int flag2 = 1;
        boolean flag = true;
        int id = 0;
        String name = "";
        String author = "";
        int noOfPages = 0;
        int issueNumber=0;
        String publcationDate="";


        while(flag2==1){
            System.out.println("==== Add an Item ====");
            System.out.println("Press 1 to add a Book, Press 2 to add a Magazine, Press 0 to Exit");
            
            //Scanner input = new Scanner(System.in);
            String child = input.nextLine();
            //input.nextLine();

            switch(child){
                case "0":
                    flag2=0;
                    break;
                case "1":
                    Book b = new Book();
                    while(flag){
                        try{
                            System.out.println("Enter Book ID: ");
                            id = input.nextInt();
                            input.nextLine();

                            if(id<=0 || l.isDuplicateItemID(id)){
                                throw new Exception("Invalid ID, Please Enter a Valid ID!");
                            }
                            flag = false;
                        }catch(InputMismatchException e){
                            System.out.println("Invalid Input, Please Enter a Valid One!");
                            input.nextLine();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            input.nextLine();
                        }
                    }
                    flag=true;
                    while(flag){
                        try {
                            System.out.println("Enter Book Name: ");
                            name = input.nextLine();
                            if (name.isEmpty()) {
                                throw new Exception("Invalid Input!");
                            }
                            flag = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }    
                    }
                    flag=true;

                    while (flag) {
                        try{
                            System.out.println("Enter Book Author Name: ");
                            author = input.nextLine();
                            if (author.isEmpty() || !author.matches("^[a-zA-Z\\\\s]+$")) {
                                throw new Exception("Invalid Name, Please Enter a Valid Name!");
                            }
                            flag = false;
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    flag = true;
                    while (flag) {
                        try{
                            System.out.println("Enter Book Number of Pages: ");
                            noOfPages = input.nextInt();
                            input.nextLine();
                            if (noOfPages<=0) {
                                throw new Exception("Invalid Input, Please Enter a Valid One!");
                            }
                            flag = false;
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            input.nextLine();
                        }
                    }
                    flag=true;

                    l.addBook(name, id, author, noOfPages, b);
                    System.out.println("Book Added Successfully!");
                    break;

                case "2":
                    Magazine m = new Magazine();

                    while(flag){
                        try{
                            System.out.println("Enter Magazine ID: ");
                            id = input.nextInt();
                            input.nextLine();

                            if(id<=0 || l.isDuplicateItemID(id)){
                                throw new Exception("Invalid ID, Please Enter a Valid ID!");
                            }
                            flag = false;
                        }catch(InputMismatchException e){
                            System.out.println("Invalid Input, Please Enter a Valid One!");
                            input.nextLine();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            input.nextLine();
                        }
                    }
                    flag=true;

                    while(flag){
                        try {
                            System.out.println("Enter Magazine Name: ");
                            name = input.nextLine();
                            if (name.isEmpty()) {
                                throw new Exception("Invalid Input!");
                            }
                            flag = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }    
                    }
                    flag=true;

                    while (flag) {
                        try{
                            System.out.println("Enter Magazine Issue Number: ");
                            issueNumber = input.nextInt();
                            input.nextLine();

                            if (issueNumber<=0) {
                                throw new Exception("Invalid Issue Number, Please Enter a Valid One!");
                            }
                            flag = false;
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            input.nextLine();
                        }
                    }
                    flag = true;
                    
                    while (flag) {
                        try{
                            System.out.println("Enter Publcation Date: ");
                            publcationDate = input.nextLine();
                            /*if (!publcationDate.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$")) {
                                throw new Exception("Invalid Publication Date, Please Enter a Valid One!");
                            }*/
                            flag = false;
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            input.nextLine();
                        }
                    }
                    flag = true;

                    l.addMagazine(name, id, publcationDate, issueNumber, m);
                    System.out.println("Magazine Added Successfully!");
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again!");
                    break;
            }

        }
    }
    void displayAllClients(){
        System.out.println("==== Displaying All Clients ====");
        try {
            l.displayAllClients();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    void displayAllItems(){
        System.out.println("==== Displaying All Items ====");
        try {
            l.displayAllItems();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    void searchClient(){
        System.out.println("==== Search for a Client ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        try {
            int id = input.nextInt();

            Client c = l.getClient(id);
            System.out.println("Client Found!");
            c.getClientDetails();
        }catch(InputMismatchException e){
            System.out.println("Invalid Input, Please Enter a Valid One!");
            input.nextLine();
        }catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void searchItem(){
        System.out.println("==== Search for an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Item ID: ");
        try {
            int id = input.nextInt();
            LibraryItem item = l.getItem(id);
            System.out.println("Item Found!");
            item.getItemDetails();
        }catch(InputMismatchException e){
            System.out.println("Invalid Input, Please Enter a Valid One!");
            input.nextLine();
        }catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    void updateClient(){
        System.out.println("==== Update a Client ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        try {
            Client c = l.getClient(id);
            System.out.println("Enter New Name: ");
            String name = input.next();
            c.setName(name);
            System.out.println("Enter New Email: ");
            String email = input.next();
            c.setEmail(email);
            System.out.println("Client Updated Successfully!");
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void updateItem(){
        System.out.println("==== Update an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Item ID: ");
        int id = input.nextInt();
        input.nextLine();
        try {
            LibraryItem item = l.getItem(id);
            if(item instanceof Book){
                System.out.println("Enter New Title: ");
                String title = input.nextLine();

                System.out.println("Enter New Author Name: ");
                String name = input.nextLine();
                
                System.out.println("Enter New Number of Pages: ");
                int noOfPages = input.nextInt();

                l.updateItem(id, title, noOfPages, name);
                System.out.println("Item Updated Successfully!");
                return;
            }else if(item instanceof Magazine){
                System.out.println("Enter New Title: ");
                String title = input.nextLine();

                System.out.println("Enter New Issue Number: ");
                int issueNumber = input.nextInt();
                input.nextLine();

                System.out.println("Enter New Publication Date: ");
                String publcationDate = input.nextLine();

                l.updateItem(id, title, issueNumber, publcationDate);
                System.out.println("Item Updated Successfully!");
                return;
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void rentItem(){
        System.out.println("==== Rent an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        System.out.println("Enter Item ID: ");
        int itemID = input.nextInt();
        try {
            //System.out.println("Before Rent Item Method");
            l.borrowItem(id, itemID);
        } catch (ItemNotFoundException e) {
            System.out.println("Invalid Client ID or Item ID, Please Try Again!");
        }catch (ClientNotFoundException e) {
            System.out.println("Invalid Client ID or Item ID, Please Try Again!");
        }
    }

    void displayBorrowedItem(){
        System.out.println("==== Displaying Borrowed Items ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        try {
            l.showBorrowedItems(id);
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void deleteClient(){
        System.out.println("==== Delete a Client ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        try {
            l.deleteClient(id);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void deleteItem(){
        System.out.println("==== Delete an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Item ID: ");
        int id = input.nextInt();
        try {
            l.deleteItem(id);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void returnItem(){
        System.out.println("==== Return an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        System.out.println("Enter Item ID: ");
        int itemID = input.nextInt();
        try {
            l.returnItem(id, itemID);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}