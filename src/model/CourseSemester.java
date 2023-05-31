package model;

public class CourseSemester {
    private String cno;
    private String semester;
    private String tno;
    private Integer weekbegin;
    private Integer weekend;
    private Integer capacity;
    private String location;
    private Integer status;

    //以下是视图属性
    private String cname;
    private String tname;
    private Integer runday;
    private Integer begintime;
    private Integer endtime;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getBegintime() {
        return begintime;
    }

    public void setBegintime(Integer begintime) {
        this.begintime = begintime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getRunday() {
        return runday;
    }

    public void setRunday(Integer runday) {
        this.runday = runday;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getWeekbegin() {
        return weekbegin;
    }

    public void setWeekbegin(Integer weekbegin) {
        this.weekbegin = weekbegin;
    }

    public Integer getWeekend() {
        return weekend;
    }

    public void setWeekend(Integer weekend) {
        this.weekend = weekend;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
