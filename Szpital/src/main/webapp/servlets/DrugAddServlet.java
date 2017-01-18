package main.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.databaseHelpers.Drug;

/**
 * Servlet implementation class DrugAddServlet
 */
public class DrugAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DrugAddServlet() {
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

		String url = "/druglist";
		request.setCharacterEncoding("UTF-8");

		String patientIdSpace = request.getParameter("patientId");
		request.setAttribute("patientId", patientIdSpace);
		int patientId = Integer.parseInt(patientIdSpace.substring(1));

		String wardName = request.getParameter("wardName");
		request.setAttribute("wardName", wardName);

		String drugIdSpace = request.getParameter("drugId");
		int drugId = Integer.parseInt(drugIdSpace);

		String drugCurrentAmountString = request.getParameter("drugCurrentAmount");
		if (drugCurrentAmountString.equals("null")) {
			drugCurrentAmountString = "0";
		}
		int drugCurrentAmount = Integer.parseInt(drugCurrentAmountString);
		String drugAmountString = request.getParameter("drugAmount");
		if (drugCurrentAmountString.isEmpty()) {
			drugCurrentAmountString = "0";
		}
		int drugAmount = Integer.parseInt(drugAmountString);

		if (drugCurrentAmount <= drugAmount) {
			int dose = drugAmount - drugCurrentAmount;
			boolean result = Drug.addDrugToPatient(patientId, drugId, dose);
			if (result == false) {
				url = "/druglist";
				request.setAttribute("error", "Podana wartość jest wyższa niż ilość leków w magazynie!");
			}

		} else if (drugCurrentAmount > drugAmount) {
			int dose = drugCurrentAmount - drugAmount;
			boolean result = Drug.removeDrugFromPatient(patientId, drugId, dose);
			if (result == false) {
				url = "/druglist";
				request.setAttribute("error",
						"Podana wartość nie może być mniejsza niż ilość leku przypisanego do pacjenta!");
			}
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
