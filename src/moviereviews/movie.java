package moviereviews;

import java.util.ArrayList;

public class movie {
private String moviename;
private String genre;
private  int year;
private int  reviewscore=0;
private int noofratings=0;
ArrayList<String> yearlyratings=new ArrayList<String>();
public movie(String moviename,int year,String genre) {
	this.moviename=moviename;
	this.year=year;
	this.genre=genre;
}
public void addscore(int score) {
	this.reviewscore+=score;
	noofratings++;
}
public int avgreviewscore() {
	return (this.reviewscore/this.noofratings);
}
public int getscore() {
	return this.reviewscore;
			
}
public int getyear() {
	return this.year;
}
public String getgenre() {
	return this.genre;
}
public String getnamem() {
	return this.moviename;
}

}
