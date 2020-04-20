package report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		System.out.println("서블릿 도달 성공");
		
		//		//ajax에서 받아온값
//		int bid = Integer.parseInt(request.getParameter("bid").trim());//널포인트 익셉션
//		System.out.println("서블릿bid:"+bid); //잘받아와짐
//		
//		//팝업jsp에서 받아온값
//		String content = request.getParameter("repContent");
//		System.out.println("서블릿content:"+content); //null
//		
//		Report rep = new Report();
//		rep.setBoardNo(bid);
//		
//		
//		
//		if(content != null) {
//			int result = new ReportService().sendReport(rep);
//			String page = null;
//			if(result>0) {
//				page = "/detail.rv?rv="+bid;
//			} else {
//				page = "view/errorPage/errorPage.jsp";
//				request.setAttribute("msg", "신고에 실패했습니다.");
//			}
//			RequestDispatcher view = request.getRequestDispatcher(page);
//			view.forward(request, response);	
//		}
//		
//		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
