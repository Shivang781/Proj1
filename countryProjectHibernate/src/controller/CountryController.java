package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CountryDAO;
import vo.CountryVO;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/CountryController")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		if (flag.equals("search")) {
			search(request, response);
		}

		if (flag.equals("delete")) {

			delete(request, response);
			search(request, response);
		}

		if (flag.equals("edit")) {

			edit(request, response);
			response.sendRedirect("editC.jsp");
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		CountryVO v1 = new CountryVO();
		CountryDAO d = new CountryDAO();

		List ls = d.search();

		HttpSession ses = request.getSession();
		ses.setAttribute("list", ls);

		response.sendRedirect("viewC.jsp");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("x"));

		CountryVO regVO = new CountryVO();
		regVO.setId(id);

		CountryDAO d = new CountryDAO();
		d.delete(regVO);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");
		if (flag.equals("insert")) {
			insert(request, response);
			response.sendRedirect("addC.jsp");
		}
		if (flag.equals("update")) {
			update(request, response);
			search(request, response);

		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cname = request.getParameter("cname");
		String cdesc = request.getParameter("cdesc");

		CountryVO countryVo = new CountryVO();
 
		countryVo.setCname(cname);
		countryVo.setCdesc(cdesc);

		CountryDAO regDAO = new CountryDAO();
		regDAO.insert(countryVo);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		String fn = request.getParameter("cname");
		String ln = request.getParameter("cdesc");

		CountryVO regVO = new CountryVO();
		regVO.setId(id);
		regVO.setCname(fn);
		regVO.setCdesc(ln);
		CountryDAO d = new CountryDAO();
		d.update(regVO);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("y"));

		CountryVO regVO = new CountryVO();
		regVO.setId(id);

		CountryDAO d = new CountryDAO();
		List ls = d.edit(regVO);

		HttpSession ses = request.getSession();
		ses.setAttribute("list", ls);
	}

}
