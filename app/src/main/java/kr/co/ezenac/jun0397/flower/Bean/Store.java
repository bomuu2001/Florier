package kr.co.ezenac.jun0397.flower.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-03-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int flower_store_id;
    private String name;
    private String city;
    private String district;
    private String img_src;
    private String  call;
    private String address;
}
