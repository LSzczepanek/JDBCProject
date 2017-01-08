package main.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.databaseHelpers.PatientsInHospitalWard;

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
		String url = "/patientsession.jsp";
		String ward = request.getParameter("ward");
		String result = PatientsInHospitalWard.checkPatientsInHospitalWard(ward);
		if (result != null) {
			String patientRow[] = result.split("\\r?\\n");
			String[][] patientInfo = null;
			for (int i = 0; i < patientRow.length; i++) {
				patientInfo[i] = patientRow[i].split(", ");
				
			}
			request.setAttribute("patientInfo", patientInfo);
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
