package dao;

import entity.bookInfo;

import java.util.List;

public interface bookDao {
    public int addbook(String sql); //新增图书
    public int deletebook(String sql);  //删除图书
    public int updatebook(String sql);  //修改图书
    public List<bookInfo> selectall(String sql); //查询全部
    public bookInfo selectone(String sql);  //单个查询
    public int count(String sql); //查询总条数
    public bookInfo selectbookname(String sql); //按书籍名称查询
}
