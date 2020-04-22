package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import common.wrapper.LockPassWord;

/**
 * Servlet Filter implementation class LockPassWordFilter
 */
@WebFilter(
		servletNames = { 
				"LoginServlet", 
				"InsertMemberServlet", 
				"memberCheckServlet",
				"PresentPwdCheckServlet"
		})
public class LockPassWordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LockPassWordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest hsr = (HttpServletRequest)request;
		LockPassWord lpw = new LockPassWord(hsr);
		// pass the request along the filter chain
		chain.doFilter(lpw, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
