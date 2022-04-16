package service;

import entity.bookInfo;

import java.util.List;

public interface bookService {
    public int addbook(bookInfo b); //新增图书
    public int deletebook(int id);  //删除图书
    public int updatebook(bookInfo b);  //修改图书
    public List<bookInfo> selectall(int page); //查询全部
    public bookInfo selectone(int id);  //单个查询
    public int count();//查询总条数
    public bookInfo selectbookname(String bookName); //按书籍名称查询
 }