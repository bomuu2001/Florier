package kr.co.ezenac.jun0397.flower.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerStory {
    private int id;
    private String title;
    private String content;
}
