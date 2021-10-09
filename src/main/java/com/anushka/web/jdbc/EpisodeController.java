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

		// list the episodes in MVC fashion
		try {

			// read the command parameter
			String cmd = request.getParameter("cmd");

			// if cmd is missing , then list

			if (cmd == null) {
				cmd = "LIST";
			}

			// route to appopriate method
			switch (cmd) {
			case "LIST":
				listEpisodes(request, response);
				break;
			case "ADD":
				addEpisodes(request, response);
			case "LOAD":
				loadEpisodes(request, response);
			case "UPDATE":
				updateEpisode(request, response);
			case "DELETE":
				deleteEpisode(request, response);
			default:
				listEpisodes(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void deleteEpisode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// read about episode from form
		String epid = request.getParameter("epid");

		// delete the episode
		EpisodesDBUtil.deleteStudent(epid);

		// send them back to list episodes
		listEpisodes(request, response);

	}

	private void updateEpisode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// read about episode from form
		int epidInt = Integer.parseInt(request.getParameter("epidInt"));
		String epnum = request.getParameter("epno");
		String season = request.getParameter("season");
		String epname = request.getParameter("epname");
		String rating = request.getParameter("rating");

		// create new episode
		Episode newEp = new Episode(epidInt, epnum, season, epname, rating);

		// update episode
		EpisodesDBUtil.updateEpisode(newEp);

		// get back to the main page (episode list)
		listEpisodes(request, response);

	}

	private void loadEpisodes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// Read epidsode id from form data
		String epid = request.getParameter("epid");

		// get episode from data base
		Episode temp = EpisodesDBUtil.getEpisode(epid);

		// place the episode in request attribute
		request.setAttribute("THE_EPISODE", temp);

		// sent this to update-list jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-rating.jsp");
		dispatcher.forward(request, response);

	}

	private void addEpisodes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// read about episode from form
		String epnum = request.getParameter("epno");
		String season = request.getParameter("season");
		String epname = request.getParameter("epname");
		String rating = request.getParameter("rating");

		// create new episode
		Episode newEp = new Episode(epnum, season, epname, rating);

		// add episode
		EpisodesDBUtil.addEpisode(newEp);

		// get back to the main page (episode list)
		listEpisodes(request, response);

	}

	private void listEpisodes(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get episodes from db util
		List<Episode> episodes = episodesDBUtil.getEpisodes();

		// add episodes to request
		request.setAttribute("EPISODE_LIST", episodes);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-episodes.jsp");
		dispatcher.forward(request, response);

	}

}