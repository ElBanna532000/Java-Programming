public abstract class LibraryItem {
    
    protected int id;
    protected String title;
    protected boolean isBorrowed;

    LibraryItem(){
        this.id=0;
        this.title=null;
        this.isBorrowed=false;
    }
    
    void getItemDetails(){
        System.out.print("ID: " +  this.id + " Title: " + this.title);
    }

}