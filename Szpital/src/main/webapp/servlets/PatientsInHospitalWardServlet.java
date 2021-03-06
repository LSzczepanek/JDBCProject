package main.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.databaseHelpers.PatientsInHospitalWard;
import main.webapp.databaseHelpers.ResultHelper;

/**
 * Servlet implementation class PatientsInHospitalWardServlet
 */
public class PatientsInHospitalWardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientsInHospitalWardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = "/patientsession.jsp";
		String ward = request.getParameter("wardName");
		String result = PatientsInHospitalWard.checkPatientsInHospitalWard(ward);
		result.replaceAll("\\s+", "");
		String[][] patientInfo = ResultHelper.getArrayOfResult2(PatientsInHospitalWard.checkPatientsInHospitalWard(ward));
			request.setAttribute("patientInfo", patientInfo);

			
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
