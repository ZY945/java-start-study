package study.stu;

/**
 * @author 伍六七
 * @date 2022/9/12 10:27
 */
public class Student {
    private int id;
    private String Name;
    private int age;
    private String StuClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuClass() {
        return StuClass;
    }

    public void setStuClass(String stuClass) {
        StuClass = stuClass;
    }

    public Student() {
    }

    public Student(int id, String name, int age, String stuClass) {
        this.id = id;
        Name = name;
        this.age = age;
        StuClass = stuClass;
    }
}
