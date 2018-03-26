package kr.co.ezenac.jun0397.flower.Bean;

/**
 * Created by Administrator on 2018-03-21.
 */

public class flower_test {

    private int flower_id;
    private String flower_type;
    private String flower_name;
    private int flower_price;
    private String flower_language;
    private String flower_content;

    public flower_test(int flower_id, String flower_type, String flower_name, int flower_price, String flower_language, String flower_content) {
        this.flower_id = flower_id;
        this.flower_type = flower_type;
        this.flower_name = flower_name;
        this.flower_price = flower_price;
        this.flower_language = flower_language;
        this.flower_content = flower_content;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_type() {
        return flower_type;
    }

    public void setFlower_type(String flower_type) {
        this.flower_type = flower_type;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public int getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(int flower_price) {
        this.flower_price = flower_price;
    }

    public String getFlower_language() {
        return flower_language;
    }

    public void setFlower_language(String flower_language) {
        this.flower_language = flower_language;
    }

    public String getFlower_content() {
        return flower_content;
    }

    public void setFlower_content(String flower_content) {
        this.flower_content = flower_content;
    }
}
