package kr.or.kosa.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

public class memoListServiceAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {

		MemoDao dao = new MemoDao();
		ActionForward forward = new ActionForward();

		List<Memo> memolist;

		try {
			memolist = dao.getMemoList();

			System.out.println("메모리스트 서비스 memolist : " + memolist.toString());

			request.setAttribute("memolist", memolist);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forward.setRedirect(false); // forward 방식으로 ....

		forward.setPath("/memolist.jsp");
		System.out.println("메모리스트 서비스 : " + forward);
		System.out.println("메모리스트 서비스 forward : " + forward);
		return forward;

	}
}
