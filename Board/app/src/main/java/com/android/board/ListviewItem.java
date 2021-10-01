package com.android.board;

public class ListviewItem {

    private String titleStr;
    private String descStr;
    private int hits;
    private String writeStr;
    private String dateStr;

    public void setHit(int hit) {
        hits = hit;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDesc(String desc) {
        descStr = desc;
    }

    public void setWrite(String writer) {
        writeStr = writer;
    }

    public void setDate(String date) {
         dateStr= date;
    }


    public String getTitle() {
        return this.titleStr;
    }
    public String getWrite() {
        return this.writeStr;
    }
    public int getHit() {
        return this.hits;
    }
    public String getDesc() {
        return this.descStr;
    }
    public String getDate() {
        return this.dateStr;
    }

}
