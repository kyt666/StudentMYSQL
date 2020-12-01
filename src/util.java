import student.Stu;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class util {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Stu> stus = new ArrayList();
    //添加操作
    public void insert(int id, int name, int chinese) {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT into stu(id, name, chinese) VALUES (" + id + "," + name + "," + chinese + ")";
            int i = statement.executeUpdate(sql);
            if ( i > 0 ) {
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
    //语文排序展示
    List<Stu> showChinese() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,chinese from studentmysql.stu ORDER BY chinese DESC";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setChinese(resultSet.getDouble("chinese"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }
    //数学排序展示
    List<Stu> showMath() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,math from studentmysql.stu ORDER BY math DESC";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setMath(resultSet.getDouble("math"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }
    //英语排序展示
    public List<Stu> showEnglish() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,english from studentmysql.stu ORDER BY english DESC";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setEnglish(resultSet.getDouble("english"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }
    //总成绩排序
    public List<Stu> showAll() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,`all` from studentmysql.stu ORDER BY `all` DESC";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setAll(resultSet.getDouble("all"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }
    //平均成绩排序展示
    public List<Stu> showAve() {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id, name ,classes ,ave from studentmysql.stu ORDER BY ave DESC";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setAve(resultSet.getDouble("ave"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }
    //Id排序展示
    List<Stu> showId() {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from studentmysql.stu ";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stu stu = new Stu();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setClasses(resultSet.getInt("classes"));
                stu.setChinese(resultSet.getDouble("chinese"));
                stu.setMath(resultSet.getDouble("math"));
                stu.setEnglish(resultSet.getDouble("english"));
                stu.setAll(resultSet.getDouble("all"));
                stu.setAve(resultSet.getDouble("ave"));
                stus.add(stu);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }

        return stus;
    }

    void Delete(int id) {
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "delete from stu where id=" + id + "";
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

    void Search(int id) {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from studentmysql.stu where id=" + id + "";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id"));
                System.out.print(resultSet.getString("name"));
                System.out.print(resultSet.getString("chinese"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }

    void update(int id, int name, int chinese) {

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "UPDATE stu set name=" + name + ",chinese=" + chinese + " where id=" + id + "";
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


}
