package altService.sys.member.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.exception.LoginFailException;
import altService.sys.member.service.MemberManageVO;
import altService.sys.member.service.MemberService;
import altService.utils.PageMaker;
import altService.utils.SearchCriteria;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mMapper;
	
	@Override
	public MemberManageVO login(MemberManageVO vo) throws SQLException, LoginFailException {
		MemberManageVO member = null;
		member = mMapper.login(vo);
		
		/* 로그인 실패시 잠금회수 추가하기 */
		if(member == null) {
			int lockCnt = mMapper.selectMemberLockCnt(vo.getEmplyr_id());
			if(lockCnt < 5) {
				mMapper.updateMemberLockCnt(vo.getEmplyr_id());
				throw new LoginFailException("ID와 PW를 다시 입력해주십시오.\\n로그인 시도 회수 : " + lockCnt + "/5회 오류입니다. 5번 이상 로그인 오류시 계정이 잠깁니다.");				
			} else {
				throw new LoginFailException("잠겨진 계정입니다. 관리자에게 문의하십시오.");				
			}
		}
		
		return member;
	}

	@Override
	public void registMemberManage(Map<String, Object> paramMap) throws SQLException {
		MemberManageVO vo = (MemberManageVO) paramMap.get("vo");
		mMapper.insertMemberManage(vo);
	}

	@Override
	public Map<String, Object> getMemberManageList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap = new HashMap<>();
		List<MemberManageVO> list = null;
		int totalCount = 0;
		
		list = mMapper.selectMemberManageList(cri);
		totalCount = mMapper.selectMemberManageListCnt(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("list", list);
		dataMap.put("cri", cri);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public MemberManageVO getMemberManageDetail(MemberManageVO vo) throws SQLException {
		MemberManageVO resVO = null;
		resVO = mMapper.selectMemberManageDetail(vo);
		return resVO;
	}

	@Override
	public void deleteMemberManage(String ids) throws SQLException {
		String id = "";
		String[] idArray = ids.split(",");
		for(int i = 0; i < idArray.length; i++) {
			id = idArray[i];
			mMapper.deleteMemberManage(id);
		}
	}

	@Override
	public boolean getMemeberDupleCheck(String id) throws SQLException {
		boolean flag = false;
		int count = mMapper.selectCheckDupleId(id);
		if(count == 0) flag = true;
		return flag;
	}

	@Override
	public void modifyMemberManage(Map<String, Object> paramMap) throws SQLException {
		MemberManageVO vo = (MemberManageVO) paramMap.get("vo");
		/* 초기화시 로그인 실패 횟수 초기화 */
		if(vo.getEmplyr_sttus_code().equals("i")) {
			vo.setLock_cnt(0);
			vo.setPassword("9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0");
			vo.setPassword_cnsr("");
			vo.setPassword_hint("");
		}
		mMapper.updateMemberManage(vo);
	}

	@Override
	public void registMemberManageByExcel(List<MemberManageVO> list) throws SQLException {
		for(int i = 0; i < list.size(); i++) {
			String id = list.get(i).getEmplyr_id();
			int count = mMapper.selectCheckDupleId(id);
			
			if(id != "" && count == 0) {
				mMapper.insertMemberManage(list.get(i));
			}
		}
		/*for(MemberManageVO vo : list) {
			String id = vo.getEmplyr_id();
			System.out.println(id);
			중복체크후 insert
			int count = mMapper.selectCheckDupleId(id);
			if(vo.getEmplyr_id() != "" && count == 0) {
				mMapper.insertMemberManage(vo);
			}
		}*/
	}
}
