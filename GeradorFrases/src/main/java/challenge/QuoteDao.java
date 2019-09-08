package challenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteDao {

	public Quote getQuote() throws SQLException {

		String query = "SELECT actor, detail from scripts";
		return newQuote(query, null);
	}

	public Quote getQuoteByActor(String actor) throws SQLException {

		String query = "SELECT actor, detail from scripts WHERE actor = ?";
		return newQuote(query, actor);

	}

	private Quote newQuote(String query, String actor) throws SQLException {

		Connection conn = ConnectionFactory.createConnection();
		PreparedStatement st = conn.prepareStatement(query);

		if (actor != null) {
			st.setString(1, actor);
		}

		List<Quote> quotes = new ArrayList<>();

		ResultSet rs;

		rs = st.executeQuery();

		while (rs.next()) {
			Quote quote = new Quote();
			quote.setActor(rs.getString("actor"));
			quote.setQuote(rs.getString("detail"));

			quotes.add(quote);
		}

		Random rand = new Random();

		return quotes.get(rand.nextInt(quotes.size()));
	}

}
