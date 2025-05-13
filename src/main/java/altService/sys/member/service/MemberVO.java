package altService.sys.member.service;

public class MemberVO {

	private String altNo;
	private String memNm;
	private String pwd;
	private String serSdt;
	private String serEdt;
	private int deptNo;
	private int memNo;

	public String getAltNo() {
		return altNo;
	}

	public void setAltNo(String altNo) {
		this.altNo = altNo;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSerSdt() {
		return serSdt;
	}

	public void setSerSdt(String serSdt) {
		this.serSdt = serSdt;
	}

	public String getSerEdt() {
		return serEdt;
	}

	public void setSerEdt(String serEdt) {
		this.serEdt = serEdt;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "MemberVO [altNo=" + altNo + ", memNm=" + memNm + ", pwd=" + pwd + ", serSdt=" + serSdt + ", serEdt="
				+ serEdt + ", deptNo=" + deptNo + ", memNo=" + memNo + "]";
	}
}