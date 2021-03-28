package moviereviews;

import java.util.ArrayList;

public class user {
private String name;
private String status;
private int  noofreviews;
ArrayList<String> moviereviewlist=new ArrayList<String>();

 user(String name) {
	this.name=name;
	this.status="user";
	this.noofreviews=0;
}
 public String getstatus() {
		return this.status;
	}

	public void increase() {
		this.noofreviews++;
		if(this.noofreviews>3) {
			this.status="critic";
		}
		else if(this.noofreviews>6) {
			this.status="expert";
		}
		else if(this.noofreviews>15) {
			this.status="admin";
		}
	}
  public void  addlist(String movie) {
	this.moviereviewlist.add(movie);
  }
  public boolean checklist(String movie) {
	  return this.moviereviewlist.contains(movie);
  }

}
