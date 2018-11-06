package kr.co.ezenac.jun0397.flower.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingBagList {
    private int id;
    private String user_id; //고객 아이디
    //private Flower flower; //제품 코드
    private String goods_name;
    private int goods_price;
    private int goods_quantity; //상품 개수
}
