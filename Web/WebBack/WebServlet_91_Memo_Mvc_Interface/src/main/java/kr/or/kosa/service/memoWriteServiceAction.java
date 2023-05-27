package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

public class memoWriteServiceAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memo = request.getParameter("memo");
		//out.print(id + "," + email + "," + memo);
  	  
		ActionForward forward = null;
  	  
  	    try{
  	    	MemoDao dao = new MemoDao();
  		    int n = dao.insertMemo(new Memo(id,email,memo));
  	   
	  	    if(n>0){
			 	/*
			  	 * out.print("<script>"); out.print("alert('등록성공..');");
				 * out.print("location.href='MemoList';"); //jsp >> /MemoList //주소창에 입력 enter
				 * (F5) 요청 //localhost:8090/WebServlet_3/MemoList out.print("</script>");
				 */
	  		 
	  	     }
  	   
  	     }catch(Exception e){
			 /*
			  * out.print("<script>"); out.print("alert('등록실패..');");
			  * out.print("location.href='memo.html';"); out.print("</script>");
			  * out.print("<b> 오류 :" + e.getMessage() + "</b>");
			  */
  	          System.out.println("e : "+ e);
  	     }
  	  
		 forward = new ActionForward();
		 forward.setRedirect(false); // forward 방식으로 ....
		 forward.setPath("/memo.html");
			
		 return forward;
	}
}
