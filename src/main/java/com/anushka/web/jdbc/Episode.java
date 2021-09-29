package com.anushka.web.jdbc;

public class Episode {
	
	private int epnum;
	private int season;
	private String epname;
	private int rating ;
	
	@Override
	public String toString() {
		return "Episode [epnum=" + epnum + ", season=" + season + ", epname=" + epname + ", rating=" + rating + "]";
	}

	public int getEpnum() {
		return epnum;
	}

	public void setEpnum(int epnum) {
		this.epnum = epnum;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getEpname() {
		return epname;
	}

	public void setEpname(String epname) {
		this.epname = epname;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Episode(int epnum, int season, String epname, int rating) {
	
		this.epnum = epnum;
		this.season = season;
		this.epname = epname;
		this.rating = rating;
	}

}
