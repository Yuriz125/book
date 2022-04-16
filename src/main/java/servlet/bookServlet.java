package servlet;

import com.alibaba.fastjson.JSON;
import entity.DataGradeBean;
import entity.bookInfo;
import entity.resultone;
import service.bookService;
import service.impl.bookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String type=req.getParameter("type");

        if("1".equals(type)){
            selectall(req,resp);
        }else if("2".equals(type)){
            addbook(req,resp);
        }else if("3".equals(type)){
            deletebook(req,resp);

        }else if("4".equals(type)){
            updatebook(req,resp);

        }else if("5".equals(type)){
            selectone(req,resp);
        }else if("6".equals(type)){
            getone(req,resp);
        }else if("7".equals(type)){
            selectbookname(req,resp);
        }
    }

    //调service层
    bookService bs=new bookServiceImpl();

    //1.查询全部信息
    protected void selectall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page=Integer.parseInt(req.getParameter("page")==null?"1":req.getParameter("page"));
        List<bookInfo> list=bs.selectall(page);
        int sum=bs.count();  //查询总条数
        int sumpage=sum%5>0?sum/5+1:sum/5;  //总页数
        DataGradeBean dgb=new DataGradeBean();
        dgb.setList(list);  //把list存到dgb
        dgb.setPage(page); //从页面获得页数
        dgb.setSumpage(sumpage);
            PrintWriter out=resp.getWriter();
            String json= JSON.toJSONStringWithDateFormat(dgb,"yyyy-MM-dd");
            out.print(json);
            out.flush();
            out.close();
    }

    //2.添加图书信息
    protected void addbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookCode=req.getParameter("bookCode");
        String bookType=req.getParameter("bookType");
        String bookName=req.getParameter("bookName");
        String bookAuthor=req.getParameter("bookAuthor");
        String publisher=req.getParameter("publisher");
        String createtime=req.getParameter("createtime");
        String borrowed=req.getParameter("borrowed");
        int a=bs.addbook(new bookInfo(bookCode,bookType,bookName,bookAuthor,publisher,createtime,borrowed));
        if(a>0){
            resp.sendRedirect("info.html"); //添加成功直接跳转

        }

    }

    //3.删除图书
    protected void deletebook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int a=bs.deletebook(Integer.parseInt(id));
        if(a>0){
            resp.sendRedirect("info.html"); //删除成功直接跳转
        }
    }

    //4.修改图书信息
    protected void updatebook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("bookId");
        String bookCode=req.getParameter("bookCode");
        String bookType=req.getParameter("bookType");
        String bookName=req.getParameter("bookName");
        String bookAuthor=req.getParameter("bookAuthor");
        String publisher=req.getParameter("publisher");
        String createtime=req.getParameter("createtime");
        String borrowed=req.getParameter("borrowed");
        int a=bs.updatebook(new bookInfo(Integer.parseInt(id),bookCode,bookType,bookName,bookAuthor,publisher,createtime,borrowed));
        if(a>0) {
            resultone r = new resultone(1, "修改成功");
            PrintWriter out = resp.getWriter();
            String json = JSON.toJSONStringWithDateFormat(r, "yyyy-MM-dd");
            out.print(json);
            out.flush();
            out.close();
        }else{
            resultone r = new resultone(0, "修改失败");
        }
    }

    //5.单个查询
    protected void selectone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        bookInfo b=bs.selectone(Integer.parseInt(id));
       //一般做到操作 都需要判断
        if (b!=null){
            //此处查到书籍 全局保存 供修改页面调用
            req.getSession().setAttribute("b",b);
            resultone r=new resultone(1,"查到！");
            PrintWriter out = resp.getWriter();
            String json = JSON.toJSONStringWithDateFormat(r, "yyyy-MM-dd");
            out.print(json);
            out.flush();
            out.close();
        }
    }

    //6.获取书籍信息
    protected void getone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在这里把刚刚存的全局变量取出来 然后json打印给前端页面
        bookInfo b= (bookInfo) req.getSession().getAttribute("b");
        PrintWriter out=resp.getWriter();
        String json=JSON.toJSONStringWithDateFormat(b,"yyyy-MM-dd");
        out.print(json);
        out.flush();
        out.close();
    }

    protected void selectbookname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        bookInfo b = bs.selectbookname(bookName);
        if (b != null) {
            //此处查到书籍 全局保存 供修改页面调用
            req.getSession().setAttribute("b", b);
            resultone r = new resultone(1, "查到！");
            PrintWriter out = resp.getWriter();
            String json = JSON.toJSONStringWithDateFormat(r, "yyyy-MM-dd");
            out.print(json);
            out.flush();
            out.close();
        }
    }

        @Override
    public void destroy() {
        super.destroy();
    }
}
