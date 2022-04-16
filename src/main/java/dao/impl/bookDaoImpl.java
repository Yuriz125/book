package dao.impl;

import Util.jdbcUtil;
import dao.bookDao;
import entity.bookInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDaoImpl implements bookDao {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    @Override
    public int addbook(String sql) {
        int a=0;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            a=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }

    @Override
    public int deletebook(String sql) {
        int a=0;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            a=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }

    @Override
    public int updatebook(String sql) {
        int a=0;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            a=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }

    @Override
    public List<bookInfo> selectall(String sql) {
        List<bookInfo> list=new ArrayList<bookInfo>();
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                bookInfo b=new bookInfo(rs.getInt("bookId"),rs.getString("bookCode"),rs.getString("bookType"),rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("publisher"),rs.getString("createtime"),rs.getString("borrowed"));
                list.add(b);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public bookInfo selectone(String sql) {
        bookInfo b=null;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                b=new bookInfo(rs.getInt("bookId"),rs.getString("bookCode"),rs.getString("bookType"),rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("publisher"),rs.getString("createtime"),rs.getString("borrowed"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }

    @Override
    public int count(String sql) {
        int c=0;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                c=rs.getInt("c");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    @Override
    public bookInfo selectbookname(String sql) {
        bookInfo b=null;
        try {
            con= jdbcUtil.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                b=new bookInfo(rs.getInt("bookId"),rs.getString("bookCode"),rs.getString("bookType"),rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("publisher"),rs.getString("createtime"),rs.getString("borrowed"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }
}