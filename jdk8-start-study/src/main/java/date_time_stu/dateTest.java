package date_time_stu;


import java.time.*;

/**
 * @author 伍六七
 * @date 2022/11/8 9:56
 */
public class dateTest {
    public static void main(String[] args) {
        dateTest java8tester = new dateTest();
        java8tester.testLocalDateTime();
        java8tester.testZonedDateTime();

    }
    public void testLocalDateTime(){

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("LocalDateTime.now()-当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("currentTime.toLocalDate()-年月日: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("自定义年月，其他按本地时间: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("自定义格式年月日: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("自定义格式年月日时分: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("LocalTime.parse(\"20:15:30\")解析字符串: " + date5);
    }
    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
