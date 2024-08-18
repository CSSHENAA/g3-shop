package com.soft.entity;

import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/27 10:57
 */
public class PageSplitOrder {
    private List<Order> backList;
    private Integer currpage;
    private Integer totalpage;

    public List< Order > getBackList ( )
    {
        return backList;
    }

    public void setBackList ( List< Order > backList )
    {
        this.backList = backList;
    }

    public Integer getCurrpage ( )
    {
        return currpage;
    }

    public void setCurrpage ( Integer currpage )
    {
        this.currpage = currpage;
    }

    public Integer getTotalpage ( )
    {
        return totalpage;
    }

    public void setTotalpage ( Integer totalpage )
    {
        this.totalpage = totalpage;
    }

    @Override
    public String toString ( )
    {
        return "PageSplitOrder{" +
                "backList=" + backList +
                ", currpage=" + currpage +
                ", totalpage=" + totalpage +
                '}';
    }
}
