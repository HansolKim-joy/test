package create.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import create.model.service.CreateService;
import create.model.vo.Create;
import member.model.vo.Member;

/**
 * Servlet implementation class CreateInsertServlet
 */
@WebServlet("/insert.cr")
public class CreateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String bTitle = request.getParameter("creW_createName");
		String cDirector = request.getParameter("creW_directorName");
		String content = request.getParameter("editor_content");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser"); 
		String writer = loginUser.getUserId(); 
		
		//파일 추가하기
		Create c = new Create();
		c.setbTitle(bTitle);
		c.setcDirector(cDirector);
		c.setbContent(content);
		c.setbWriter(writer);
		
		
		int result = new CreateService().insertCreate(c);
		
		if(result>0) {
			response.sendRedirect("list.cr");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "창작게시물 등록에 실패했습니다.");
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
