package altService.sys.author.service;

import java.util.Date;

public class AuthorManageVO {

	private String author_code;
	private String author_nm;
	private String author_dc;
	private Date author_creat_de;

	public String getAuthor_code() {
		return author_code;
	}

	public void setAuthor_code(String author_code) {
		this.author_code = author_code;
	}

	public String getAuthor_nm() {
		return author_nm;
	}

	public void setAuthor_nm(String author_nm) {
		this.author_nm = author_nm;
	}

	public String getAuthor_dc() {
		return author_dc;
	}

	public void setAuthor_dc(String author_dc) {
		this.author_dc = author_dc;
	}

	public Date getAuthor_creat_de() {
		return author_creat_de;
	}

	public void setAuthor_creat_de(Date author_creat_de) {
		this.author_creat_de = author_creat_de;
	}

}