package Funding.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Funding.model.service.DemandService;
import Funding.model.vo.Demand;
import member.model.vo.Member;

/**
 * Servlet implementation class DemandDetailServlet
 */
@WebServlet("/demand.detail")
public class DemandDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		DemandService service = new DemandService();
		Demand d = service.getDemand(no);
		String fName = service.getFile(d.getFileNo());
		String genre = service.getGenre(d.getGerneNo());
		String smName = service.getScreen(d.getSmNo());
		char chk = service.getWant(userId,no);
		request.setAttribute("Demand", d);
		request.setAttribute("fName", fName);
		request.setAttribute("genre", genre);
		request.setAttribute("smName", smName);
		request.setAttribute("chk", chk);
		
		String page = "view/demand/demandPost.jsp";
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
