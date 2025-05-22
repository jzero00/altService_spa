package altService.sys.authorRole.service;

import java.util.Date;

public class AuthorRoleManageVO {

	private String author_code;
	private String role_code;
	private Date creat_dt;

	public String getAuthor_code() {
		return author_code;
	}

	public void setAuthor_code(String author_code) {
		this.author_code = author_code;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public Date getCreat_dt() {
		return creat_dt;
	}

	public void setCreat_dt(Date creat_dt) {
		this.creat_dt = creat_dt;
	}

}