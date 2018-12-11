import java.util.Scanner;
import kr.co.Assign.Collection.*;

public class Library {

    Scanner scan;
    private Book[] books;
    private Member[] members;
    public int m_num=0,b_num=0;
    private Member reset;
    private Book b_reset;

    public Library(){
        scan = new Scanner(System.in);
        books = new Book[10];
        members = new Member[10];
    }

    public void run(){
        int select = -1;

        while(select != 0){
            printMenu();
            select = insertMenu();

            switch(select){
                case 0: exit(); break;
                case 1: borrowBook(); break;
                case 2: returnBook(); break;
                case 3: addBook(); break;
                case 4: editBook(); break;
                case 5: searchBook(); break;
                case 6: addMember(); break;
                case 7: editMember(); break;
                case 8: searchMember(); break;
                default: System.out.println("잘못입력하셨습니다.");
            }
        }
    }

    private void printMenu(){
        System.out.println("---------도서 관리 프로그램---------");
        System.out.println("1. 대여하기");
        System.out.println("2. 반납하기");
        System.out.println("3. 도서 추가");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 검색");
        System.out.println("6. 회원 추가");
        System.out.println("7. 회원 수정");
        System.out.println("8. 회원 검색");
        System.out.println("0. 종료하기");
        System.out.println("-------------------------------");
    }

    private void exit(){
        System.out.println("프로그램을 종료합니다.");
    }

    private int insertMenu(){
        System.out.print("입력 : ");
        return scan.nextInt();
    }

    private void borrowBook(){
        System.out.print("대출하실 회원 이름 입력 : ");
        String _name = scan.next();
        if(memberexist(_name)){
            int i,index=0;
            for(i=0;i<m_num;i++) if(members[i].name.equals(_name)) index = i;
            if(members[index].getBookCount() == 3)
                System.out.println("이미 3권의 책을 대여했습니다.");
            else{
                System.out.print("빌리실 도서명을 입력 : ");
                _name = scan.next();
                if(bookexist(_name)){
                    //도서 대출중인지 확인, 대출중이면 종료
                    int book_index=0;
                    for(i=0;i<b_num;i++) if(books[i].name.equals(_name)) book_index = i;
                    if(books[book_index].getBorrowerName() == ""){
                        members[index].addBook(books[book_index]);
                        books[book_index].setBorrower(members[index]);
                        System.out.println("책을 대여하였습니다.");
                    }else{
                        System.out.println("이미 대여 중인 도서입니다.");
                    }
                }else{
                    System.out.println("해당 이름을 가진 도서가 없습니다.");
                }
            }

        }else
            System.out.println("회원등록을 먼저 해주십시오.");
    }

    private void returnBook(){
        System.out.print("반납하시는 회원명 : ");
        String _name = scan.next();
        if(memberexist(_name)) {
            int i,index=0;
            for(i=0;i<m_num;i++) if(members[i].name.equals(_name)) index = i;
            System.out.print("반납하실 도서명 : ");
            _name = scan.next();
            if(members[index].borrowingBooks[0].name.equals(_name) || members[index].borrowingBooks[1].name.equals(_name) || members[index].borrowingBooks[2].name.equals(_name)){
                int book_index=0;
                for(i=0;i<b_num;i++) if(books[i].name.equals(_name)) book_index = i;
                members[index].returnBook(books[book_index]);
                reset = new Member("","","");
                books[book_index].setBorrower(reset);
                System.out.println("책을 반납하였습니다.");
            }else{
                System.out.println("현재 대출중인 도서가 아닙니다.");
            }
        }else{
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }

    private void addBook(){
        if(b_num == 10){
            System.out.println("이미 10권의 도서가 존재합니다.");
        }else {
            System.out.print("도서이름 입력 : ");
            String _name = scan.next();
            if(bookexist(_name))
                System.out.println("이미 존재하는 도서입니다.");
            else{
                System.out.print("도서 카테고리 입력 : ");
                String _category = scan.next();
                System.out.print("도서 가격 입력 : ");
                int _price = scan.nextInt();
//                books[b_num].setName(_name);
//                books[b_num].setPrice(_price);
//                books[b_num].setCategory(_category);
                books[b_num] = new Book(_name, _price, _category);
                b_num++;
                System.out.println("책을 추가하였습니다.");
            }
        }
    }
    private void editBook(){
        int i,book_index=0;
        System.out.print("수정 하실 도서명을 입력 : ");
        String _name = scan.next();
        if(bookexist(_name)){
            for(i=0;i<b_num;i++) if(books[i].name.equals(_name)) book_index = i;
            //System.out.println(books[book_index].getBorrowerName());
            if(books[book_index].getBorrowerName() == "") {
                System.out.print("새로운 도서명 입력 : ");
                _name = scan.next();
                System.out.print("새로운 도서 카테고리 입력 : ");
                String _category = scan.next();
                System.out.print("도서 가격 입력 : ");
                int _price = scan.nextInt();
                books[book_index].setName(_name);
                books[book_index].setPrice(_price);
                books[book_index].setCategory(_category);
                System.out.println("책을 수정하였습니다.");
            }else{
                System.out.println("대여 중인 도서이므로 수정이 불가능합니다.");
            }
        }else{
            System.out.println("해당 도서가 존재하지 않습니다.");
        }
    }
    private void searchBook(){
        int i,cnt=0,index=0;
        System.out.println("검색 방법을 선택해 주십시오.[1)이름으로 검색 / 2)카테고리로 검색]");
        int select = scan.nextInt();
        switch (select){
            case 1:
                System.out.print("검색할 도서명 입력 : ");
                String _name = scan.next();
                if(bookexist(_name)){
                    for(i=0;i<b_num;i++) if(books[i].name.equals(_name)) index = i;
                    print_book(index);
                    System.out.println("책을 검색하였습니다.");
                }else{
                    System.out.println("해당 도서가 존재하지 않습니다.");
                }
                break;
            case 2:
                System.out.print("검색할 카테고리 입력 : ");
                _name = scan.next();
                for(i=0;i<b_num;i++){
                    if(books[i].getCategory().equals(_name)) {cnt++;index=i;}
                }
                if(cnt != 0){
                    print_book(index);
                    System.out.println("책을 검색하였습니다.");
                }else{
                    System.out.println("해당 도서가 존재하지 않습니다.");
                }
                break;
             default: break;
        }
    }

    private void addMember(){
        if(m_num == 10){
            System.out.println("이미 10명의 회원이 존재합니다.");
        }else {
            System.out.print("회원이름을 입력하세요. : ");
            String _name = scan.next();
            if(memberexist(_name))
                System.out.println("이미 존재하는 회원입니다.");
            else{
                System.out.print("회원전화번호를 입력하세요. : ");
                String _p_number = scan.next();
                System.out.print("회원주소를 입력하세요. : ");
                String _address = scan.next();
//                members[m_num].setName(_name);
//                members[m_num].setP_number(_p_number);
//                members[m_num].setAddress(_address);
                members[m_num] = new Member(_name,_p_number,_address);
                b_reset = new Book("",0,"");
                //회원 생성시 빌린도서 초기화
                members[m_num].borrowingBooks[0] = b_reset;
                members[m_num].borrowingBooks[1] = b_reset;
                members[m_num].borrowingBooks[2] = b_reset;
                m_num++;
                System.out.println("회원을 추가하였습니다.");
            }
        }
    }

    private void editMember(){
        int i,cnt=0,index=0;

        System.out.print("수정 하실 회원이름을 입력하세요 : ");
        String _name = scan.next();
        for(i=0;i<m_num;i++){
            if(members[i].getName().equals(_name)) {cnt++;index = i;}
        }
        if(cnt == 0)
            System.out.println("해당 회원이 존재하지 않습니다.");
        else {
            System.out.print("새로운 회원이름을 입력하세요 : ");
            _name = scan.next();
            if(memberexist(_name))
                System.out.println("이미 존재하는 회원입니다.");
            else{
                System.out.print("새로운 회원전화번호를 입력하세요. : ");
                String _p_number = scan.next();
                System.out.print("새로운 회원주소를 입력하세요. : ");
                String _address = scan.next();
                members[index].setName(_name);
                members[index].setP_number(_p_number);
                members[index].setAddress(_address);
                System.out.println("회원을 수정하였습니다.");
            }
        }
    }
    private void searchMember(){
        int i,cnt=0,index=0;
        System.out.println("검색 방법을 선택해 주십시오.[1)이름으로 검색 / 2)전화번호로 검색 / 3)주소로 검색]");
        int select = scan.nextInt();
        switch (select){
            case 1:
                System.out.print("검색할 회원명 입력 : ");
                String _name = scan.next();
                if(memberexist(_name)){
                    for(i=0;i<m_num;i++) if(members[i].name.equals(_name)) index = i;
                    print_member(index);
                    System.out.println("회원을 검색하였습니다.");
                }else{
                    System.out.println("해당 회원이 존재하지 않습니다.");
                }
                break;
            case 2:
                System.out.print("검색할 전화번호 입력 : ");
                _name = scan.next();
                for(i=0;i<m_num;i++){
                    if(members[i].getP_number().equals(_name)) {cnt++;index=i;}
                }
                if(cnt != 0){
                    print_member(index);
                    System.out.println("회원을 검색하였습니다.");
                }else{
                    System.out.println("해당 회원이 존재하지 않습니다.");
                }
                break;
            case 3:
                System.out.print("검색할 주소 입력 : ");
                _name = scan.next();
                for(i=0;i<m_num;i++){
                    if(members[i].getAddress().equals(_name)) {cnt++;index=i;}
                }
                if(cnt != 0){
                    print_member(index);
                    System.out.println("회원을 검색하였습니다.");
                }else{
                    System.out.println("해당 회원이 존재하지 않습니다.");
                }
                break;
            default: break;
        }
    }

    private boolean memberexist(String name){
        int i,cnt=0;
        for(i=0;i<m_num;i++){
            if(members[i].getName().equals(name)) cnt++;
        }
        if(cnt == 0) return false; //존재하지 않음
        else return true; //존재함
    }
    private boolean bookexist(String name){
        int i,cnt=0;
        for(i=0;i<b_num;i++){
            if(books[i].getName().equals(name)) cnt++;
        }
        if(cnt == 0) return false;
        else return true;
    }

    private void print_member(int index){
        System.out.println("회원명 : " + members[index].getName());
        System.out.println("전화번호 : " + members[index].getP_number());
        System.out.println("회원주소 : " + members[index].getAddress());
    }
    private void print_book(int index){
        System.out.println("도서명 : " + books[index].getName());
        System.out.println("카테고리 : " + books[index].getCategory());
        System.out.println("도서가격 : " + books[index].getPrice());
    }
}
