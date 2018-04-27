package kr.co.ezenac.jun0397.flower.Bean;

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
    private int flower_type;  // 매스플라워=0, 필러플라워=1 등등
    private String flower_name;
    private int flower_price;
    private String flower_img;
}
