package text_stu;

/**
 * @author 伍六七
 * @date 2023/6/5 13:17
 */
public class TextCode {
    public static void main(String[] args) {
        String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
                """;
        System.out.println(html);
        //不需要\n了
        //jdk8
//        String html = "<html>\n" +
//                "<body>\n" +
//                "<p>Hello, world</p>\n" +
//                "</body>\n" +
//                "</html>";
    }
}
