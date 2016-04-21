package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberQuery
 */
@WebServlet(description = "用户查询类", urlPatterns = { "/MemberQuery" })
public class MemberQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		String memberName = request.getParameter("MemberName");
		String memberEmail = request.getParameter("MemberEmail");
		Member queryFilter = new Member(memberName, memberEmail, "");
		
		ArrayList<Member> memberList = Member.QueryMembers ("MemberDB.txt",
				queryFilter);
		 
		
		PrintWriter out = response.getWriter();

		ServletContext application=this.getServletContext();
		
	 
		 
		for (Member a : memberList) {//展示所有查询到的记录
			out.println(a.toString() + "</br></br>");
		}

		 
		 
	}

}
