public class Magazine extends LibraryItem{
    private
        int issueNumber;
        String publcationDate;

    public Magazine(){
        id=0;
        issueNumber=0;
        title=null;
        publcationDate=null;
    }
    
    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublcationDate() {
        return publcationDate;
    }

    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    } 

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public void setPublcationDate(String publcationDate) {
        this.publcationDate = publcationDate;
    }

    public void setID(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }

    @Override
    public void  getItemDetails(){
        super.getItemDetails();
        System.out.println( " Issue Number: " + this.issueNumber + " Publication Date: "+this.publcationDate);    
    }
}
