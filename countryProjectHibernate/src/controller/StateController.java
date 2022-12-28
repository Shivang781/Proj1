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
import dao.StateDAO;
import vo.CountryVO;
import vo.StateVO;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag = request.getParameter("flag");
		if (flag.equals("search")) {
			search(request, response);
		}

		if (flag.equals("delete")) {

			delete(request, response);
			search(request, response);
		}

		if (flag.equals("edit")) {

			CountryDAO d = new CountryDAO();
			List ls = d.search();
			HttpSession ses = request.getSession();
			ses.setAttribute("ls", ls);
			
			edit(request, response);
			response.sendRedirect("editS.jsp");
		}
		if (flag.equals("z")) {
			CountryDAO d = new CountryDAO();
			List ls = d.search();
			HttpSession ses = request.getSession();
			ses.setAttribute("ls", ls);
			response.sendRedirect("addS.jsp");
		}
	}
    
    protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		StateVO v1 = new StateVO();
		StateDAO d = new StateDAO();

		List ls = d.statesearch(v1);

		HttpSession ses = request.getSession();
		ses.setAttribute("list", ls);

		response.sendRedirect("viewS.jsp");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("x"));

		StateVO regVO = new StateVO();
		regVO.setId(id);

		StateDAO d = new StateDAO();
		d.delete(regVO);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");
		if (flag.equals("insert")) {
			insert(request, response);
			response.sendRedirect("addS.jsp");
		}
		if (flag.equals("update")) {
			update(request, response);
			search(request, response);

		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String sdesc = request.getParameter("sdesc");
		
		CountryVO v1 = new CountryVO();
		CountryDAO d = new CountryDAO();


		StateVO stateVo = new StateVO();

		stateVo.setSname(sname);
		stateVo.setSdesc(sdesc);
		
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		v1.setId(cid);
		stateVo.setCvo(v1);
		StateDAO regDAO = new StateDAO();
		regDAO.insert(stateVo);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		String fn = request.getParameter("sname");
		String ln = request.getParameter("sdesc");

		StateVO regVO = new StateVO();
		regVO.setId(id);
		regVO.setSname(fn);
		regVO.setSdesc(ln);
		int cid = Integer.parseInt(request.getParameter("cid"));
		CountryVO v1 = new CountryVO();
		v1.setId(cid);
		regVO.setCvo(v1);
		StateDAO d = new StateDAO();
		d.update(regVO);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("y"));
		
		CountryVO v1 = new CountryVO();
		CountryDAO d1 = new CountryDAO();
	
		
		StateVO regVO = new StateVO();
		regVO.setId(id);
		v1.setId(id);
		regVO.setCvo(v1);
		StateDAO d = new StateDAO();
		List ls = d.edit(regVO);

		HttpSession ses = request.getSession();
		ses.setAttribute("editlist", ls);
	}

}

