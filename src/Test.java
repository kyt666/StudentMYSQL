import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame implements ActionListener {
    JTextField jtf;//文本框
    JButton jbt;//按钮

    public Test() {
        jtf = new JTextField(8);//文本框的初始化
        jbt = new JButton("按钮");//按钮的初始化
        jbt.addActionListener(this);//给按钮响应点击事件
        add(jtf);
        add(jbt);
        setLayout(new FlowLayout());
        setTitle("测试");
        setSize(300, 150);
        setLocationRelativeTo(null);//窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//窗口可见
    }

    //重点: 重点是实现actionPerformed的方法
    public void actionPerformed(ActionEvent e) {
        if (jbt == e.getSource()) {//如果是jbt这个按钮被点击了,
            String str = jbt.getText();//那么取得按钮上的文字,
            jtf.setText(str);//把按钮的文字显示到文本框中.
        }
    }

    public static void main(String[] args) {
        new Test(); // 创建窗口实例
    }

}