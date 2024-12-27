public class Book extends LibraryItem{
    private
        String author;
        int noOfPages;

    public Book(){
        super();
        author=null;
        noOfPages=0;
    }

    @Override
    public void getItemDetails(){
        super.getItemDetails();
        System.out.println(" Author: " + this.author + " Number of Pages: "+this.noOfPages);
    }

    public void setID(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getNoOfPages() {
        return this.noOfPages;
    }

    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }    

    
}
