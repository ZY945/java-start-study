package study.stu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 伍六七
 * @date 2022/9/12 10:28
 */
public class selectStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("学号             名称              年龄  班级");
        list.add(new Student(20180302,  "叶孤城",  23,  "护理一班"));
        list.add(new Student(20180303,  "东方不败", 23,  "推拿二班"));
        list.add(new Student(20180304,  "西门吹雪", 26,  "中药学四班"));
        list.add(new Student(20180305,  "梅超风",  26, "神经科2班"));
        for (Student s : list){
            if(s.getName().length()==4){
                System.out.println(s.getId()+"        "+s.getName()+"           "+s.getAge()+"  "+s.getStuClass());
            }else if(s.getName().length()==3){
                System.out.println(s.getId()+"        "+s.getName()+"             "+s.getAge()+"  "+s.getStuClass());
            }
        }
        System.out.println("输入查询id");
        while(scanner.hasNext()){
            System.out.println("输入查询id");
            int id = scanner.nextInt();
            select(list,id);
        }
    }
    public static void select(ArrayList<Student> list, Integer id){
        for (Student s : list){
            if(s.getId()==id){
                System.out.println(s.getId()+"        "+s.getName()+"           "+s.getAge()+"  "+s.getStuClass());
                break;
            }
        }
    }
}
