package donshin.basicjdbc.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String memberId;
    private int money;
}
