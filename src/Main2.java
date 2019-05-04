

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main2
 */
@WebServlet("/Main2")
public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("input");
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd MMMMMMMMMM yyyy");
		String dates = date.format(today);
		PrintWriter pw = response.getWriter();
		
		Pattern p = Pattern.compile("\\b(\\w+)(\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
		 
        Matcher z = p.matcher(name);
        while (z.find()) {
            name = name.replaceAll(z.group(), z.group(1));}
		
		
		pw.print("<body>");
		pw.print("<h1><font size ='7' face = 'Georgia,Arial' color='green'>T</font>ABLE</h1>");
		pw.print("<hr>");
		pw.print("<table border='1' cellpadding='24' cellspacing='3'>");
		pw.print("<tbody><tr bgcolor='silver'>");
		pw.print("<td><center>NO</center></td>");
		pw.print("<td><center>Input</center></td>");
		pw.print("<td><center>Output</center></td>");
		pw.print("<td><center>Tanggal</center></td></tr>");
		pw.print("<tr><td>1</td>");
		pw.print("<td>" + request.getParameter("input") + "</td>");
		pw.print("<td>" + name  +"</td>");
		pw.print("<td>" + dates +"</td></tr>");
		pw.print("</tr></tbody></table>");
		pw.print("</form></body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
