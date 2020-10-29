package com.usian.bean;

import java.util.Date;

public class StudentVo extends  Student{
    private Date starttime;
    private Date stoptime;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }
}
