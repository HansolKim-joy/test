package recruit.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recruit.model.service.recruitService;
import recruit.model.vo.Recruit;

/**
 * Servlet implementation class RecruitUpdateServlet
 */
@WebServlet("/update.recruit")
public class RecruitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 번호, 제목, 내용, 날짜 받아와서 String으로 되어 있는 날짜를 sql.Date형식으로 바꿔주기(insert할때와 비슷)
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		

		String bTitle = request.getParameter("recW_recruitName");
		String bContent = request.getParameter("editor_content");
		String rHead = request.getParameter("recW_type");
		/* String bDate = request.getParameter("bDate"); */
		
		/*
		 * Date sqlDate = null;
		 * 
		 * if(bDate != "") { String[] dateArr = bDate.split("-");
		 * 
		 * int year = Integer.parseInt(dateArr[0]); int month =
		 * Integer.parseInt(dateArr[1])-1; int day = Integer.parseInt(dateArr[2]);
		 * 
		 * sqlDate = new Date(new GregorianCalendar(year, month,
		 * day).getTimeInMillis()); } else { sqlDate = new Date(new
		 * GregorianCalendar().getTimeInMillis()); }
		 */
		
		Recruit r = new Recruit();
		r.setrNo(rNo);
		r.setbTitle(bTitle);
		r.setbContent(bContent);
		r.setrHead(rHead);
		/* r.setbDate(sqlDate); */
		
		int result = new recruitService().updateRecruit(r);
		
		String page = null;
		if(result > 0) {
			page = "/detail.recruit?rNo=" + rNo;
		}else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
