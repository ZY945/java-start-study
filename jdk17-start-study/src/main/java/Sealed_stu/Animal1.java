package Sealed_stu;


/**
 * @author 伍六七
 * @date 2023/5/31 16:58
 * sealed修饰的类限制继承的子类范围,同时子类必须是final类型<br/>
 * 密封类和接口限制了哪些其他类或接口可以扩展或实现它们。<br/>
 * <a href="https://openjdk.org/jeps/409">JEP 409：密封类(JDK-8260514)</a>
 */
public sealed class Animal1 permits Cat1, Dog1 {
    // ...

}

//public sealed interface Animal2 permits Cat2, Dog2 {
//    // ...
//    void stat();
//}

