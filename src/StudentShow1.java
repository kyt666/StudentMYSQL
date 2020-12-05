import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class StudentShow1 {


    public static void main(String[] args) {
        new StudentShow1();
    }

    //声明所需变量
    //主板面
    public JFrame student;
    //p1 添加 p2 查询 p3删改 p4排名 p5优秀率排名 title标题
    private JPanel p1, p2, p3, p4, p5, title;
    //头部标题
    private JTabbedPane tab;
    //容器：一个添加面板 一个储存面板
    private Container container;
    //添加按钮 撤销添加按钮
    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    //标签：姓名 语文成绩 数学成绩 英语成绩
    private JLabel IdLabel, NameLabel, ClassLabel, ChineseLabel, MathLabel, EnglishLabel;
    //姓名 成绩文本框
    private JTextField textId, textName, textClass, textChinese, textMath, textEnglish;
    //修改的标签和文本
    private JLabel DNameLabel, DClassLabel, DChineseLabel, DMathLabel, DEnglishLabel;
    private JTextField DtextName, DtextClass, DtextChinese, DtextMath, DtextEnglish;
    //显示学生信息内容的文本框
    private JTextArea showInsert, showStudent;
    //删除面板内容
    //删除标签
    private JLabel searchLabel3;
    //删除ID文本框
    private JTextField textDeleteID;
    //数据库操作类
    util util = new util();


    //查找
    //查找的标签     l1信息查询  l2
    private JLabel searchLabel1, searchLabel2;
    //确认查找的按钮
    private JButton searchButton;
    //一个为查找信息的文本框 一个为显示信息的文本框
    private JTextField searchText1, searchText2, searchText3, searchText4;
    // resultText-显示添加学生信息 resultStudent-排序面板 resultA-显示优秀率面板
    private JTextArea resultText, resultStudent, resultA;

    //按钮监听类
    Listener l;


    public StudentShow1() {
        //初始化监听器
        l = new Listener();
        //面板初始化

        //设置窗体图标
        JFrame student = new JFrame("学生成绩管理信息系统");


        //设置标题
        tab = new JTabbedPane(JTabbedPane.TOP);
        //设置在student面板上
        container = student.getContentPane();
        //初始化
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        title = new JPanel();

        //第一个添加学生信息面板p1
        //初始化6个标签 学号 姓名 班别 各科成绩
        IdLabel = new JLabel("学号");
        NameLabel = new JLabel("姓名");
        ClassLabel = new JLabel("班别");
        ChineseLabel = new JLabel("语文");
        MathLabel = new JLabel("数学");
        EnglishLabel = new JLabel("英语");
        //初始化6个文本框
        textId = new JTextField(10);
        textName = new JTextField(10);
        textClass = new JTextField(10);
        textChinese = new JTextField(10);
        textMath = new JTextField(10);
        textEnglish = new JTextField(10);
        //初始化5个修改标签 修改文本
        DNameLabel = new JLabel("姓名");
        DClassLabel = new JLabel("班别");
        DChineseLabel = new JLabel("语文");
        DMathLabel = new JLabel("数学");
        DEnglishLabel = new JLabel("英语");

        DtextName = new JTextField(10);
        DtextClass = new JTextField(10);
        DtextChinese = new JTextField(10);
        DtextMath = new JTextField(10);
        DtextEnglish = new JTextField(10);
        //两个按钮
        b1 = new JButton("确认添加");
        b2 = new JButton("查看添加");

        //显示文本框
        showInsert = new JTextArea(20, 65);
        showInsert.setBounds(10, 550, 500, 200);

        //设置面板属性
        student.setSize(1000, 600);
        //设置面板剧中显示
        student.setLocationRelativeTo(null);
        //不用默认布局
        student.setLayout(null);
        //设置窗口不可变
        student.setResizable(false);
        //设置默认可关闭
        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置表头--两个查询以及添加面板
        //tab.add（对象（面板），”面板上显示的内容“）
        tab.add(p1, "成绩输入");
        //p1.setFont(new Font("黑体",Font.BOLD,20));
        tab.add(p2, "成绩查询");

        tab.add(p3, "删除修改学生信息");

        tab.add(p4, "成绩排名");

        tab.add(p5, "优秀率查询");

        title.add(new JLabel("学生成绩管理信息系统"));

        //添加到容器中
        //容器.add(对象，位置)
        //设置布局管理器
        container.setLayout(new BorderLayout());//边界布局

        //顶部
        container.add(title, BorderLayout.NORTH);
        //title.setPreferredSize(new Dimension(0,80));
        //中部
        container.add(tab, BorderLayout.CENTER);

        //声明一个容器：用来存储姓名、各项成绩的文本框以及标题
        Container c1 = new Container();

        //设置容器的位置：浮动--一般向左浮动
        c1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        //将姓名、各科成绩的文本框以及标签加到容器中
        c1.add(IdLabel);
        c1.add(textId);

        c1.add(NameLabel);
        c1.add(textName);

        c1.add(ClassLabel);
        c1.add(textClass);

        c1.add(ChineseLabel);
        c1.add(textChinese);

        c1.add(MathLabel);
        c1.add(textMath);

        c1.add(EnglishLabel);
        c1.add(textEnglish);

        p1.add(c1, BorderLayout.WEST);
        p1.add(c1);
        p1.add(showInsert);
        JScrollPane jp = new JScrollPane(showInsert);
        p1.add(jp);

        //按钮添加：
        Container c2 = new Container();
        c2.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));

        c2.add(b1);
        c2.add(b2);
        p1.add(c2);

        //给按钮 添加监听事件：
        b1.addActionListener(l);
        b2.addActionListener(l);


        //删除面板
        searchLabel3 = new JLabel("请输入需要修改/删除的学生学号");
        searchLabel3.setFont(new Font("宋体", Font.BOLD, 16));
        textDeleteID = new JTextField(8);
        //修改文本
        Container c3 = new Container();
        c3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        c3.add(DNameLabel);
        c3.add(DtextName);

        c3.add(DClassLabel);
        c3.add(DtextClass);

        c3.add(DChineseLabel);
        c3.add(DtextChinese);

        c3.add(DMathLabel);
        c3.add(DtextMath);

        c3.add(DEnglishLabel);
        c3.add(DtextEnglish);

        p3.add(searchLabel3);
        p3.add(textDeleteID);
        p3.add(c3);
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.addItem("修改学生信息");
        comboBox3.addItem("删除学生信息");
        JButton button3 = new JButton("确认");
        button3.addActionListener((actionEvent -> {

            //取出下拉列表框选中的数据
            String conboBoxStr3 = (String) comboBox3.getSelectedItem();
            if ( conboBoxStr3.equals("修改学生信息") ) {
                if ( !textDeleteID.getText().equals("") ) {
                    if ( !util.CheckStu(Integer.parseInt(textDeleteID.getText())) ) {
                        if ( (!(DtextName.getText().equals(""))) && (!DtextClass.getText().equals("")) && !(DtextChinese.getText().equals("")) && !(DtextMath.getText().equals("")) && !(DtextEnglish.getText().equals("")) ) {
                            String name = DtextName.getText();
                            util.update(Integer.parseInt(textDeleteID.getText()), name, Integer.parseInt(DtextClass.getText()), Double.parseDouble(DtextChinese.getText()), Double.parseDouble(DtextMath.getText()), Double.parseDouble(DtextEnglish.getText()));
                            //清空修改文本
                            DtextName.setText("");
                            DtextClass.setText("");
                            DtextChinese.setText("");
                            DtextMath.setText("");
                            DtextEnglish.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "不能为空!", "提示框", JOptionPane.WARNING_MESSAGE);
                        }
                        JOptionPane.showMessageDialog(null, "修改成功!", "提示框", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "学生不存在无法修改!", "提示框", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "不能为空!", "提示框", JOptionPane.WARNING_MESSAGE);
                }
            }
            if ( conboBoxStr3.equals("删除学生信息") ) {
                if ( !textDeleteID.getText().equals("") ) {
                    if ( !util.CheckStu(Integer.parseInt(textDeleteID.getText())) ) {
                        util.Delete(Integer.parseInt(textDeleteID.getText()));
                        JOptionPane.showMessageDialog(null, "删除成功!", "提示框", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "学生不存在或以删除!", "提示框", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "不能为空!", "提示框", JOptionPane.WARNING_MESSAGE);

                }
            }
        }));

        p3.add(comboBox3);
        p3.add(button3);


        //查询面板
        //初始化查询面板的所需对象
        searchLabel1 = new JLabel("请选择学生信息查询内容：");
        searchLabel1.setFont(new Font("宋体", Font.BOLD, 16));
        searchText2 = new JTextField(10);
        p2.add(searchLabel1);
        p2.add(searchText2);
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("按照学号查询");
        comboBox1.addItem("按照名字查询");
        comboBox1.addItem("按照班级查询");
        comboBox1.addItem("按照课程名称查询");
        comboBox1.addItem("按照语文成绩最高查询");
        comboBox1.addItem("按照数学成绩最高查询");
        comboBox1.addItem("按照英语成绩最高查询");
        JButton button = new JButton("提交");

        button.addActionListener((actionEvent -> {

            //取出下拉列表框选中的数据
            String conboBoxStr = (String) comboBox1.getSelectedItem();
            if ( conboBoxStr.equals("按照学号查询") ) {
                System.out.println("按照学号查询");


            }


            if ( conboBoxStr.equals("按照名字查询") ) {
                System.out.println("按照名字查询");

            }
            if ( conboBoxStr.equals("按照班级查询") ) {
                System.out.println("按照班级查询");
            }
            if ( conboBoxStr.equals("按照课程名称查询") ) {
                System.out.println("按照课程名称查询");
            }
            if ( conboBoxStr.equals("按照语文成绩最高查询") ) {
                System.out.println("按照语文成绩最高查询");
            }
            if ( conboBoxStr.equals("按照数学成绩最高查询") ) {
                System.out.println("按照数学成绩最高查询");
            }
            if ( conboBoxStr.equals("按照英语成绩最高查询") ) {
                System.out.println("按照英语成绩最高查询");
            }

        }));

        //searchButton = new JButton("确认查询");
        //searchButton.setFont(new Font("宋体",Font.BOLD,16));
        //searchText1 = new JTextField(8);
        //resultText =new JTextArea(20,60);
        //resultText.setBounds(10,550,500,200);

        //查询面板布局
        Container c4 = new Container();
        //c3.setLayout(new FlowLayout());
        // c3.setLayout(new FlowLayout(FlowLayout.LEFT));
        // c3.add(searchLabel1);
        p2.add(comboBox1);
        p2.add(button);
        p2.add(c4, FlowLayout.LEFT);
        // p2.add(resultText);
        //searchButton.addActionListener(l);


        //排序面板
        Container c5 = new Container();
        c5.setLayout(new FlowLayout(FlowLayout.LEFT));
        b3 = new JButton("学号排序");
        b4 = new JButton("语文成绩排名");
        b5 = new JButton("数学成绩排名");
        b6 = new JButton("英语成绩排名");
        b7 = new JButton("总成绩排名");
        b8 = new JButton("平均成绩排名");

        c5.add(b3);
        c5.add(b4);
        c5.add(b5);
        c5.add(b6);
        c5.add(b7);
        c5.add(b8);
        p4.add(c5);
        //Id排序展示
        //显示文本框
        showStudent = new JTextArea(20, 65);
        showStudent.setEditable(false);
        p4.add(showStudent);
        JScrollPane jp1 = new JScrollPane(showStudent);
        p4.add(jp1);
        b3.addActionListener((ActionEvent -> {
            Object[][] showid = util.showId();
            showStudent.setText("");
            showStudent.append("学号\t姓名\t班级\t语文\t数学\t英语\t总成绩\t平均成绩\n");
            for (int i = 0; i < showid.length; i++) {
                if ( showid[ i ][ 0 ] != null )
                    showStudent.append(showid[ i ][ 0 ] + "\t" + showid[ i ][ 1 ] + "\t" + showid[ i ][ 2 ] + "\t" + showid[ i ][ 3 ] + "\t" + showid[ i ][ 4 ] + "\t" + showid[ i ][ 5 ] + "\t" + showid[ i ][ 6 ] + "\t" + showid[ i ][ 7 ] + "\n");
            }


        }));

        //语文排序展示
        b4.addActionListener((ActionEvent -> {
            Object[][] showid = util.showChinese();
            showStudent.setText("");
            showStudent.append("学号\t\t姓名\t\t班级\t\t语文\n");
            for (int i = 0; i < showid.length; i++) {
                if ( showid[ i ][ 0 ] != null )
                    showStudent.append(showid[ i ][ 0 ] + "\t\t" + showid[ i ][ 1 ] + "\t\t" + showid[ i ][ 2 ] + "\t\t" + showid[ i ][ 3 ] + "\n");
            }
        }));
        //数学排序展示
        b5.addActionListener((ActionEvent -> {
            Object[][] showM = util.showMath();
            showStudent.setText("");
            showStudent.append("学号\t\t姓名\t\t班级\t\t数学\n");
            for (int i = 0; i < showM.length; i++) {
                if ( showM[ i ][ 0 ] != null )
                    showStudent.append(showM[ i ][ 0 ] + "\t\t" + showM[ i ][ 1 ] + "\t\t" + showM[ i ][ 2 ] + "\t\t" + showM[ i ][ 3 ] + "\n");
            }
        }));
        //英语排序展示
        b6.addActionListener((ActionEvent -> {
            Object[][] showE = util.showEnglish();
            showStudent.setText("");
            showStudent.append("学号\t\t姓名\t\t班级\t\t英语\n");
            for (int i = 0; i < showE.length; i++) {
                if ( showE[ i ][ 0 ] != null )
                    showStudent.append(showE[ i ][ 0 ] + "\t\t" + showE[ i ][ 1 ] + "\t\t" + showE[ i ][ 2 ] + "\t\t" + showE[ i ][ 3 ] + "\n");
            }
        }));
        //总成绩排序展示
        b7.addActionListener((ActionEvent -> {
            Object[][] showAll = util.showAll();
            showStudent.setText("");
            showStudent.append("学号\t\t姓名\t\t班级\t\t总成绩\n");
            for (int i = 0; i < showAll.length; i++) {
                if ( showAll[ i ][ 0 ] != null )
                    showStudent.append(showAll[ i ][ 0 ] + "\t\t" + showAll[ i ][ 1 ] + "\t\t" + showAll[ i ][ 2 ] + "\t\t" + showAll[ i ][ 3 ] + "\n");
            }
        }));
        //平均成绩排序展示
        b8.addActionListener((ActionEvent -> {
            Object[][] showAve = util.showAve();
            showStudent.setText("");
            showStudent.append("学号\t\t姓名\t\t班级\t\t平均成绩\n");
            for (int i = 0; i < showAve.length; i++) {
                if ( showAve[ i ][ 0 ] != null )
                    showStudent.append(showAve[ i ][ 0 ] + "\t\t" + showAve[ i ][ 1 ] + "\t\t" + showAve[ i ][ 2 ] + "\t\t" + showAve[ i ][ 3 ] + "\n");
            }
        }));


        //优秀率查询
        Container c6 = new Container();
        JComboBox<String> comboBox2 = new JComboBox<>();
        //JComboBox comboBox1=new JComboBox();

        comboBox2.addItem("每班语文成绩优秀率高到低");
        comboBox2.addItem("每班数学成绩优秀率高到低");
        comboBox2.addItem("每班英语成绩优秀率高到低");
        comboBox2.addItem("每班语文成绩不及格率高到低");
        comboBox2.addItem("每班数学成绩不及格率高到低");
        comboBox2.addItem("每班英语成绩不及格率高到低");
        JButton button1 = new JButton("提交");

        c6.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultA = new JTextArea(10, 30);
        //resultA.setBounds(10, 550, 550, 100);
        p5.add(comboBox2);
        p5.add(button1);
        p5.add(c6);
        p5.add(resultA);

        button1.addActionListener((actionEvent -> {

            //取出下拉列表框选中的数据
            String conboBoxStr1 = (String) comboBox2.getSelectedItem();
            if ( conboBoxStr1.equals("每班语文成绩优秀率高到低") ) {


                resultA.setText("");
                Object[][] objectYouxiuC = new Object[ 0 ][];
                try {
                    objectYouxiuC = util.YouxiuC();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultA.setEditable(false);
                for (int i = 0; i < objectYouxiuC.length; i++) {
                    resultA.append(objectYouxiuC[ i ][ 0 ] + "班的" + "语文优秀率：" + objectYouxiuC[ i ][ 1 ] + "\r\n");
                }


            }
            if ( conboBoxStr1.equals("每班数学成绩优秀率高到低") ) {
                resultA.setText("");
                Object[][] objectYouxiuM = util.YouxiuM();
                resultA.setEditable(false);
                for (int i = 0; i < objectYouxiuM.length; i++) {
                    resultA.append(objectYouxiuM[ i ][ 0 ] + "班的" + "数学优秀率：" + objectYouxiuM[ i ][ 1 ] + "\r\n");
                }

            }
            if ( conboBoxStr1.equals("每班英语成绩优秀率高到低") ) {
                resultA.setText("");
                Object[][] objectYouxiuE = util.YouxiuE();
                resultA.setEditable(false);
                for (int i = 0; i < objectYouxiuE.length; i++) {
                    resultA.append(objectYouxiuE[ i ][ 0 ] + "班的" + "英语优秀率：" + objectYouxiuE[ i ][ 1 ] + "\r\n");
                }
            }
            if ( conboBoxStr1.equals("每班语文成绩不及格率高到低") ) {
                resultA.setText("");
                Object[][] objectBUjigeC = util.BujigeC();
                resultA.setEditable(false);
                for (int i = 0; i < objectBUjigeC.length; i++) {
                    resultA.append(objectBUjigeC[ i ][ 0 ] + "班的" + "英语不及格率：" + objectBUjigeC[ i ][ 1 ] + "\r\n");
                }
            }
            if ( conboBoxStr1.equals("每班数学成绩不及格率高到低") ) {
                resultA.setText("");
                Object[][] objectBUjigeM = util.BujigeM();
                resultA.setEditable(false);
                for (int i = 0; i < objectBUjigeM.length; i++) {
                    resultA.append(objectBUjigeM[ i ][ 0 ] + "班的" + "数学不及格率：" + objectBUjigeM[ i ][ 1 ] + "\r\n");
                }
            }
            if ( conboBoxStr1.equals("每班英语成绩不及格率高到低") ) {
                resultA.setText("");
                Object[][] objectBUjigeE = util.BujigeE();
                resultA.setEditable(false);
                for (int i = 0; i < objectBUjigeE.length; i++) {
                    resultA.append(objectBUjigeE[ i ][ 0 ] + "班的" + "英语不及格率：" + objectBUjigeE[ i ][ 1 ] + "\r\n");
                }
            }

        }));
        student.setVisible(true);
    }

    //监听事件
    class Listener implements ActionListener {
        //被点击时调用
        @Override
        public void actionPerformed(ActionEvent e) {
            //ActionEvent e--指代的是按下的那个按钮
            //e.getSource():获取按下的按钮
            if ( e.getSource() == b1 ) {
                /*

                1.获取文本框内容--显示内容的文本框
                四个数组--学号和各科成绩 下标
                2.添加完毕后，文本框内容消失
                 */
                if ( !(textId.getText().equals("")) && (!(textName.getText().equals(""))) && (!textClass.getText().equals("")) && !(textChinese.getText().equals("")) && !(textMath.getText().equals("")) && !(textEnglish.getText().equals("")) ) {
                    if ( util.CheckStu(Integer.parseInt(textId.getText())) ) {
                        String name = textName.getText();
                        if ( util.insert(Integer.parseInt(textId.getText()), name, Integer.parseInt(textClass.getText()), Double.parseDouble(textChinese.getText()), Double.parseDouble(textMath.getText()), Double.parseDouble(textEnglish.getText())) ) {
                            //清空文本
                            textId.setText("");
                            textName.setText("");
                            textClass.setText("");
                            textChinese.setText("");
                            textMath.setText("");
                            textEnglish.setText("");
                            JOptionPane.showMessageDialog(null, "添加成功!", "提示框", JOptionPane.WARNING_MESSAGE);

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "学生已存在!", "提示框", JOptionPane.WARNING_MESSAGE);

                    }


                } else {
                    JOptionPane.showMessageDialog(null, "不能为空!", "提示框", JOptionPane.WARNING_MESSAGE);


                }
            }
            if ( e.getSource() == b2 ) {
                Object[][] showid = util.showId();
                showInsert.setText("");
                showInsert.setEditable(false);
                showInsert.append("学号\t姓名\t班级\t语文\t数学\t英语\t总成绩\t平均成绩\n");
                for (int i = 0; i < showid.length; i++) {
                    if ( showid[ i ][ 0 ] != null )
                        showInsert.append(showid[ i ][ 0 ] + "\t" + showid[ i ][ 1 ] + "\t" + showid[ i ][ 2 ] + "\t" + showid[ i ][ 3 ] + "\t" + showid[ i ][ 4 ] + "\t" + showid[ i ][ 5 ] + "\t" + showid[ i ][ 6 ] + "\t" + showid[ i ][ 7 ] + "\n");
                }

            }

            if ( e.getSource() == searchButton ) {
                System.out.println("确定查询");
                if ( !(searchText1.getText().equals("")) ) {

                } else {

                }
            }
        }


    }

    //创建一个方法用于将数组内容添加到显示文本框中


}


