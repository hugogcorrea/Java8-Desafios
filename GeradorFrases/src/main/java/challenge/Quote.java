package challenge;

public class Quote {

	

	private String actor;
	private String quote;

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getActor() {
		return actor;
	}

	public String getQuote() {
		return quote;
	}
	
	@Override
	public String toString() {
		return "{\"actor\":\"" + actor + "\",\"quote\":\"" + quote + "\"}";
	}

}
