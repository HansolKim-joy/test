package recruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import recruit.model.service.recruitService;
import recruit.model.vo.Recruit;

/**
 * Servlet implementation class recruitInsertServlet
 */
@WebServlet("/insert.recruit")
public class recruitWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recruitWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("recW_recruitName");
		String content = request.getParameter("editor_content");
		String rHead = request.getParameter("recW_type");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser"); 
		String writer = loginUser.getUserId(); 

		Recruit r = new Recruit();

		r.setbTitle(title);
		r.setbContent(content);
		r.setrHead(rHead);
		r.setUserId(writer);
		
		int result = new recruitService().insertRecruit(r);
		
		if(result > 0) {
			response.sendRedirect("list.recruit?currentPage=1");
		}else {
			request.setAttribute("msg", "게시글 작성에 실패하였습니다.");
			request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
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
