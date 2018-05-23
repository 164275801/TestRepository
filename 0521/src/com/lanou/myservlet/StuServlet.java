package com.lanou.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuServlet extends HttpServlet {
	static {
		System.out.println(123123);
	}

	public StuServlet() {
		super();
	}

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取操作参数
		String md = request.getParameter("method");
		System.out.println(md);
		String ph = null;
		if (null != md) {
			if (md.equals("addStu")) {
				ph = addStu(request, response);
			} else if (md.equals("delStu")) {
				ph = delStu(request, response);
			} else if (md.equals("updateStu")) {
				ph = updateStu(request, response);
			} else if (md.equals("findStu")) {
				ph = findStu(request, response);
			}
		}
		if (null != ph) {
			request.getRequestDispatcher(ph).forward(request, response);
		}

	}

	private String findStu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/success.jsp";
	}

	private String updateStu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("updateOK");
		return null;
	}

	private String delStu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/success.jsp";
	}

	private String addStu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("addStu");
		return "/success.jsp";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		super.destroy();
	}
}
