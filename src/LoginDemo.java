import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

//书写登陆页面
public class LoginDemo extends JFrame{//需要继承JFrame

        private String username="1";//用户名以及密码
        private String password="1";
        //设置窗口
        public JFrame window;
        //用户名、密码、文本框
        public JTextField user;//JTextField 运行编辑单行文本
        public JPasswordField pwd;
        //登陆按钮
        public JButton login;
        public JButton zhuche;

        public LoginDemo(){
            //面板初始化
            JFrame window = new JFrame("学生管理系统");//登陆主页面
           //设置窗口图标

           //设置尺寸大小
            window.setSize(600,420);
            //居中显示
            window.setLocationRelativeTo(null);
            //默认可关闭
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置为绝对布置
           window.setLayout(null);
            //设置窗口不可变换
            window.setResizable(false);
            //window.setBackground(Color.blue);


            //用户
            JLabel username_label =new JLabel("用户");//创建一个标签，设置初始内容
            username_label.setBounds(150,100,100,50);//设置框大小
            username_label.setFont(new Font("宋体",Font.BOLD,16));
            window.add(username_label);

            user =new JTextField();
            user.setBounds(200,100,250,50);
            window.add(user);

            //密码
            JLabel password =new JLabel("密码");
            password.setBounds(150,200,100,50);
            password.setFont(new Font("宋体",Font.BOLD,16));
            window.add(password);

            pwd =new JPasswordField();
            pwd.setBounds(200,200,250,50);
            window.add(pwd);

            //按钮
            login=new JButton("登陆");
            login.setBounds(190,300,80,50);
            login.setFont(new Font("宋体",Font.BOLD,16));
            window.add(login);
             check();

             zhuche =new JButton("注册");
             zhuche.setBounds(350,300,80,50);
             zhuche.setFont(new Font("宋体",Font.BOLD,16));
             window.add(zhuche);

            //设置面板可见

            window.setVisible(true);


        }

 public void check(){
            //登陆按钮的监听器
         login.addActionListener(new ActionListener() {//利用ActionListener监听动作
            //当鼠标被按下此方法会被调用
             @Override
             public void actionPerformed(ActionEvent e) {//通过ActionListener中的actionPerformed中定义相应方法
                   System.out.println(user.getText());
                   System.out.println(pwd.getText());
                   //判断用户密码
                 if (user.getText().equals(username)&&pwd.getText().equals(password)){
                     //提示登陆成功，返回登陆成功的页面
                     JOptionPane.showMessageDialog(null, "登陆成功!", "登陆提示框",JOptionPane.WARNING_MESSAGE);
                     StudentShow1 sp=new StudentShow1();
                     //window.dispose();//成功关闭窗口
                     //window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     this.setVisible(false);

                 }else{
                     //密码错误，返回登陆失败框
                     //JOptionPane.showMessageDialog(null, "登陆失败!\n账户或密码错误", "登陆提示框",JOptionPane.WARNING_MESSAGE);
                     JOptionPane.showMessageDialog(null, "登陆失败.", "登陆提示框",JOptionPane.ERROR_MESSAGE);
                     //弹出登陆页面 重新登陆
                     user.setText(null);
                     pwd.setText(null);
                 }
             }

             private void setVisible(boolean b) {
             }
         });




 }


        public static void main(String[] args){

            new LoginDemo();//创建窗口

           try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }catch(Exception e) {
                System.out.println(e);
            }


        }

    }


