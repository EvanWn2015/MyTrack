package idv.evan.mytrack;

/**
 * Created by EVAN_ on 2015/11/23.
 */
public class RecordsVo {
    private String date;
    private int img;
    private String title;
    private String content;

    public RecordsVo(String date, int img, String title, String content) {
        this.date = date;
        this.img = img;
        this.title = title;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
