package sg.edu.nus.cats.helper;

import java.util.Objects;

public class Approve {
	
	private String decision;
	private String comment;
	
	public Approve() {}
	
	public Approve(String decision, String comment) {
	  this.decision = decision;
	  this.comment = comment;
	}

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "Approve [decision=" + decision + ", comment=" + comment + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, decision);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Approve other = (Approve) obj;
    return Objects.equals(comment, other.comment) && Objects.equals(decision, other.decision);
  }
	
	

}
