package object;

import java.io.Serializable;

public class CampData implements Serializable {
    String id;//캠핑장 아이디
    String name;//캠핑장 명
    String add;//캠핑장 주소
    String tel;//캠핑장 전화번호
    String value1, value2, value3;//상세 정보(설명,이용기준,오시는길)
    String homepageurl;//캠핑장 홈페이지
    String resurl;//예약페이지
    int image;
    double x, y;//위도 경도

    public CampData() {
    }

    public CampData(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public CampData(String name, String add, String tel, String value1, String value2, String value3, String homepageurl, String resurl, double x, double y) {
        this.name = name;
        this.add = add;
        this.tel = tel;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.homepageurl = homepageurl;
        this.resurl = resurl;
        this.x = x;
        this.y = y;
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getHomepageurl() {
        return homepageurl;
    }

    public void setHomepageurl(String homepageurl) {
        this.homepageurl = homepageurl;
    }

    public String getResurl() {
        return resurl;
    }

    public void setResurl(String resurl) {
        this.resurl = resurl;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}


