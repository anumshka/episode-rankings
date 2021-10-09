package com.anushka.web.jdbc;

public class Episode {

	private int epid;
	private String epnum;
	private String season;
	private String epname;
	private String rating;

	@Override
	public String toString() {
		return "Episode [epnum=" + epnum + ", season=" + season + ", epname=" + epname + ", rating=" + rating + "]";
	}

	public String getEpnum() {
		return epnum;
	}

	public void setEpnum(String epnum) {
		this.epnum = epnum;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getEpname() {
		return epname;
	}

	public void setEpname(String epname) {
		this.epname = epname;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Episode(int epid, String epnum, String season, String epname, String rating) {

		this.epid = epid;
		this.epnum = epnum;
		this.season = season;
		this.epname = epname;
		this.rating = rating;
	}

	public Episode(String epnum, String season, String epname, String rating) {

		this.epnum = epnum;
		this.season = season;
		this.epname = epname;
		this.rating = rating;
	}

	public int getEpid() {
		return epid;
	}

	public void setEpid(int epid) {
		this.epid = epid;
	}

}