package com.anushka.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EpisodeController
 */
@WebServlet("/EpisodeController")
public class EpisodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EpisodesDBUtil episodesDBUtil;

	@Resource(name = "jdbc/Episodes")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		// create out data base utility and pass connection pool or datasource
		try {
			episodesDBUtil = new EpisodesDBUtil(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//list the episodes in MVC fashion
		try {
			listEpisodes(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void listEpisodes(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		//get episodes from db util 
		List<Episode>  episodes = episodesDBUtil.getEpisodes();
		
		
		//add episodes to request 
		request.setAttribute("EPISODE_LIST", episodes);
		
		
		//send to jsp page 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-episodes.jsp");
		dispatcher.forward(request,response);
		
		
	}

}
