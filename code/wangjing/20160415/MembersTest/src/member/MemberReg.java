package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberReg
 */
@WebServlet(description = "用户注册类", urlPatterns = { "/MemberReg" })
public class MemberReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberReg() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		
		String memberName = request.getParameter("MemberName");
		String memberEmail = request.getParameter("MemberEmail");
		String memberPasswd = request.getParameter("MemberPasswd");

		   
		
		Member  aMember = new Member (memberName,memberEmail,memberPasswd);

		if(!aMember.CheckEmailValid(memberEmail)){//检测Email合法性
			out.println("Email invalid!");
			out.close();
			return;
		}
		
		if(! aMember.CheckEmailNoneExist(memberEmail)){//检测Email是否重复
			out.println("Email Exist!");
			out.close();
			return;
		}
		  String res=Member.MemberInsert ("MemberDB.txt",aMember.toString());
		  out.println(res);
		 
	}
}
