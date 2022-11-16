package collection.collection_s.set_s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author 伍六七
 * @date 2022/8/12 21:47
 */
public class set_demo {
    //方法：全部继承自Collection中的方法
    //增、删、遍历、判断与collection一致


    //自定义对象需要重写hashcode和equals
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1));
        set.add(new Student(1));
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}

class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    private int id;

    public Student(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student) {
            Student student = (Student) o;
            return this.id == student.id;
        }else {
            return false;
        }
    }
}
