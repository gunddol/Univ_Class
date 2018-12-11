public class Program {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student[] students = new Student[5];

        Student stu1 = new Student("Lim", 3.8);
        Student stu2 = new Student("Lee", 3.2);
        Student stu3 = new Student("Song", 4.2);
        Student stu4 = new Student("Sun", 4.5);
        Student stu5 = new Student("So", 3.5);

        students[0] = stu1;
        students[1] = stu2;
        students[2] = stu3;
        students[3] = stu4;
        students[4] = stu5;

        students = nameSort(students);
        printStudents(students);
        students = scoreSort(students);
        printStudents(students);
    }

    private static void printStudents(Student[] students)
    {
        for(int i=0; i<students.length; i++)
        {
            System.out.println((i+1)+"번째 학생");
            System.out.println("이름 : " + students[i].getName());
            System.out.println("학점 : " + students[i].getScore());
            System.out.println("--------------------");
        }
    }

    private static Student[] scoreSort(Student[] students){
        int i,j;
        Student tmp;
        for(i=0;i<students.length-1;i++) {
            for(j=i+1;j<students.length;j++){
                if(students[i].getScore() > students[j].getScore()){
                    tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
            }
        }
        System.out.println("---학점순으로 오름차순 정렬---");
        return students;
    }

    private static Student[] nameSort(Student[] students){
        int i,j;
        Student tmp;

        for(i=0;i<students.length-1;i++) {
            for(j=i+1;j<students.length;j++){
                if(isBigString(students[i].getName(),students[j].getName()) == 1){
                    tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
            }
        }
        System.out.println("---이름순으로 오름차순 정렬---");
        return students;
    }

    private static int isBigString(String a, String b){
        int length = a.length() < b.length() ? a.length() : b.length();
        int i,cnt=0;
        char ac[]=a.toCharArray(),bc[]=b.toCharArray();

        while(cnt < length) {
            if(ac[cnt] > bc[cnt]) return 1;
            else if(ac[cnt] == bc[cnt]) cnt++;
            else return -1;
        }

        if(a.length() == b.length()) return 0;
        else if(a.length() > b.length()) return 1;

        //두 문자열을 비교하여 a의 값이 더 클 경우, return 1;
        //b가 더 클 경우, return -1;
        //두 문자열이 완전히 동일할 경우, return 0;
        //만약, a=Lim / b=Limfd 일 경우, return -1;

        return -1;
    }
}

