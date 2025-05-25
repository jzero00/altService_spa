package altService.sys.authorRole.service;

import java.util.Date;

public class AuthorRoleListDTO {

	private String role_code;
	private String role_nm;
	private String role_dc;
	private String role_ty;
	private String role_sort;
	private Date creat_dt;

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_nm() {
		return role_nm;
	}

	public void setRole_nm(String role_nm) {
		this.role_nm = role_nm;
	}

	public String getRole_dc() {
		return role_dc;
	}

	public void setRole_dc(String role_dc) {
		this.role_dc = role_dc;
	}

	public String getRole_ty() {
		return role_ty;
	}

	public void setRole_ty(String role_ty) {
		this.role_ty = role_ty;
	}

	public String getRole_sort() {
		return role_sort;
	}

	public void setRole_sort(String role_sort) {
		this.role_sort = role_sort;
	}

	public Date getCreat_dt() {
		return creat_dt;
	}

	public void setCreat_dt(Date creat_dt) {
		this.creat_dt = creat_dt;
	}

}