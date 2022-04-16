package Util;

import java.sql.*;

public class jdbcUtil {

    /*
    获取连接方法
     */
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  con;

    }


    /*
    释放资源方法
     */

    public static void release(Connection con, PreparedStatement ps, ResultSet rs){

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
