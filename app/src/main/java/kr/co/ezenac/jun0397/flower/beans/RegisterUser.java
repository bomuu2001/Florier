package kr.co.ezenac.jun0397.flower.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    private int id;
    private int phoneNumber;
    private String email;
    private String password;
    private String name;
    private int birth;
    private int sex;
}
