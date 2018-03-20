package kr.co.ezenac.jun0397.flower.Bean;

/**
 * Created by Administrator on 2018-03-19.
 */

public class Store {
    private int flower_store_id;
    private String name;
    private String city;
    private String district;
    private String img_src;
    private String  call;
    private String address;

    public Store(int flower_store_id, String name, String city, String district, String img_src, String call, String address) {
        this.flower_store_id = flower_store_id;
        this.name = name;
        this.city = city;
        this.district = district;
        this.img_src = img_src;
        this.call = call;
        this.address = address;
    }

    public int getFlower_store_id() {
        return flower_store_id;
    }

    public void setFlower_store_id(int flower_store_id) {
        this.flower_store_id = flower_store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
