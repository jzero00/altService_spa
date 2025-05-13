package altService.sys.menuManage.service;

public class MenuManageVO {

	private String menu_nm;
	private String progrm_file_nm;
	private String menu_no;
	private int upper_menu_no;
	private int menu_ordr;
	private String menu_dc;
	private String relate_image_path;
	private String relate_image_nm;

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getProgrm_file_nm() {
		return progrm_file_nm;
	}

	public void setProgrm_file_nm(String progrm_file_nm) {
		this.progrm_file_nm = progrm_file_nm;
	}

	public String getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}

	public int getUpper_menu_no() {
		return upper_menu_no;
	}

	public void setUpper_menu_no(int upper_menu_no) {
		this.upper_menu_no = upper_menu_no;
	}

	public int getMenu_ordr() {
		return menu_ordr;
	}

	public void setMenu_ordr(int menu_ordr) {
		this.menu_ordr = menu_ordr;
	}

	public String getMenu_dc() {
		return menu_dc;
	}

	public void setMenu_dc(String menu_dc) {
		this.menu_dc = menu_dc;
	}

	public String getRelate_image_path() {
		return relate_image_path;
	}

	public void setRelate_image_path(String relate_image_path) {
		this.relate_image_path = relate_image_path;
	}

	public String getRelate_image_nm() {
		return relate_image_nm;
	}

	public void setRelate_image_nm(String relate_image_nm) {
		this.relate_image_nm = relate_image_nm;
	}

	@Override
	public String toString() {
		return "MenuManageVO [menu_nm=" + menu_nm + ", progrm_file_nm=" + progrm_file_nm + ", menu_no=" + menu_no
				+ ", upper_menu_no=" + upper_menu_no + ", menu_ordr=" + menu_ordr + ", menu_dc=" + menu_dc
				+ ", relate_image_path=" + relate_image_path + ", relate_image_nm=" + relate_image_nm + "]";
	}

}