package service.impl;

import dao.bookDao;
import dao.impl.bookDaoImpl;
import entity.bookInfo;
import service.bookService;

import java.util.List;

public class bookServiceImpl implements bookService {
    //调dao层
    bookDao bd=new bookDaoImpl();
    @Override
    public int addbook(bookInfo b) {
        String sql="insert into bookInfo(bookCode,bookType,bookName,bookAuthor,publisher,createtime,borrowed) values('"+b.getBookCode()+"','"+b.getBookType()+"','"+b.getBookName()+"','"+b.getBookAuthor()+"','"+b.getPublisher()+"','"+b.getCreatetime()+"','"+b.getBorrowed()+"')";
        return bd.addbook(sql);
    }

    @Override
    public int deletebook(int id) {
        String sql="delete from bookInfo where bookId="+id;
        return bd.deletebook(sql);
    }

    @Override
    public int updatebook(bookInfo b) {
        String sql="update bookInfo set bookCode='"+b.getBookCode()+"',bookType='"+b.getBookType()+"',bookName='"+b.getBookName()+"',bookAuthor='"+b.getBookAuthor()+"',publisher='"+b.getPublisher()+"',createtime='"+b.getCreatetime()+"',borrowed='"+b.getBorrowed()+"' where bookId="+b.getBookId();
        System.out.println(sql);
        return bd.updatebook(sql);
    }

    @Override
    public List<bookInfo> selectall(int page) {
        int f=(page-1)*5;
        String sql="select * from bookInfo limit "+f+",5"; //每页显示五条
        return bd.selectall(sql);
    }

    @Override
    public bookInfo selectone(int id) {
        String sql="select * from bookInfo where bookId="+id;
        return bd.selectone(sql);
    }

    @Override
    public int count() {
        String sql="select count(1) c from bookInfo";  //给count起名c
        return bd.count(sql);
    }

    @Override
    public bookInfo selectbookname(String bookName) {
        String sql="select * from bookInfo where bookName like '%"+bookName+"%'";
        return bd.selectbookname(sql);
    }
}
