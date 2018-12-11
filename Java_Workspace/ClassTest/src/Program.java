public class Program {
    public static void main(String[] args)
    {
        User user = new User("홍길동", "의적", 19);
        user.showInfo();
        user.changeJob("백수");

        System.out.println("직업이 " + user.getJob() + "로 변경되었습니다.");
        user.showInfo();
    }
}
