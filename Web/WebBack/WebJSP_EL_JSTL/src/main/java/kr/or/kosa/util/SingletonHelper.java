package kr.or.kosa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SingletonHelper {
	
	private static Connection conn = null; //public > private
	private SingletonHelper() {}
	
	 public static Connection getConnection(String dsn) throws ClassNotFoundException {
		 
		   if(conn != null) {
			   System.out.println("conn : " + conn);
			   return conn;
		   }
		   	   
		   try {
			   		if(dsn.equals("oracle")) {
						  Class.forName("oracle.jdbc.OracleDriver");
			   			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			   		}else if(dsn.equals("mariadb")) {
						  Class.forName("com.mysql.cj.jdbc.Driver");
			   			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb","kosa","1004");
			   		}
		   		} catch (Exception e) {
		   			System.out.println(e.getMessage());
		   		}
		   return conn;
	   }
	   
	   public static Connection getConnection(String dsn , String id , String pwd) {
		   Connection conn = null;
		   try {
			   		if(dsn.equals("oracle")) {
			   			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
			   		}else if(dsn.equals("mariadb")) {
			   			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb",id,pwd);
			   		}
		   		} catch (Exception e) {
		   			System.out.println(e.getMessage());
		   		}
		   return conn;
	   }
	   
	   // 과제 2를 위한 함수
	   public static Connection getConnection(String dsn , String dbn, String id , String pwd) {
		   if(conn != null) {
			   System.out.println("conn : " + conn);
			   return conn;
		   }
		   try {
			   		if(dsn.equals("oracle")) {
			   			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
			   		}else if(dsn.equals("mariadb")) {
			   			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/"+dbn,id,pwd);
			   		}
		   		} catch (Exception e) {
		   			System.out.println(e.getMessage());
		   		}
		   return conn;
	   }
	   
	   public static void dbClose() {
		   if(conn != null) {
			   try {
				   conn.close(); //연결해제(DB연결 끊기)
				   conn = null; //참조해제 (null)
			} catch (Exception e) {
				  System.out.println(e.getMessage());
			}
		   }
	   }
	   
	   public static void close(Connection conn) {
		   if(conn != null) {
			   try {
				   conn.close(); //연결해제(DB연결 끊기)
				  
			} catch (Exception e) {
				  System.out.println(e.getMessage());
			}
		   }
	   }
	   public static void close(ResultSet rs) {
		   if(rs != null) {
			   try {
				   rs.close();
			} catch (Exception e) {
				  System.out.println(e.getMessage());
			}
		   }
	   }
	   public static void close(Statement stsmt) {
		   if(stsmt != null) {
			   try {
				   stsmt.close();
			} catch (Exception e) {
				  System.out.println(e.getMessage());
			}
		   }
	   }
	   public static void close(PreparedStatement pstmt) {
		   if(pstmt != null) {
			   try {
				   pstmt.close();
			} catch (Exception e) {
				  System.out.println(e.getMessage());
			}
		   }
	   }
}



//package kr.or.kosa.utils;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class SingletonHelper {
//	/* 처음에 한 것 : null 처리를 하지 않음
//	private static SingletonHelper sh = new SingletonHelper();
//	
//	private SingletonHelper() {}
//	
//	public static SingletonHelper getSH() {
//		return sh;
//	}
//	///////////////////수정 후/////////////////////////////
//	private static SingletonHelper instance = null;
//	
//	private SingletonHelper() {}
//	
//	public static SingletonHelper get() {
//		if(instance == null) {
//			instance = new SingletonHelper();
//		}
//		return instance;
//	
//	*/
//	private static Connection conn = null; //public > private
//	private SingletonHelper() {}
//	
//	 public static Connection getConnection(String dsn) {
//		   if(conn != null) {
//			   System.out.println("conn : " + conn);
//			   return conn;
//		   }
//		   	   
//		   try {
//			   		if(dsn.equals("oracle")) {
//			   			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
//			   		}else if(dsn.equals("mariadb")) {
//			   			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb","kosa","1004");
//			   		}
//		   		} catch (Exception e) {
//		   			System.out.println(e.getMessage());
//		   		}
//		   return conn;
//	   }
//	   
//	   public static Connection getConnection(String dsn , String id , String pwd) {
//		   Connection conn = null;
//		   try {
//			   		if(dsn.equals("oracle")) {
//			   			conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
//			   		}else if(dsn.equals("mariadb")) {
//			   			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb",id,pwd);
//			   		}
//		   		} catch (Exception e) {
//		   			System.out.println(e.getMessage());
//		   		}
//		   return conn;
//	   }
//	   /*
//	    public static Connection getConnection(String dsn) {
//			Connection conn = null;
//			try {
//				if(dsn.equals("oracle")) {
//					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
//					// conn인터페이스 리턴
//				} else if (dsn.equals("mariadb")) {
//					conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb","kosa","1004");
//					
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			return conn;
//
//		}
//
//		// 계정이 바뀌는 경우를 위한 오버로딩
//		public static Connection getConnection(String dsn, String id, String pwd) { 
//			Connection conn = null;
//			try {
//				if(dsn.equals("oracle")) {
//					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",id,pwd);
//					// conn인터페이스 리턴
//				} else if (dsn.equals("mariadb")) {
//					conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb",id,pwd);
//					
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			return conn;
//			
//		}
//	    */
//	   //////////////////////////
//	   public static void dbClose() {  ///////////////////////// dpd dlrjteh cnrkehla
//		   if(conn != null) {
//			   try {
//				   conn.close(); //연결해제(DB연결 끊기)
//				   conn = null; //참조해제 (null)
//			} catch (Exception e) {
//				  System.out.println(e.getMessage());
//			}
//		   }
//	   }
//	   
//	   public static void close(Connection conn) {
//		   if(conn != null) {
//			   try {
//				   conn.close(); //연결해제(DB연결 끊기)
//				  
//			} catch (Exception e) {
//				  System.out.println(e.getMessage());
//			}
//		   }
//	   }
//	   public static void close(ResultSet rs) {
//		   if(rs != null) {
//			   try {
//				   rs.close();
//			} catch (Exception e) {
//				  System.out.println(e.getMessage());
//			}
//		   }
//	   }
//	   public static void close(Statement stsmt) {
//		   if(stsmt != null) {
//			   try {
//				   stsmt.close();
//			} catch (Exception e) {
//				  System.out.println(e.getMessage());
//			}
//		   }
//	   }
//	   public static void close(PreparedStatement pstmt) {
//		   if(pstmt != null) {
//			   try {
//				   pstmt.close();
//			} catch (Exception e) {
//				  System.out.println(e.getMessage());
//			}
//		   }
//	   }
//}
//
//
//
//
//
