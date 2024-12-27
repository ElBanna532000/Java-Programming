import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    Library l = new Library();
    Scanner input = new Scanner(System.in);


    public void displayMenu(){
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
        System.out.println("10: List Borrowed Items");
        System.out.println("11: Return an Item");
        System.out.println("12: Update a Client");
        System.out.println("13: Update an Item");
        System.out.println("Exit: Press 0");
    }
    
    public void addClient(){
        System.out.println("==== Add a Client ====");
        Client c = new Client();
        //Scanner input = new Scanner(System.in);
        
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
            System.out.println("Press 1 to add a Book, Press 2 to add a Magazine");
            
            //Scanner input = new Scanner(System.in);
            int child = input.nextInt();
            //input.nextLine();

            switch(child){
                case 1:
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
                case 2:
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
                    System.out.println("Press 1 to Continue, 0 to Exit");
                    flag2 = input.nextInt();
                    break;
            }

        }
    }
    void displayAllClients(){
        System.out.println("==== Displaying All Clients ====");
        l.displayAllClients();
    }

    void displayAllItems(){
        System.out.println("==== Displaying All Items ====");
        l.displayAllItems();
    }

    void searchClient(){
        System.out.println("==== Search for a Client ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        try {
            Client c = l.getClient(id);
            System.out.println("Client Found!");
            c.getClientDetails();
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void searchItem(){
        System.out.println("==== Search for an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Item ID: ");
        int id = input.nextInt();
        try {
            LibraryItem item = l.getItem(id);
            System.out.println("Item Found!");
            item.getItemDetails();
        } catch (ItemNotFoundException e) {
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
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void updateItem(){
        System.out.println("==== Update an Item ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Item ID: ");
        int id = input.nextInt();
        try {
            LibraryItem item = l.getItem(id);
            System.out.println("Enter New Title: ");
            String title = input.next();
            l.updateItem(id, title);
            System.out.println("Item Updated Successfully!");
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
            System.out.println(e.getMessage());
        }
    }

    void displayBorrowedItem(){
        System.out.println("==== Displaying Borrowed Items ====");
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        try {
            l.showBorrowedItems(id);
        } catch (ItemNotFoundException e) {
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
            System.out.println("Client Deleted Successfully!");
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
            System.out.println("Item Deleted Successfully!");
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
        }
    }
}