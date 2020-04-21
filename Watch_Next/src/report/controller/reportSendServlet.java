package report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import report.model.service.ReportService;
import report.model.vo.Report;

/**
 * Servlet implementation class reportSendServlet
 */
@WebServlet("/report.send")
public class reportSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = 0;
		if(request.getParameter("bno")!= "") {
			bno = Integer.parseInt(request.getParameter("bno").trim());
		}
		
		int rno = 0;
		if(request.getParameter("rno")!= "") {
			rno = Integer.parseInt(request.getParameter("rno").trim());
			
		}
				
		String content = request.getParameter("reportContent");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		if(rno == 0) { //게시글 신고전달
			Report rep = new Report();
			rep.setDecContent(content);
			rep.setUserId(userId);
			rep.setBoardNo(bno);
			
			int result = new ReportService().sendReport(rep);
			String page = null;
			if(result>0) {
				page = "/detail.rv?rv="+bno;
			} else {
				page = "view/errorPage/errorPage.jsp";
				request.setAttribute("msg", "신고에 실패했습니다.");
			}
			RequestDispatcher view = request.getRequestDispatcher(page);
			view.forward(request, response);
			
		} else if(bno == 0) { //댓글 신고전달
			Report rep = new Report();
			rep.setDecContent(content);
			rep.setCommentsNo(rno);
			rep.setUserId(userId);
			
			int result = new ReportService().sendReportR(rep);
			String page = null;
			if(result>0) {
				page = "/detail.rv?rv="+bno;
			} else {
				page = "view/errorPage/errorPage.jsp";
				request.setAttribute("msg", "신고에 실패했습니다.");
			}
			RequestDispatcher view = request.getRequestDispatcher(page);
			view.forward(request, response);
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
