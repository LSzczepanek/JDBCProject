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
 * Servlet implementation class DrugSearchServlet
 */
public class DrugSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String url = "/drugs.jsp";
		request.setCharacterEncoding("UTF-8");
		
		String patientIdSpace = request.getParameter("patientId");
		int patientId = Integer.parseInt(patientIdSpace.substring(1));
		request.setAttribute("patientId", patientIdSpace);
		
		String search = request.getParameter("search");
		try{
		String[][] drugs = ResultHelper.getArrayOfResult2(Drug.searchFromAllAvalaibleDrugs(patientId, search));
		request.setAttribute("drugs", drugs);
		}
		catch(StringIndexOutOfBoundsException e)
		{
			
		}
		
		String[] patientInfo = ResultHelper.getArrayOfResult(Patient.printPatient(patientId));
		request.setAttribute("patientInfo", patientInfo);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
		
		
	}

}
