package view;

public class Course_teach {
    public String cname;
    public String cno;
    public String location;
    public String semester;
    public String weektime;
    public String teachtime;
    public Integer capacity;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getWeektime() {
        return weektime;
    }

    public void setWeektime(String weektime) {
        this.weektime = weektime;
    }

    public String getTeachtime() {
        return teachtime;
    }

    public void setTeachtime(String teachtime) {
        this.teachtime = teachtime;
    }
}
