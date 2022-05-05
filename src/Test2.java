import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. 基本图形编程：编写一个程序，实现一个简单的计算器界面，为该计算器加上适当的事件处理，完成计算功能。
 * 3. Java网络编程：使用socket编写客户方和服务器方之间的通讯的程序，实现Server与Client之间的数据交换。
 */

public class Test2 {
    public JFrame jFrame;

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.setJFrame();
    }

    void setJFrame() {
        jFrame = new JFrame("计算器");
        Container container = jFrame.getContentPane();
//       显示区域
        JTextField textField = new JTextField("0");
        textField.setPreferredSize(new Dimension(900, 50));
        textField.setFont(new Font("宋体", Font.PLAIN, 25));
//        键盘
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 4, 12, 16)); // 左右上下间隔

        JButton clear = new JButton("清除");
        clear.setFont(new Font("宋体", Font.PLAIN, 30));
        StringBuffer strB = new StringBuffer();
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.delete(0, strB.length());
                textField.setText("0");
            }
        });
        JButton btn0 = new JButton("0");
        btn0.setFont(new Font("宋体", Font.PLAIN, 30));
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("0");
                textField.setText(strB.toString());
            }
        });
        JButton btn1 = new JButton("1");
        btn1.setFont(new Font("宋体", Font.PLAIN, 30));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("1");
                textField.setText(strB.toString());
            }
        });

        JButton btn2 = new JButton("2");
        btn2.setFont(new Font("宋体", Font.PLAIN, 30));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("2");
                textField.setText(strB.toString());
            }
        });

        JButton btn3 = new JButton("3");
        btn3.setFont(new Font("宋体", Font.PLAIN, 30));
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("3");
                textField.setText(strB.toString());
            }
        });

        JButton btn4 = new JButton("4");
        btn4.setFont(new Font("宋体", Font.PLAIN, 30));
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("4");
                textField.setText(strB.toString());
            }
        });
        JButton btn5 = new JButton("5");
        btn5.setFont(new Font("宋体", Font.PLAIN, 30));
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("5");
                textField.setText(strB.toString());
            }
        });
        JButton btn6 = new JButton("6");
        btn6.setFont(new Font("宋体", Font.PLAIN, 30));
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("6");
                textField.setText(strB.toString());
            }
        });

        JButton btn7 = new JButton("7");
        btn7.setFont(new Font("宋体", Font.PLAIN, 30));
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("7");
                textField.setText(strB.toString());
            }
        });

        JButton btn8 = new JButton("8");
        btn8.setFont(new Font("宋体", Font.PLAIN, 30));
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("8");
                textField.setText(strB.toString());
            }
        });

        JButton btn9 = new JButton("9");
        btn9.setFont(new Font("宋体", Font.PLAIN, 30));
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("9");
                textField.setText(strB.toString());
            }
        });

        JButton btn10 = new JButton("+");
        btn10.setFont(new Font("宋体", Font.PLAIN, 30));
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("+");
                textField.setText(strB.toString());
            }
        });

        JButton btn11 = new JButton("-");
        btn11.setFont(new Font("宋体", Font.PLAIN, 30));
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("-");
                textField.setText(strB.toString());
            }
        });

        JButton btn12 = new JButton("*");
        btn12.setFont(new Font("宋体", Font.PLAIN, 30));
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("*");
                textField.setText(strB.toString());
            }
        });

        JButton btn13 = new JButton("/");
        btn13.setFont(new Font("宋体", Font.PLAIN, 30));
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("/");
                textField.setText(strB.toString());
            }
        });

        JButton btn14 = new JButton("=");
        btn14.setFont(new Font("宋体", Font.PLAIN, 30));
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("=");
                textField.setText("");
                double res = solution(strB.toString());
                String resStr = String.valueOf(res);
                strB.delete(0, strB.length());
                strB.append(resStr);
                textField.setText(resStr);

            }
        });
        JButton btn15 = new JButton(".");
        btn15.setFont(new Font("宋体", Font.PLAIN, 30));
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append(".");
                textField.setText(strB.toString());
            }
        });

        JButton left = new JButton("(");
        left.setFont(new Font("宋体", Font.PLAIN, 30));
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append("(");
                textField.setText(strB.toString());
            }
        });
        JButton right = new JButton(")");
        right.setFont(new Font("宋体", Font.PLAIN, 30));
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strB.append(")");
                textField.setText(strB.toString());
            }
        });


        jPanel.add(btn0);
        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        jPanel.add(btn10);
        jPanel.add(btn11);
        jPanel.add(btn12);
        jPanel.add(btn13);
        jPanel.add(btn14);
        jPanel.add(btn15);
        jPanel.add(clear);
        jPanel.add(left);
        jPanel.add(right);

        container.add(textField, BorderLayout.NORTH);
        container.add(jPanel, BorderLayout.SOUTH);
        jFrame.setSize(1000, 1000);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*优先级*/
    static int checkPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    /*计算*/
    static double calculationNumbers(char opt, double num1, double num2) {
        switch (opt) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }

        return 0.0;
    }

    /*流程处理*/
    static double solution(String str) {

        // 处理云算符连续输入
        Pattern r = Pattern.compile("(\\*|-|=|\\+|\\/)\\D.*");
        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);

        if (m.find()) {
            return 0;
        }
        Stack<Double> numStack = new Stack<>();
        Stack<Character> signalStack = new Stack<>();
        int index = 0;// 记录已经执行的符号数
        int len = str.length();
        while (index < len) {
            char c = str.charAt(index); // 取出这一步的符号
            if (c == '(') {
                signalStack.push(c);// 若是左括号就进栈
            }
            // 否则要先判断优先级
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int currOperLevel = checkPriority(c);// 当前符号的优先级
                while (true) {
                    int stackOperLevel = 0;// 栈顶元素的优先级
                    if (!signalStack.isEmpty()) {
                        Object obj = signalStack.peek();
                        stackOperLevel = checkPriority((char) obj);
                    }
                    // 若当前元素优先级大于栈顶元素的优先级则入栈
                    if (currOperLevel > stackOperLevel) {
                        signalStack.push(c);
                        break;// 直到让比自己优先级高的符号都出栈运算了再把自己进栈
                    } else {// 不能入栈就进行计算
                        try {
                            char optemp = '0';
                            double num1 = 0;
                            double num2 = 0;
                            if (!signalStack.isEmpty()) {
                                optemp = (char) signalStack.pop();// 取出优先级大的那个符号
                            }
                            if (!numStack.isEmpty()) {
                                num1 = (double) numStack.pop();
                                num2 = (double) numStack.pop();// 取出数据栈中的两个数
                            }
                            numStack.push(calculationNumbers(optemp, num2, num1));// 将算出来的结果数据再次进入数据栈
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }
            } else if (c == ')') {// 右括号就返回栈顶元素，右括号是不进栈的
                while (true) {
                    char theop = (char) signalStack.pop();
                    if (theop == '(') {
                        break;
                    } else {
                        try {
                            double num1 = (double) numStack.pop();
                            double num2 = (double) numStack.pop();
                            numStack.push(calculationNumbers(theop, num2, num1));// 运算括号内的内容
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (c >= '0' && c <= '9') {
                int tempIndex = index + 1;
                while (tempIndex < len) {
                    char temp = str.charAt(tempIndex);// 取字符串中处于当前字符的下一位
                    if ((temp >= '0' && temp <= '9') || temp == '.') {
                        tempIndex++;// 若为数字则继续向后取
                    } else {
                        break;// 证明数字去完
                    }
                }
                String numstr = str.substring(index, tempIndex);// 截取这个字符串则为两个符号之间的数字
                try {
                    double numnum = Double.parseDouble(numstr);// 将数字转换成整型便于运算
                    numStack.push(numnum);
                    index = tempIndex - 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            index++;
        }
        // 检查符号栈是否为空
        while (true) {
            Object obj = null;
            if (signalStack.isEmpty() == false) {
                obj = signalStack.pop();
            }
            if (obj == null) {
                break;// 为空证明运算已结束
            } else {// 不为空就出栈运算
                char optTemp = (char) obj;
                double num1 = (double) numStack.pop();
                double num2 = (double) numStack.pop();
                numStack.push(calculationNumbers(optTemp, num2, num1));
            }
        }
        double result = 0;
        try {
            result = (double) numStack.pop();
        } catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }
        return result;
    }

}

