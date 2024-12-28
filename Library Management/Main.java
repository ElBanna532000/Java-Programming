import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMainMenu();
        /*int flag=1;
        String choice;
        while(flag==1){
            menu.displayMenu();
            System.out.print("Take an Action: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextLine();
            switch (choice){
                case "1":
                    menu.addClient();
                    break;
                case "2":
                    menu.addItem();
                    break;
                case "3":
                    menu.displayAllClients();
                    break;
                case "4":
                    menu.displayAllItems();
                    break;
                case "5":
                    menu.searchClient();
                    break;
                case "6":
                    menu.searchItem();
                    break;
                case "7":
                    menu.deleteClient();
                    break;
                case "8": 
                    menu.deleteItem();
                    break;
                case "9":
                    menu.rentItem();
                    break;
                case "10":
                    menu.returnItem();
                    break;
                case "11":
                    menu.displayBorrowedItem();
                    break;
                case "12":
                    menu.updateClient();
                    break;
                case "13":
                    menu.updateItem();
                    break;
                case "0":
                    flag=0;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }/* */
    }
}
