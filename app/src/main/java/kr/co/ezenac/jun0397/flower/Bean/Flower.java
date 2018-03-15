package kr.co.ezenac.jun0397.flower.Bean;

/**
 * Created by Administrator on 2018-03-14.
 */

public class Flower {
    private int flower_id;
    private int flower_type;  // 매스플라워=0, 필러플라워=1 등등
    private String flower_name;
    private int flower_price;
    private String flower_img;

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public int getFlower_type() {
        return flower_type;
    }

    public void setFlower_type(int flower_type) {
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

    public String getFlower_img() {
        return flower_img;
    }

    public void setFlower_img(String flower_img) {
        this.flower_img = flower_img;
    }

    public Flower(int flower_id, int flower_type, String flower_name, int flower_price, String flower_img) {
        this.flower_id = flower_id;
        this.flower_type = flower_type;
        this.flower_name = flower_name;
        this.flower_price = flower_price;
        this.flower_img = flower_img;
    }
}
