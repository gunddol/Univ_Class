public class User {
    private String name;
    private String job;
    private int old;
    public User(String name, String job, int old) {
        this.name = name;
        this.job = job;
        this.old = old;
    }
    public void showInfo() {
        System.out.println("이름 : " + this.name);
        System.out.println("직업 : " + this.job);
        System.out.println("나이 : " + this.old);
    }
    public void changeJob(String next_job){
        this.job = next_job;
    }
    public String getJob(){
        return this.job;
    }


}
