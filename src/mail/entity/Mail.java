package mail.entity;

public class Mail{
	
	private String tos;
	private String from;
	private String subject;
	private String content;
	
	public Mail(String tos,String from,String sbj,String content) {
		// TODO Auto-generated constructor stub
		this.tos=tos;
		this.from=from;
		this.subject=sbj;
		this.content=content;
	}
	
	public String getTos(){
		return tos;
	}
	public String getFrom(){
		return from;
	}
	public String getSubject(){
		return subject;
	}
	public String getContent(){
		return content;
	}
}