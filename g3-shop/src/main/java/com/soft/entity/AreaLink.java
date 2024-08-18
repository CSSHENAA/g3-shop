package com.soft.entity;

/**省县市表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:20
 */


public class AreaLink {
    private Integer id;
    private String name;//省市县名称
    private Integer pid;//父id

    @Override
    public String toString() {
        return "AreaLink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }

    public AreaLink() {
    }

    public AreaLink(Integer id, String name, Integer pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}