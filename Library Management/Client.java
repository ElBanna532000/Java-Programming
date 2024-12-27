import java.util.ArrayList;
import java.util.List;

public class Client {
    
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;

    public Client(){ 
        id=0;
        name=null;
        email=null;
        borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item){
        System.out.println("Function Borrow Item CLIENT.JAVA");
        if(borrowedItems==null){
            borrowedItems = new ArrayList<>();
        }
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item){
        borrowedItems.remove(item);
    }

    public List<LibraryItem> getBorrowedItems(){
        return borrowedItems;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setID(int id){
        this.id=id;
    }

    public void setName(String name)throws IllegalArgumentException{
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void getClientDetails(){
        System.out.println("ID: " + this.id + " Name: " + this.name + " Email: " + this.email);
    }
}
