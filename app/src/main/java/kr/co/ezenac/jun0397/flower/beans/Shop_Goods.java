package kr.co.ezenac.jun0397.flower.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop_Goods {
    private int id;
    private String goods_name;
    private int goods_price;
    //private String goods_img;
    //어디 꽃집 상품인지 변수하나 추가해야함
}
