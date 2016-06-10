package miffy;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.jdo.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.LoginIdPass;
import model.LoginLogic;
import model.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String url = req.getParameter("url");
		String comment = req.getParameter("comment");
		Date date = Calendar.getInstance().getTime();
		LinkData data = new LinkData(title, url, comment, date);

		// PersistenceManagerFactory factory = PMF.get();
		javax.jdo.PersistenceManagerFactory factory = PMF.get();
		javax.jdo.PersistenceManager manager = factory.getPersistenceManager();
		// PersistenceManager manager = factory.getPersistenceManager();

		try {
			manager.makePersistent(data);
		} finally {
			manager.close();
		}
		resp.sendRedirect("/index.html");*/
		
		req.setCharacterEncoding("UTF-8");
        //String name = request.getParameter("name");
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        LoginIdPass lIdPass = new LoginIdPass(id,pass);
        LoginLogic loginLogic = new LoginLogic();
        boolean result = loginLogic.execute(lIdPass);
        
        User user;
        if(result){
            user = new User(id,pass);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", user);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/loginResult.jsp");
        dispatcher.forward(req, resp);
	}
}
