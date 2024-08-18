package com.soft.entity;

/**管理表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:24
 */
public class Manager {
    private Integer id;
    private String manager;//管理员名
    private String pwd;//密码


    @Override
    public String toString() {
        return "BackMemberService{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Manager() {
    }

    public Manager(Integer id, String manager, String pwd) {
        this.id = id;
        this.manager = manager;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}