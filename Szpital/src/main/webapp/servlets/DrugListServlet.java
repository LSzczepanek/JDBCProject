package main.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.databaseHelpers.Drug;
import main.webapp.databaseHelpers.Patient;
import main.webapp.databaseHelpers.ResultHelper;

/**
 * Servlet implementation class DrugListServlet
 */
public class DrugListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/drugs.jsp";
		request.setCharacterEncoding("UTF-8");
		
		String patientIdSpace = request.getParameter("patientId");
		int patientId = Integer.parseInt(patientIdSpace.substring(1));
		request.setAttribute("patientId", patientIdSpace);
		
		String[][] drugs = ResultHelper.getArrayOfResult2(Drug.printAllAvalaibleDrugs(patientId));
		request.setAttribute("drugs", drugs);
		
		String[] patientInfo = ResultHelper.getArrayOfResult(Patient.printPatient(patientId));
		request.setAttribute("patientInfo", patientInfo);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}

}
