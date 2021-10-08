package com.anushka.web.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import org.apache.catalina.manager.DummyProxySession;

public class EpisodesDBUtil {

	private static DataSource dataSource;

	public EpisodesDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Episode> getEpisodes() throws Exception {

		List<Episode> episodes = new ArrayList<>();

		Connection myCn = null;
		Statement mySm = null;
		ResultSet myRs = null;

		try {

			// Get a connection
			myCn = dataSource.getConnection();

			// Create sql statement
			String sql = "select * from Episodes";
			mySm = myCn.createStatement();

			// Execute query
			myRs = mySm.executeQuery(sql);

			// Process result
			while (myRs.next()) {

				// Retrieve data from result set row
				String epnum = myRs.getString("epnum");
				String season = myRs.getString("season");
				String epname = myRs.getString("epname");
				String rating = myRs.getString("rating");

				// Create a new episode
				Episode temp = new Episode(epnum, season, epname, rating);

				// Add to the list of episodes
				episodes.add(temp);

			}

			return episodes;
		} finally {
			// Close JDBC Connections
			close(myCn, mySm, myRs);

		}

	}

	// Puts back in the connection pool
	private static void close(Connection myCn, Statement mySm, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myCn != null) {
				myCn.close();
			}
			if (mySm != null) {
				mySm.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void addEpisode(Episode newEp) throws Exception {
		// TODO Auto-generated method stub
		
		Connection myCn = null;
		PreparedStatement mySt = null;
		try {
			
		//get db connection
		myCn = dataSource.getConnection();
			
		//create sql for insert
		String sql = "INSERT INTO Episodes(epnum,season,epname,rating) VALUES(?,?,?,?)"; 
		
	    mySt = myCn.prepareStatement(sql);
		//set the param values for the student 
		
	    mySt.setString(1, newEp.getEpnum());
	    mySt.setString(2, newEp.getSeason());
	    mySt.setString(3, newEp.getEpname());
	    mySt.setString(4, newEp.getRating());
		
		
		
		
		//execute sql insert
	    mySt.execute();
			
		}
		//clean up jdbc objects
		finally {
			close(myCn, mySt, null);
		}
		
		
	}

}