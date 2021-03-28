package moviereviews;

import java.util.*;
import java.time.*;
public class Runner {
public static void main(String[] args) {
ArrayList<String> username=new ArrayList<String>();
ArrayList<String> movienames=new ArrayList<String>();
ArrayList<user> u= new ArrayList<user>();
ArrayList<movie> m=new ArrayList<movie>();
ArrayList<review> r=new ArrayList<review>();
Scanner sc=new Scanner(System.in); 

int a;
do {
	System.out.println("CHOOSE THE ACTION YOU WANT TO DO:");
	System.out.println("1. ADD USER");
	System.out.println("2. ADD REVIEW");
	System.out.println("3. ADD MOVIE");
	System.out.println("4.find avg score in a particular movie");
	System.out.println("5.find avg score in a particular year");
    System.out.println("6.exit");
	 a=sc.nextInt();
	sc.nextLine();

switch( a) {
case 1:
	System.out.println("Enter username");
	String n=sc.nextLine();
	if(username.contains(n)) {
		System.out.println("Username already exists! choose other username");
		break;
	}
	username.add(n);
	user u1=new user(n);
	u.add(u1);
	System.out.println("User added successfully");
	break;
case 2:
	System.out.println("Enter movie name");
	String movienamei=sc.nextLine();
	int index1=movienames.indexOf(movienamei);
	System.out.println("Add a rating to the movie (Caution:rate movie between 1-10)");
	int rating=sc.nextInt();
	if(rating<1 || rating>10) {
		System.out.println("Invalid Rating");
	}
	sc.nextLine();
	System.out.println("Enter user name");
	String reviewusername=sc.nextLine();
	int index=username.indexOf(reviewusername);
	if(!username.contains(reviewusername)) {
		System.out.println("User not exists! Add user first");
		break;
	}

	if(u.get(index).checklist(movienamei)) {
		System.out.println("User already reviewed the movie");
		break;
	}
	if(u.get(index).getstatus()=="critic") {
		rating=rating*2;
	}
	else if(u.get(index).getstatus()=="expert") {
		rating=rating*3;
	}
	else if(u.get(index).getstatus()=="admin") {
		rating=rating*4;
	}
	m.get(index1).addscore(rating);
    u.get(index).increase();
    review r1=new review(movienamei,rating,reviewusername);
    r.add(r1);
   break;
case 3:

	System.out.println("Enter movie name you want to add");
	String movie_name=sc.nextLine();
	if(movienames.contains(movie_name)) {
		System.out.println("Movie already exists");
	}
	movienames.add(movie_name);
	System.out.println("Enter year of release");
	int year =sc.nextInt();
	Year yearofrelease=Year.of(year);
	Year currentyear=Year.now();
	if(currentyear.compareTo(yearofrelease)<0) {
		System.out.println("Movie not yet released");
		break;
	}
	System.out.println("Enter genre");
	sc.nextLine();
	String genre=sc.nextLine();
	movie m1=new movie(movie_name,year,genre);
	m.add(m1);
	break;
case 4:
	System.out.println("Enter the movie you wanted to find average score");
	sc.nextLine();
	String mfre=sc.nextLine();
	if(!movienames.contains(mfre)) {
		break;
	}
	int idx=movienames.indexOf(mfre);
	float scores=m.get(idx).avgreviewscore();
	System.out.println(scores);
	break;
case 5:
	System.out.println("Enter the year you want to calculate the avg score");
	int yearofre=sc.nextInt();
	int total=0;
	for(int i=0;i<m.size();i++) {
		if(yearofre==m.get(i).getyear()) {
			total+=m.get(i).getscore();
		}
	}
	System.out.println(total);
	break;
case 6:
{
    System.out.println("\n\t EXIT POINT ");
    break;
}

default:
	System.out.println("Invalid input");
	
}

}         while (a!=6);               

}	
}

