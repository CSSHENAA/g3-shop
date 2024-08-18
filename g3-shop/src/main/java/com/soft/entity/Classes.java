package com.soft.entity;

/**类别表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:23
 */
public class Classes {
    private Integer id;
    private  String name;//大类别、小类别名称
    private Integer pid;//父id

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Classes() {
    }

    public Classes(Integer id, String name, Integer pid) {
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