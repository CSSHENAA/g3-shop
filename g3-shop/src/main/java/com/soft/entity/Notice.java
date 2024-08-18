package com.soft.entity;

import java.util.Date;

/**公告表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:39
 */
public class Notice {
    private Integer id;
    private String title;//公告标题
    private String content;//公告内容
    private Date creatdate;//发布日期
    private Date enddate;//截止日期
    private String addfile;//上传附件


    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creatdate=" + creatdate +
                ", enddate=" + enddate +
                ", addfile='" + addfile + '\'' +
                '}';
    }

    public Notice() {
    }

    public Notice(Integer id, String title, String content, Date creatdate, Date enddate, String addfile) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creatdate = creatdate;
        this.enddate = enddate;
        this.addfile = addfile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getAddfile() {
        return addfile;
    }

    public void setAddfile(String addfile) {
        this.addfile = addfile;
    }
}