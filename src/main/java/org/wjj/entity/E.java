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
public class E {

    private String url;
    private String content;
    private String name;

}
