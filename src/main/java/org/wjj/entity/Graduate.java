package org.wjj.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :wjj
 * @date : 2023/3/8
 * @Description :
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Graduate {

    private String name;
    private String direction;
    private String goal;


}
