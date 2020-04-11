package entities;

import utils.ColumnName;

public class Score {

    private int id;
    @ColumnName("course_no")
    private int courseId;
    @ColumnName("sscore")
    private float score;

    public Score() {
    }

    public Score(int id, int courseId, float score) {
        this.id = id;
        this.courseId = courseId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
