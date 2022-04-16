package entity;

public class bookInfo {
    private int bookId;
    private String bookCode;
    private String bookType;
    private String bookName;
    private String bookAuthor;
    private String publisher;
    private String createtime;
    private String borrowed;

    public bookInfo(){}

    public bookInfo(String bookCode, String bookType, String bookName, String bookAuthor, String publisher, String createtime, String borrowed) {
        this.bookCode = bookCode;
        this.bookType = bookType;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.createtime = createtime;
        this.borrowed = borrowed;
    }

    public bookInfo(int bookId, String bookCode, String bookType, String bookName, String bookAuthor, String publisher, String createtime, String borrowed) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookType = bookType;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.createtime = createtime;
        this.borrowed = borrowed;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }
}
