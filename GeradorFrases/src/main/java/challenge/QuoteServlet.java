package challenge;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = "/v1/quote/*")
public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuoteDao quoteDao = new QuoteDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter out = resp.getWriter();

			Quote quote;
			String pathInfo = req.getPathInfo();

			if (pathInfo == null || pathInfo.equals("/")) {

				quote = quoteDao.getQuote();

			} else {
				String actor = pathInfo.split("/")[1];

				quote = quoteDao.getQuoteByActor(actor);

			}

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			out.print(quote.toString());
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
