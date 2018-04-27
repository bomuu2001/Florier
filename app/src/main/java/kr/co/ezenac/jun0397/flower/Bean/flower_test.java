package kr.co.ezenac.jun0397.flower.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-03-21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class flower_test {
    private int flower_id;
    private String flower_type;
    private String flower_name;
    private int flower_price;
    private String flower_language;
    private String flower_content;
}
