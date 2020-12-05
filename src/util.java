import student.Stu;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class util {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Stu> stus = new ArrayList();

    //添加操作
    public boolean insert(int id, String name, int classes, double chinese, double math, double english) {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            DecimalFormat df = new DecimalFormat("#.00");
            double all = Double.parseDouble(df.format(chinese + math + english));
            double ave = Double.parseDouble(df.format((chinese + math + english) / 3));
            String sql = "INSERT INTO studentmysql.stu(id, name, classes , chinese , math , english , `all` ,ave) VALUES (  " + id + " ,'" + name + "' , " + classes + " , " + chinese + " , " + math + " ," + english + " ," + all + "," + ave + "  )";
            int i = statement.executeUpdate(sql);
            if ( i > 0 ) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return false;
    }

    //语文排序展示
    Object[][] showChinese() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,chinese from studentmysql.stu ORDER BY chinese DESC ";
            resultSet = statement.executeQuery(sql);
            Object[][] showC = new Object[ 100 ][ 4 ];
            for (int i = 0; resultSet.next(); i++) {
                showC[ i ][ 0 ] = resultSet.getInt("id");
                showC[ i ][ 1 ] = resultSet.getString("name");
                showC[ i ][ 2 ] = resultSet.getInt("classes");
                showC[ i ][ 3 ] = resultSet.getDouble("chinese");
            }
            return showC;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    //数学排序展示
    Object[][] showMath() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,math from studentmysql.stu ORDER BY math DESC ";
            resultSet = statement.executeQuery(sql);
            Object[][] showM = new Object[ 100 ][ 4 ];
            for (int i = 0; resultSet.next(); i++) {
                showM[ i ][ 0 ] = resultSet.getInt("id");
                showM[ i ][ 1 ] = resultSet.getString("name");
                showM[ i ][ 2 ] = resultSet.getInt("classes");
                showM[ i ][ 3 ] = resultSet.getDouble("math");
            }
            return showM;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    //英语排序展示
    public Object[][] showEnglish() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,english from studentmysql.stu ORDER BY english DESC ";
            resultSet = statement.executeQuery(sql);
            Object[][] showM = new Object[ 100 ][ 4 ];
            for (int i = 0; resultSet.next(); i++) {
                showM[ i ][ 0 ] = resultSet.getInt("id");
                showM[ i ][ 1 ] = resultSet.getString("name");
                showM[ i ][ 2 ] = resultSet.getInt("classes");
                showM[ i ][ 3 ] = resultSet.getDouble("english");
            }
            return showM;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    //总成绩排序
    public Object[][] showAll() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,`all` from studentmysql.stu ORDER BY `all` DESC ";
            resultSet = statement.executeQuery(sql);
            Object[][] showAll = new Object[ 100 ][ 4 ];
            for (int i = 0; resultSet.next(); i++) {
                showAll[ i ][ 0 ] = resultSet.getInt("id");
                showAll[ i ][ 1 ] = resultSet.getString("name");
                showAll[ i ][ 2 ] = resultSet.getInt("classes");
                showAll[ i ][ 3 ] = resultSet.getDouble("all");
            }
            return showAll;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    //平均成绩排序展示
    public Object[][] showAve() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,ave from studentmysql.stu ORDER BY ave DESC ";
            resultSet = statement.executeQuery(sql);
            Object[][] showAve = new Object[ 100 ][ 4 ];
            for (int i = 0; resultSet.next(); i++) {
                showAve[ i ][ 0 ] = resultSet.getInt("id");
                showAve[ i ][ 1 ] = resultSet.getString("name");
                showAve[ i ][ 2 ] = resultSet.getInt("classes");
                showAve[ i ][ 3 ] = resultSet.getDouble("ave");
            }
            return showAve;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    //Id排序展示
    Object[][] showId() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from studentmysql.stu ";
            resultSet = statement.executeQuery(sql);
            Object[][] showId = new Object[ 100 ][ 8 ];
            for (int i = 0; resultSet.next(); i++) {
                showId[ i ][ 0 ] = resultSet.getInt("id");
                showId[ i ][ 1 ] = resultSet.getString("name");
                showId[ i ][ 2 ] = resultSet.getInt("classes");
                showId[ i ][ 3 ] = resultSet.getDouble("chinese");
                showId[ i ][ 4 ] = resultSet.getDouble("math");
                showId[ i ][ 5 ] = resultSet.getDouble("english");
                showId[ i ][ 6 ] = resultSet.getDouble("all");
                showId[ i ][ 7 ] = resultSet.getDouble("ave");
            }
            return showId;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }

    void Delete(int id) {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "delete from studentmysql.stu where id=" + id + "";
            int i = statement.executeUpdate(sql);
            if ( i > 0 ) {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }

    boolean CheckStu(int id) {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from studentmysql.stu where id=" + id + "";
            resultSet = statement.executeQuery(sql);
            if ( resultSet.next() ) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return false;
    }


    void update(int id, String name, int classes,double chinese,double math,double english) {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            DecimalFormat df = new DecimalFormat("#.00");
            double all = Double.parseDouble(df.format(chinese + math + english));
            double ave = Double.parseDouble(df.format((chinese + math + english) / 3));
            String sql = "UPDATE studentmysql.stu set name='" + name + "',classes="+classes+",chinese=" + chinese + ",math="+math+",english="+english+",`all`="+all+",ave="+ave+" where id=" + id + "";
            int i = statement.executeUpdate(sql);
            if ( i > 0 ) {
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }

    Object[][] YouxiuC() throws SQLException {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(chinese>=90)/COUNT(*) as YouxiuC  from studentmysql.stu group by classes  order by YouxiuC desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectYouxiuC = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectYouxiuC[ i ][ 0 ] = resultSet.getInt("classes");
                objectYouxiuC[ i ][ 1 ] = resultSet.getDouble("YouxiuC");

            }
            return objectYouxiuC;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return new Object[ 0 ][];
    }


    public Object[][] YouxiuM() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(math>=90)/COUNT(*) as YouxiuM  from studentmysql.stu group by classes  order by YouxiuM desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectYouxiuM = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectYouxiuM[ i ][ 0 ] = resultSet.getInt("classes");
                objectYouxiuM[ i ][ 1 ] = resultSet.getDouble("YouxiuM");

            }
            return objectYouxiuM;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return new Object[ 0 ][];
    }

    public Object[][] YouxiuE() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(english>=90)/COUNT(*) as YouxiuE from studentmysql.stu group by classes  order by YouxiuE desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectYouxiuE = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectYouxiuE[ i ][ 0 ] = resultSet.getInt("classes");
                objectYouxiuE[ i ][ 1 ] = resultSet.getDouble("YouxiuE");

            }
            return objectYouxiuE;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return new Object[ 0 ][];
    }

    public Object[][] BujigeC() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(chinese<60)/COUNT(*) as BujigeC  from studentmysql.stu group by classes  order by BujigeC desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectBujigeC = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectBujigeC[ i ][ 0 ] = resultSet.getInt("classes");
                objectBujigeC[ i ][ 1 ] = resultSet.getDouble("BujigeC");

            }
            return objectBujigeC;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return new Object[ 0 ][];
    }

    public Object[][] BujigeM() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(math<60)/COUNT(*) as BujigeM  from studentmysql.stu group by classes  order by BujigeM desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectBujigeM = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectBujigeM[ i ][ 0 ] = resultSet.getInt("classes");
                objectBujigeM[ i ][ 1 ] = resultSet.getDouble("BujigeM");

            }
            return objectBujigeM;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return new Object[ 0 ][];
    }

    public Object[][] BujigeE() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select classes,sum(english<60)/COUNT(*) as BujigeE  from studentmysql.stu group by classes  order by BujigeE desc";
            resultSet = statement.executeQuery(sql);
            Object[][] objectBujigeE = new Object[ resultSet.getRow() + 2 ][ 2 ];
            for (int i = 0; resultSet.next(); i++) {
                objectBujigeE[ i ][ 0 ] = resultSet.getInt("classes");
                objectBujigeE[ i ][ 1 ] = resultSet.getDouble("BujigeE");

            }
            return objectBujigeE;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
        return new Object[ 0 ][];
    }
}
