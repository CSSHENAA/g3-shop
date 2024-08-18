package com.soft.entity;

import java.util.Date;

/**订单表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:43
 */
public class Order {
    private Integer id;
    private Integer memberid;//会员id
    private String ordercode;//订单号
    private Integer bnumber;//品种数
    private String username;//收件人姓名
    private String address;//邮件地址
    private Integer postcode;//邮政编码
    private String tel;//电话
    private String pay;//支付方式
    private String carry;//运送方式
    private Date orderdate;//订单日期
    private String enforce;//执行
    private String bz;//备注
    private Double allprice;//总价


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberid=" + memberid +
                ", ordercode='" + ordercode + '\'' +
                ", bnumber=" + bnumber +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", tel='" + tel + '\'' +
                ", pay='" + pay + '\'' +
                ", carry='" + carry + '\'' +
                ", orderdate=" + orderdate +
                ", enforce='" + enforce + '\'' +
                ", bz='" + bz + '\'' +
                ", allprice=" + allprice +
                '}';
    }

    public Order() {
    }

    public Order(Integer id, Integer memberid, String ordercode, Integer bnumber, String username, String address, Integer postcode, String tel, String pay, String carry, Date orderdate, String enforce, String bz, Double allprice) {
        this.id = id;
        this.memberid = memberid;
        this.ordercode = ordercode;
        this.bnumber = bnumber;
        this.username = username;
        this.address = address;
        this.postcode = postcode;
        this.tel = tel;
        this.pay = pay;
        this.carry = carry;
        this.orderdate = orderdate;
        this.enforce = enforce;
        this.bz = bz;
        this.allprice = allprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public Integer getBnumber() {
        return bnumber;
    }

    public void setBnumber(Integer bnumber) {
        this.bnumber = bnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getCarry() {
        return carry;
    }

    public void setCarry(String carry) {
        this.carry = carry;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getEnforce() {
        return enforce;
    }

    public void setEnforce(String enforce) {
        this.enforce = enforce;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }
}