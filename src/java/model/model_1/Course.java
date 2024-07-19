package model;

public class Course {
    private int course_id;
    private String course_name;
    private Class courseClass;

    public Course(int course_id, String course_name, Class courseClass) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.courseClass = courseClass;
    }

    public Course() {
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Class getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(Class courseClass) {
        this.courseClass = courseClass;
    }
}
