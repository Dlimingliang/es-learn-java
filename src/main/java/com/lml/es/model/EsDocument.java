package com.lml.es.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EsDocument implements Serializable {

    private static final long serialVersionUID = -7887684779439609351L;

    /** 主键 */
    private String id;
    /** 名称 */
    private String name;
    /** 年龄 */
    private Integer age;

    public EsDocument(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
