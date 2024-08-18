package com.soft.entity;

import java.util.List;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/26 10:05
 */
public class PageSplitGoodsCar {
    private List<GoodsCar> list;

    private Integer currpage;

    private Integer totalpage;


    @Override
    public String toString() {
        return "PageSplitGoodsCar{" +
                "list=" + list +
                ", currpage=" + currpage +
                ", totalpage=" + totalpage +
                '}';
    }

    public PageSplitGoodsCar() {
    }

    public PageSplitGoodsCar(List<GoodsCar> list, Integer currpage, Integer totalpage) {
        this.list = list;
        this.currpage = currpage;
        this.totalpage = totalpage;
    }

    public List<GoodsCar> getList() {
        return list;
    }

    public void setList(List<GoodsCar> list) {
        this.list = list;
    }

    public Integer getCurrpage() {
        return currpage;
    }

    public void setCurrpage(Integer currpage) {
        this.currpage = currpage;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }
}