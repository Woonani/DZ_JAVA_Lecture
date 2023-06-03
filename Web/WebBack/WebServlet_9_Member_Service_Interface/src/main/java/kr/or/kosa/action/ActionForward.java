package kr.or.kosa.action;

/*
 Servlet (client) 요청 
 
 1. 화면을 주세요 (UI 경로)
 2. 처리해 주세요 (Service) 
 
 화면 아니면 로직 처리
 */

public class ActionForward {
	private boolean isRedirect=false; // 뷰의 전환 (redirect or forward) 
	//리다이렉트는 페이지 주소가 바뀜 / 리다이렉트 =location.뭐시기로  >> but 우리가 원하는 건  forwarding 해주고싶음
	// 주소창에 주소가 바뀌냐 안바뀌냐
	// 리다이렉트와 포워드의 차이?
	private String path=null; // 이동경로 (뷰의주소)
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
