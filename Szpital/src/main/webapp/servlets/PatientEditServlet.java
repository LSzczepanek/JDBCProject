package main.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.databaseHelpers.Patient;

/**
 * Servlet implementation class PatientEditServlet
 */
public class PatientEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/patients";
		request.setCharacterEncoding("UTF-8");
		String ward = request.getParameter("wardName");
		int hospitalWardId = Integer.parseInt(request.getParameter("wardId"));
		request.setAttribute("wardName", ward);
		String patientIdSpace = request.getParameter("patientId");
		int patientId = Integer.parseInt(patientIdSpace.substring(1));
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String date = request.getParameter("year") + "-" + request.getParameter("month") + "-"
				+ request.getParameter("day");
		
		Patient.updatePatient(patientId, name, surname, city, address, date, hospitalWardId);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
