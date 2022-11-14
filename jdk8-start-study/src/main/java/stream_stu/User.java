package stream_stu;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 伍六七
 * @date 2022/11/7 13:35
 */
@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer age;
    private String sex;
}
