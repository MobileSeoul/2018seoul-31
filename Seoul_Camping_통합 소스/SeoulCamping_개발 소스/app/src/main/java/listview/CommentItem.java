package listview;

import android.os.Parcel;
import android.os.Parcelable;

public class CommentItem implements Parcelable {
    private int num;
    private String camp;
    private String id;
    private String name;
    private String text;

    /* Adviec 1 시간 , 별점 , 추천수 변수 구현*/
    private double star;
    private String regdate;
    private String password;

    public CommentItem(String camp, String id, String text, double star) {
        this.camp = camp;
        this.id = id;
        this.text = text;
        this.star = star;
    }
    public CommentItem(String camp, String id, String text, double star,String password) {
        this.camp = camp;
        this.id = id;
        this.text = text;
        this.star = star;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "num=" + num +
                ", camp='" + camp + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", star=" + star +
                ", regdate='" + regdate + '\'' +
                ", pw='" + password + '\'' +
                '}';
    }

    public CommentItem(Parcel src) {
        num = src.readInt();
        name = src.readString();
        text = src.readString();
        star = src.readDouble();
        regdate = src.readString();
        password = src.readString();
    }

    public static final Creator CREATOR = new Creator() {
        public CommentItem createFromParcel(Parcel src) {
            return new CommentItem(src);
        }

        public CommentItem[] newArray(int size) {
            return new CommentItem[size];
        }
    };

    @Override
    public int describeContents() { // 필수 오버라이드
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { // 필수 오버라이드
        dest.writeInt(num);
        dest.writeString(name);
        dest.writeString(text);
        dest.writeDouble(star);
        dest.writeString(regdate);
        dest.writeString(password);
    }
}
