package swing_stu;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 *
 */
public class SystemIconDemo extends JFrame {
    public SystemIconDemo() {
        super("My Frame"); // 设置窗口标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭按钮的默认操作
        setSize(300, 300); // 设置窗口大小

        FileSystemView fsv = FileSystemView.getFileSystemView();
        Icon icon = fsv.getSystemIcon(new File("F:\\study\\java_study\\Java-start-study\\jdk17-start-study\\demo.png"));
        JLabel jLabel = new JLabel(icon);
        add(jLabel); // 将标签添加到窗口中
    }

    public static void main(String[] args) {
        SystemIconDemo frame = new SystemIconDemo(); // 创建窗口对象
        frame.setVisible(true); // 显示窗口
    }
}
