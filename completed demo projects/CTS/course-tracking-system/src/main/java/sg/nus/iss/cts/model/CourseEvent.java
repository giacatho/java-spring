package sg.nus.iss.cts.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courseevent")
public class CourseEvent {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "courseeventid")
  private int courseEventId;
  
  @Column(name = "timestamp")
  private Date timeStamp;
  
  @Column(name = "eventtype", columnDefinition = "ENUM('SUBMITTED', 'APPROVED', 'WITHDRAWN', 'UPDATED', 'REJECTED')")
  @Enumerated(EnumType.STRING)
  private CourseEventEnum eventType;
  
  @Column(name = "eventby")
  private String eventBy;
  
  @Column(name = "comment")
  private String comment;
  
  // Reverse Relation
  @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinColumn(name = "courseid")
  private Course course;

  public CourseEvent() {}
  
  public CourseEvent(int courseEventId, Date timeStamp, CourseEventEnum eventType, String eventBy, String comment,
      Course course) {
    super();
    this.courseEventId = courseEventId;
    this.timeStamp = timeStamp;
    this.eventType = eventType;
    this.eventBy = eventBy;
    this.comment = comment;
    this.course = course;
  }

  public int getCourseEventId() {
    return courseEventId;
  }

  public void setCourseEventId(int courseEventId) {
    this.courseEventId = courseEventId;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public CourseEventEnum getEventType() {
    return eventType;
  }

  public void setEventType(CourseEventEnum eventType) {
    this.eventType = eventType;
  }

  public String getEventBy() {
    return eventBy;
  }

  public void setEventBy(String eventBy) {
    this.eventBy = eventBy;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }


  
}