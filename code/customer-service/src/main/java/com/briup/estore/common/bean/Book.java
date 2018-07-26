package com.briup.estore.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 书
 *
 * @author willon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 价格
     */
    private Double price;

    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String publisher;

    /**
     * 总页数
     */
    private String pageNum;


    /**
     * 描述信息
     */
    private String desc;


    /**
     * 图片地址
     */
    private String img;

    /**
     * 类别
     */
    private String type;
}
