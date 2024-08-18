package com.soft.entity;

import java.util.List;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/27 15:46
 */
public class PageSplit
{
    private List<Member> list;
    private Integer currpage;
    private Integer totalpage;

    public List<Member> getList()
    {
        return list;
    }

    public void setList(List<Member> list)
    {
        this.list = list;
    }

    public Integer getCurrpage()
    {
        return currpage;
    }

    public void setCurrpage(Integer currpage)
    {
        this.currpage = currpage;
    }

    public Integer getTotalpage()
    {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage)
    {
        this.totalpage = totalpage;
    }

    @Override
    public String toString()
    {
        return "PageSplit{" +
                "list=" + list +
                ", currpage=" + currpage +
                ", totalpage=" + totalpage +
                '}';
    }
}