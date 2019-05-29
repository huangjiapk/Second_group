package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.FiledownloadService;

import net.sf.json.JSONObject;

public class FileSSController extends HttpServlet{
	FiledownloadService fdls=new FiledownloadService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		int power=(int) session.getAttribute("power");
		//System.out.println(power);
		if(power==1) {
			String title=req.getParameter("title");
			resp.setCharacterEncoding("utf8");
			JSONObject files = fdls.SSFile(title,Integer.parseInt(req.getParameter("page")),Integer.parseInt(req.getParameter("rows")));
			PrintWriter pw = resp.getWriter();
			pw.write(files.toString());
			pw.flush();
			pw.close();
		}else {
			boolean flag=false;
			Boolean f =new Boolean(flag);
			PrintWriter pw=resp.getWriter();
			pw.write(f.toString());
			pw.flush();
			pw.close();
		}
		
		
	}

}
