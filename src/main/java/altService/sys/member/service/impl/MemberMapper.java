package altService.sys.member.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import altService.sys.member.service.MemberManageVO;
import altService.utils.SearchCriteria;

@Repository("MemberMapper")
public interface MemberMapper {
	
	public MemberManageVO login(MemberManageVO vo) throws SQLException;

	public void insertMemberManage(MemberManageVO vo) throws SQLException;
	
	public List<MemberManageVO> selectMemberManageList(SearchCriteria cri) throws SQLException;
	
	public int selectMemberManageListCnt(SearchCriteria cri) throws SQLException;
	
	public MemberManageVO selectMemberManageDetail(MemberManageVO vo) throws SQLException;

	public void deleteMemberManage(String id) throws SQLException;

	public int selectCheckDupleId(String id) throws SQLException;

	public void updateMemberManage(MemberManageVO vo) throws SQLException;
	
	public void updateMemberLockCnt(String emplyr_id) throws SQLException;
	
	public int selectMemberLockCnt(String emplyr_id) throws SQLException;
	
}