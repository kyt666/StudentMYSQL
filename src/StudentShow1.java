import student.Stu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    //标签：姓名 语文成绩 数学成绩 英语成绩
    private JLabel IdLabel, NameLabel, ClassLabel, ChineseLabel, MathLabel, EnglishLabel;
    //姓名 成绩文本框
    private JTextField textId, textName, textClass, textChinese, textMath, textEnglish;
    //显示学生信息内容的文本框
    private JTextArea showGrade, showStudent;
    //删除面板内容
    //删除标签
    private JLabel searchLabel3;
    //删除ID文本框
    private JTextField textDeleteID;
    //表
    JTable table = new JTable();
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
        //两个按钮
        b1 = new JButton("确认添加");
        b2 = new JButton("撤销添加");

        //显示文本框
        showGrade = new JTextArea(20, 60);
        showGrade.setBounds(10, 550, 500, 200);

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
        p1.add(showGrade);
        JScrollPane jp = new JScrollPane(showGrade);
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
        searchLabel3 = new JLabel("请输入需要修改/删除的学生Id");
        searchLabel3.setFont(new Font("宋体", Font.BOLD, 16));
        textDeleteID = new JTextField(8);
        p3.add(searchLabel3);
        p3.add(textDeleteID);
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.addItem("修改学生信息");
        comboBox3.addItem("删除学生信息");
        JButton button3 = new JButton("确认");

        button3.addActionListener((actionEvent -> {

            //取出下拉列表框选中的数据
            String conboBoxStr3 = (String) comboBox3.getSelectedItem();
            if ( conboBoxStr3.equals("修改学生信息") ) {
                System.out.println("修改");
            }
            if ( conboBoxStr3.equals("删除学生信息") ) {
                System.out.println("删除");
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

        // 表头（列名）
        Object[] columnNames = {"id", "姓名", "班级", "语文", "数学", "英语", "总成绩", "平均成绩"};


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
        Container c3 = new Container();
        //c3.setLayout(new FlowLayout());
        // c3.setLayout(new FlowLayout(FlowLayout.LEFT));
        // c3.add(searchLabel1);
        p2.add(comboBox1);
        p2.add(button);
        p2.add(c3, FlowLayout.LEFT);
        // p2.add(resultText);
        //searchButton.addActionListener(l);


        //排序面板
        Container c4 = new Container();
        c4.setLayout(new FlowLayout(FlowLayout.LEFT));
        b3 = new JButton("学号排序");
        b4 = new JButton("语文成绩排名");
        b5 = new JButton("数学成绩排名");
        b6 = new JButton("英语成绩排名");
        b7 = new JButton("总成绩排名");
        b8 = new JButton("平均成绩排名");

        c4.add(b3);
        c4.add(b4);
        c4.add(b5);
        c4.add(b6);
        c4.add(b7);
        c4.add(b8);
        p4.add(c4);
        //Id排序展示
        b3.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showId();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnId = {"id", "姓名", "班级", "语文", "数学", "英语", "总成绩", "平均成绩"};
            Object[][] objects = new Object[ stus.size() ][ 8 ];
            for (int i = 0; i < stus.size(); i++) {
                objects[ i ][ 0 ] = stus.get(i).getId();
                objects[ i ][ 1 ] = stus.get(i).getName();
                objects[ i ][ 2 ] = stus.get(i).getClasses();
                objects[ i ][ 3 ] = stus.get(i).getChinese();
                objects[ i ][ 4 ] = stus.get(i).getMath();
                objects[ i ][ 5 ] = stus.get(i).getEnglish();
                objects[ i ][ 6 ] = stus.get(i).getAll();
                objects[ i ][ 7 ] = stus.get(i).getAve();
            }
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            tableModel.setDataVector(objects, columnId);
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
        }));

        //语文排序展示
        b4.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showChinese();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnChinese = {"id", "姓名", "班级", "语文"};
            Object[][] objectChinese = new Object[ stus.size() ][ 4 ];
            for (int i = 0; i < stus.size(); i++) {
                objectChinese[ i ][ 0 ] = stus.get(i).getId();
                objectChinese[ i ][ 1 ] = stus.get(i).getName();
                objectChinese[ i ][ 2 ] = stus.get(i).getClasses();
                objectChinese[ i ][ 3 ] = stus.get(i).getChinese();
            }
            tableModel.setDataVector(objectChinese, columnChinese);
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
        }));
        //数学排序展示
        b5.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showMath();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnMath = {"id", "姓名", "班级", "数学"};
            Object[][] objectMath = new Object[ stus.size() ][ 4 ];
            for (int i = 0; i < stus.size(); i++) {
                objectMath[ i ][ 0 ] = stus.get(i).getId();
                objectMath[ i ][ 1 ] = stus.get(i).getName();
                objectMath[ i ][ 2 ] = stus.get(i).getClasses();
                objectMath[ i ][ 3 ] = stus.get(i).getMath();
            }
            tableModel.setDataVector(objectMath, columnMath);
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
        }));
        //英语排序展示
        b6.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showEnglish();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnEnglish = {"id", "姓名", "班级", "英语"};
            Object[][] objectEnglish = new Object[ stus.size() ][ 4 ];
            for (int i = 0; i < stus.size(); i++) {
                objectEnglish[ i ][ 0 ] = stus.get(i).getId();
                objectEnglish[ i ][ 1 ] = stus.get(i).getName();
                objectEnglish[ i ][ 2 ] = stus.get(i).getClasses();
                objectEnglish[ i ][ 3 ] = stus.get(i).getEnglish();
            }
            tableModel.setDataVector(objectEnglish, columnEnglish);
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
            table.setEnabled(false);
        }));
        //总成绩排序展示
        b7.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showAll();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnAll = {"id", "姓名", "班级", "总成绩"};
            Object[][] objectAll = new Object[ stus.size() ][ 4 ];
            for (int i = 0; i < stus.size(); i++) {
                objectAll[ i ][ 0 ] = stus.get(i).getId();
                objectAll[ i ][ 1 ] = stus.get(i).getName();
                objectAll[ i ][ 2 ] = stus.get(i).getClasses();
                objectAll[ i ][ 3 ] = stus.get(i).getAll();
            }
            tableModel.setDataVector(objectAll, columnAll);
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
        }));
        //平均成绩排序展示
        b8.addActionListener((ActionEvent -> {
            List<Stu> stus = util.showAve();
            DefaultTableModel tableModel = new DefaultTableModel();
            Object[] columnAve = {"id", "姓名", "班级", "平均成绩"};
            Object[][] objectAve = new Object[ stus.size() ][ 4 ];
            for (int i = 0; i < stus.size(); i++) {
                objectAve[ i ][ 0 ] = stus.get(i).getId();
                objectAve[ i ][ 1 ] = stus.get(i).getName();
                objectAve[ i ][ 2 ] = stus.get(i).getClasses();
                objectAve[ i ][ 3 ] = stus.get(i).getAve();
            }
            tableModel.setDataVector(objectAve, columnAve);
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            p4.add(table.getTableHeader(), BorderLayout.CENTER);
            p4.add(table, BorderLayout.CENTER);// 把 表格内容 添加到容器中心
            table.setModel(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane, BorderLayout.CENTER);
        }));


        //优秀率查询classes
        Container c5 = new Container();
        JComboBox<String> comboBox2 = new JComboBox<>();
        //JComboBox comboBox1=new JComboBox();
        comboBox2.addItem("语文成绩优秀率");
        comboBox2.addItem("数学成绩优秀率");
        comboBox2.addItem("英语成绩优秀率");
        comboBox2.addItem("语文成绩不及格率");
        comboBox2.addItem("数学成绩不及格率");
        comboBox2.addItem("英语成绩不及格率");
        JButton button1 = new JButton("提交");
        button1.addActionListener((actionEvent -> {

            //取出下拉列表框选中的数据
            String conboBoxStr1 = (String) comboBox2.getSelectedItem();
            if ( conboBoxStr1.equals("语文成绩优秀率") ) {

                System.out.println("按照优秀查询");
            }
            if ( conboBoxStr1.equals("数学成绩优秀率") ) {
                System.out.println("按照名字查询");
            }
            if ( conboBoxStr1.equals("英语成绩优秀率") ) {
                System.out.println("按照班级查询");
            }
            if ( conboBoxStr1.equals("语文成绩不及格率") ) {
                System.out.println("按照课程名称查询");
            }
            if ( conboBoxStr1.equals("数学成绩不及格率") ) {
                System.out.println("按照语文成绩最高查询");
            }
            if ( conboBoxStr1.equals("英语成绩不及格率") ) {
                System.out.println("按照数学成绩最高查询");
            }

        }));


        c5.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultA = new JTextArea(20, 60);
        resultA.setBounds(10, 550, 500, 200);
        p5.add(resultA);
        p5.add(comboBox2);
        p5.add(button1);
        p5.add(c5);


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
                System.out.println("确认添加");
                /*

                1.获取文本框内容--显示内容的文本框
                四个数组--学号和各科成绩 下标
                2.添加完毕后，文本框内容消失
                 */
                if ( !(textId.getText().equals("")) && (!(textName.getText().equals(""))) && (!textClass.getText().equals("")) && !(textChinese.getText().equals("")) && !(textMath.getText().equals("")) && !(textEnglish.getText().equals("")) ) {
                    if ( util.CheckStu(Integer.parseInt(textId.getText()))){
                        String name = textName.getText();
                        util.insert(Integer.parseInt(textId.getText()),name,Integer.parseInt(textClass.getText()),Double.parseDouble(textChinese.getText()),Double.parseDouble(textMath.getText()),Double.parseDouble(textEnglish.getText()));
                        //清空文本
                        textId.setText("");
                        textName.setText("");
                        textClass.setText("");
                        textChinese.setText("");
                        textMath.setText("");
                        textEnglish.setText("");
                    }else {
                        System.out.println("学生已存在！");
                    }


                } else {

                }
            }
            if ( e.getSource() == b2 ) {


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


