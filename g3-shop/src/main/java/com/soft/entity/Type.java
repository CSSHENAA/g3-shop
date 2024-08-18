package com.soft.entity;

/**证件名、支付方式、运送方式表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:53
 */
public class Type {
    private Integer id;
    private String name;//证件名、支付方式、运送方式
    private String flag;//a/b/c


    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public Type() {
    }

    public Type(Integer id, String name, String flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}