package notice;

public class NoticeInfo {

	private String title; 
	private String contents;
	
	public NoticeInfo (String title, String contents) {
		this.title = title;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContexts() {
		return contents;
	}

	public void setContexts(String contexts) {
		this.contents = contexts;
	}
	
}
