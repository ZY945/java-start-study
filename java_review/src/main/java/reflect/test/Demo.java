package reflect.test;

import java.util.Objects;

/**
 * @author 伍六七
 * @date 2023/8/25 15:35
 */
public class Demo {
    private int id;
    public String demoField;

    public Demo() {
    }

    public Demo(String demoField) {
        this.demoField = demoField;
    }

    public String get() {
        return "get方法";
    }
    public String post(int id) {
        return "post方法"+id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return id == demo.id && Objects.equals(demoField, demo.demoField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, demoField);
    }
}
