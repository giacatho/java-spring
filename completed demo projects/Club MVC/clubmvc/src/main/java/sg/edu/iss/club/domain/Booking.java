package sg.edu.iss.club.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @ManyToOne
  private Member member;
  @ManyToOne
  private Facility facility;

  @NotNull(message = "startDate must be provided")
  @FutureOrPresent
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @NotNull(message = "endDate must be provided")
  @FutureOrPresent
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;

  private String comments;
  private BookingStatus status;

  public Booking() {}

  public Booking(@NotEmpty Member member, @NotEmpty Facility facility, @FutureOrPresent LocalDate startDate,
      @FutureOrPresent LocalDate endDate, String comments) {
    this.member = member;
    this.facility = facility;
    this.startDate = startDate;
    this.endDate = endDate;
    this.comments = comments;
    this.status = BookingStatus.BOOKED;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Booking [id=" + id + ", member=" + member + ", startDate=" + startDate + ", endDate="
        + endDate + ", comments=" + comments + ", status=" + status + "]";
  }

}
