package kr.co.ezenac.jun0397.flower.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-03-14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private int flower_id;
    private String flower_name;
    private String flower_language;
    private int flower_price;
    private String flower_img;
}
