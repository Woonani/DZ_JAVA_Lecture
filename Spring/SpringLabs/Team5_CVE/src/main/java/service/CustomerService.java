package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.EmpDao;
import dao.NoticeDao;
import vo.Emp;
import vo.Notice;

@Service
public class CustomerService {
	// CustomerService 는 SqlSessionTemplate 에 의존합니다
	// SqlSessionTemplate 구현하는 인터페이스 SqlSession

	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	// 전체사원 테이블 조회
	public List<Emp> getEmp() {

		
		// DAO 작업
		// DAO 작업 예외 throws ClassNotFoundException, SQLException
		List<Emp> list = null;
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////
			// EmpDao인터페이스를 구현하고 있는 xml을 empdao에 담는다.

			list = empdao.getEmp();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	// 사원 번호로 사원검색
	public Emp getEmpByEmpno(int empno) {
		 Emp emp = null;
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////
			emp = empdao.getEmpByEmpno(empno);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;

	}
	
	public int empinsert(Emp emp) {
		int result =0;
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////
			result = empdao.insert(emp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

		
	}
	
	

//	public String noticeReg(Notice n, HttpServletRequest request) {
//
//		List<CommonsMultipartFile> files = n.getFiles();
//		List<String> filenames = new ArrayList<String>(); // 파일명들 담을 List
//
//		if (files != null && files.size() > 0) { // 1개라도 업로드 된 파일이 있다면
//			for (CommonsMultipartFile multifile : files) {
//				String filename = multifile.getOriginalFilename();
//				String path = request.getServletContext().getRealPath("/customer/upload"); // 배포된 서버 경로
//				String fpath = path + "\\" + filename;
//				System.out.println(fpath);
//
//				if (!filename.equals("")) { // 실제 파일 업로드
//					FileOutputStream fs = null;
//					System.out.println("11111111111");
//					try {
//						System.out.println("22222222222222");
//						fs = new FileOutputStream(fpath);
//						System.out.println("33333333333333333");
//						fs.write(multifile.getBytes());
//						// 파일 이름 추출 (DB insert)
//						filenames.add(filename);
//						System.out.println("444444444444444");
//						//
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} finally {
//						try {
//							fs.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}
//		//위의 과정
//		//파일 배포경로에 생성하고
//		//파일 명 Notice vo에 set하기
//		
//		n.setFileSrc(filenames.get(0));
//		n.setFileSrc2(filenames.get(1));
//
//		try {
//			////////////////////////////////////////////////////////////
//			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
//			////////////////////////////////////////////////////////////
//			// NoticeDao 구현하는 xml의 주소 받기
//			
//			
//			noticedao.insert(n); // DB insert
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return "redirect:notice.htm";
//	}
	
	
	
	
	//Emp Table 수정하기
	public int noticeEdit(Emp emp) {
		
		int result = 0;
		
		try {
			////////////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			////////////////////////////////////////////////////////////
			result = empdao.update(emp);
		} catch (ClassNotFoundException e ) {
				e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		}
				
	    return result;
	
	}
	
	
	
//	public String noticeEdit(Notice n , HttpServletRequest request) {
//		  //파일 업로드 가능
//		List<CommonsMultipartFile> files = n.getFiles();
//		List<String> filenames = new ArrayList<String>(); //파일명들 관리
//		
//		if(files != null && files.size() > 0) { //1개라도 업로드 된 파일이 있다면
//			for(CommonsMultipartFile multifile : files) {
//				 	String filename =multifile.getOriginalFilename();
//					String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
//					String fpath = path + "\\" + filename;
//					System.out.println(fpath);
//					
//				if(!filename.equals("")) { //실제 파일 업로드 
//					FileOutputStream fs =null;
//					try {
//						     fs = new FileOutputStream(fpath);
//						     fs.write(multifile.getBytes());
//						     
//						     //파일 이름 추출  (DB insert)
//						     filenames.add(filename); 
//						     //
//						     
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}finally {
//						 try {
//							fs.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}
//			   
//		
//		//파일명 (DTO)
//		//List<String> filenames = new ArrayList<String>();  
//		//[0] > 1.jpg
//		//[1] > 2.jpg
//		n.setFileSrc(filenames.get(0));
//		n.setFileSrc2(filenames.get(1));
//	
//		try {
//				
//				////////////////////////////////////////////////////////////
//				NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
//				////////////////////////////////////////////////////////////
//				noticedao.update(n);  //DB update
//			} catch (Exception e) {
//				e.printStackTrace();
//			} 
//	//처리가 끝나면 상세 페이지로 : redirect  글번호를 가지고 ....
//	return "redirect:noticeDetail.htm?seq="+n.getSeq();    //서버에게 새 요청 ....
//	}
//	
//	public String noticeDel(String seq) {
//		////////////////////////////////////////////////////////////
//		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
//		////////////////////////////////////////////////////////////
//		try {
//			  noticedao.delete(seq);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:notice.htm";
//	}
//	
//	// 파일 다운로드 서비스 함수
//		public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//
//				String fname = new String(f.getBytes("euc-kr"), "8859_1");
//				response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");
//
//				String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
//				System.out.println(fullpath);
//				FileInputStream fin = new FileInputStream(fullpath);
//
//				ServletOutputStream sout = response.getOutputStream();
//				byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
//				int size = 0;
//				while ((size = fin.read(buf, 0, buf.length)) != -1) {
//					sout.write(buf, 0, size);
//				}
//				fin.close();
//				sout.close();
//			}

}
