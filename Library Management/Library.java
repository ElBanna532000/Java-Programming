import java.util.*;

public class Library{
    private List<LibraryItem>items = new ArrayList<>();
    private List<Client>clients = new ArrayList<>();
    
    public <T extends LibraryItem> void addItem(T item){
        System.out.println("add done");
        items.add(item);
    }

    public void addClientToList(Client c){
        clients.add(c);
        //System.out.println("Success List");
    }

    public void addBook(String title, int id, String author, int pages, Book b){
        //System.out.println("Before Add");
        b.setTitle(title);
        b.setID(id);
        b.setAuthor(author);
        b.setNoOfPages(pages);
        //System.out.println("after Add");
        addItem(b);
    }

    public void addMagazine(String title, int id, String date, int issueNo, Magazine m){
        m.setTitle(title);
        m.setID(id);
        m.setIssueNumber(issueNo);
        m.setPublcationDate(date);
        addItem(m);
    }

    public void addClient(int id, String name, String email, Client c){
        //System.out.println("Success Enter");
        c.setID(id);
        c.setName(name);
        c.setEmail(email);
        addClientToList(c);
        //System.out.println("Success Exit");
    }

    public LibraryItem getItem(int id) throws ItemNotFoundException{
        /*for (LibraryItem libraryItem : items) {
            if(libraryItem.id==id){
                return libraryItem;
            }
        }*/
        LibraryItem libraryItem = items.stream().filter(item -> item.id == id).findFirst().orElse(null);
        if(libraryItem==null){
            throw new ItemNotFoundException("Item Not Found, please try different ID!");
        }
        return libraryItem;
    } // replace void 

    public Client getClient(int id) throws ClientNotFoundException{
        /*for (Client client : clients) {
            if(client.getID()==id){
                return client;
            }
        }*/
        Client client = clients.stream().filter(c -> c.getID() == id).findFirst().orElse(null);
        if(client!=null){
            return client;
        }
        throw new ClientNotFoundException("Client Not Found, please try different ID!");
        
    }

    public void displayAllItems() throws EmptyListException{
        if(items.isEmpty() || items==null){
            throw new EmptyListException("No Items in the Library");
        }
        //System.out.println("rererererere");
        for (LibraryItem libraryItem : items) {
            libraryItem.getItemDetails();    
        }
    }

    public void displayAllClients() throws EmptyListException{
        if(clients.isEmpty() || clients==null){
            throw new EmptyListException("No Clients in the Library");
        }
        //System.out.println("rerererererreerer");
        for (Client c : clients){
            //System.out.print("here");
            c.getClientDetails();    
        }
    }
    /*public void updateItem(int id, String title) throws ItemNotFoundException{
        LibraryItem item = getItem(id);
        item.title=title;
    }*/
    /*public void updateItem(int id, String title, String date) throws ItemNotFoundException{
        Magazine m = (Magazine)getItem(id);
        m.setTitle(title);
        m.setPublcationDate(date);
    }*/

    public void updateItem(int id, String title, int num, String str) throws ItemNotFoundException{
        LibraryItem item = getItem(id);
        if(item instanceof Magazine){
            Magazine m = (Magazine)item;
            m.setTitle(title);
            m.setIssueNumber(num);
            m.setPublcationDate(str);
        }else if(item instanceof Book){
            Book b = (Book)item;
            b.setTitle(title);
            b.setNoOfPages(num);
            b.setAuthor(str);
        }
    }
    public void updateClient(int id, String name, String email) throws ClientNotFoundException{
        Client c = getClient(id);
        c.setName(name);
        c.setEmail(email);
    }

    boolean isDuplcateClientID(int id){
        for (Client client : clients) {
            if(client.getID()==id){
                return true;
            }
        }
        return false;
    }

    boolean isDuplicateItemID(int id){
        for (LibraryItem libraryItem : items) {
            if(libraryItem.id==id){
                return true;
            }
        }
        return false;
    }

    public void deleteItem(int id) throws ItemNotFoundException{
        for (LibraryItem libraryItem : items) {
            if(libraryItem.id==id){
                if(libraryItem.isBorrowed){
                    System.out.println("Item is borrowed, return it first!");
                    return;
                }
                items.remove(libraryItem);
                System.out.println("Item Deleted Successfully!");

                return;
            }
        }
        throw new ItemNotFoundException("Item Not Found, double check it!");

    }

    public void deleteClient(int id) throws ItemNotFoundException{
        for (Client client : clients) {
            if(client.getID()==id){
                if(client.getBorrowedItems().size()>0){
                    System.out.println("Client has borrowed items, return them first!");
                    return;
                }
                clients.remove(client);
                System.out.println("Client Deleted Successfully!");

                return;
            }
        }
        throw new ItemNotFoundException("Client Not Found, double check it!");
    }

    public void borrowItem(int clientID, int itemID) throws ClientNotFoundException, ItemNotFoundException{
        System.out.println("Borrow Item in LIBRARY");
        Client c = getClient(clientID);
        LibraryItem item = getItem(itemID);
        if(item.isBorrowed){
            System.out.println("Item is already borrowed!");
        }else{
            item.isBorrowed=true;
            c.borrowItem(item);
            System.out.println("Item borrowed successfully!");
        }
    }

    public void showBorrowedItems(int clientID) throws ClientNotFoundException{
        Client c = getClient(clientID);
        System.out.println("Borrowed Items: ");
        for (LibraryItem libraryItem : c.getBorrowedItems()) {
            libraryItem.getItemDetails();
        }
    }

    public void returnItem(int clientID, int itemID) throws ClientNotFoundException, ItemNotFoundException{
        Client c = getClient(clientID);
        LibraryItem item = getItem(itemID);
        if(c.getBorrowedItems().contains(item)){
            c.returnItem(item);
            item.isBorrowed=false;
            System.out.println("Item returned successfully!");
        }else{
            System.out.println("Item not borrowed by this client!");
        }
    }
}

/*/ --> ? extends LibraryItem: This means the list can hold any subclass of LibraryItem, but you don't know the exact type. You can read from it, 
        but you cannot safely add elements to it because the exact type is unknown.
    --> T extends LibraryItem: This means you know that T is a subclass of LibraryItem, and you can safely add objects of type T to the list. */
