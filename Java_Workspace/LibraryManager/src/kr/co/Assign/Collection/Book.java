package kr.co.Assign.Collection;

public class Book {
    public String name;
    public int price;
    public String category;
    public Member borrower = new Member("","","");

    public Book(String name, int price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }


    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category = category;
    }


    public String getBorrowerName(){
        if(borrower.name == null) return "";
        else return borrower.name;
    }
    public void setBorrower(Member borrower){
        this.borrower = borrower;
    }
}
