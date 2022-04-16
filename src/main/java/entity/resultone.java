package entity;

public class resultone {

    private int istrue;
    private String msg;

    public resultone(int istrue, String msg) {
        this.istrue = istrue;
        this.msg = msg;
    }

    public int getIstrue() {
        return istrue;
    }

    public void setIstrue(int istrue) {
        this.istrue = istrue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
