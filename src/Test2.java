import javax.swing.*;

/**
 * 2. 基本图形编程：编写一个程序，实现一个简单的计算器界面，为该计算器加上适当的事件处理，完成计算功能。
 * 3. Java网络编程：使用socket编写客户方和服务器方之间的通讯的程序，实现Server与Client之间的数据交换。
 */

public class Test2 {
    public JFrame jFrame;

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.setjFrame();
    }

    void setjFrame() {
        jFrame = new JFrame("计算器");
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

