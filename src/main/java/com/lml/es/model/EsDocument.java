package com.lml.es.model;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EsDocument implements Serializable {

    private static final long serialVersionUID = -7887684779439609351L;

    /** 主键 */
    private String id;
    /** 名称 */
    private String name;
    /** 年龄 */
    private Integer age;
}
