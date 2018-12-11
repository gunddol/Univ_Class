package kr.co.Assign.Collection;

public class Member {
    public String name;
    public String p_number;
    public String address;
    public Book[] borrowingBooks = new Book[3];
    public Book _reset;

    public  Member(String name, String p_number, String address){
        this.name = name;
        this.p_number = p_number;
        this.address = address;
    }

    public int getBookCount(){
        int i,cnt=0;
        for(i=0;i<3;i++){
            if(!borrowingBooks[i].name.equals("")) cnt++;
        }
        return cnt;
    }

    public boolean addBook(Book book){
        int i;
        for(i=0;i<3;i++){
            if(borrowingBooks[i].name.equals("")){
                borrowingBooks[i] = book;
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book book){
        int i;
        for(i=0;i<3;i++){
            if(borrowingBooks[i].name.equals(book.name)){
                _reset = new Book("",0,"");
                borrowingBooks[i] = _reset;
                return true;
            }
        }
        return false;
    }


    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }



    public String getP_number(){
        return this.p_number;
    }
    public void setP_number(String p_number){
        this.p_number = p_number;
    }


    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}