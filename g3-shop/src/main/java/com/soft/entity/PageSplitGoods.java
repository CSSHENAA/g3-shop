package com.soft.entity;

import java.util.List;

/**
 * @author : 风间琉璃
 * @version : 1.0
 * @date : 2024/7/23 16:36
 */
public class PageSplitGoods {

    private int currpage;

    private  List<Goods> list ;

    private  int totalpage;

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    @Override
    public String toString() {
        return "PageSplit{" +
                "currpage=" + currpage +
                ", list=" + list +
                ", totalpage=" + totalpage +
                '}';
    }
}
