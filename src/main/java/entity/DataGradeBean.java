package entity;

import java.util.List;

public class DataGradeBean {
    private int page;  //当前页数
    private int sumpage;  //总页数
    private List<?> list; //集合

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSumpage() {
        return sumpage;
    }

    public void setSumpage(int sumpage) {
        this.sumpage = sumpage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
