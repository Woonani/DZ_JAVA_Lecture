package kr.or.kosa;

import java.util.*;

public class BookManager {
//	List<Book> books; 
	HashMap<String,Book> books;
	
	public BookManager() {
		super();
		this.books = new HashMap<>();
	}
	
	public void Run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료");
			System.out.println("메뉴번호 입력 : ");
			String selectedMenu = sc.nextLine();
			switch(selectedMenu) {
			case "1" : // 도서추가
				System.out.println("추가할 도서 ISBN: ");
				String bookNo = sc.nextLine();
				System.out.println("도서 제목: ");
				String bookTitle = sc.nextLine();
				System.out.println("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				addBook(bookNo, bookTitle, price);
				System.out.printf("ISBN:%s 이름:%s 가격:%d 생성하였습니다.\n", bookNo, bookTitle, price);
				break;
			case "2" : 
				// 도서삭제
				System.out.println("삭제할 도서 ISBN: ");
				String bookNo2 = sc.nextLine();
				for(String isbn : books.keySet()) {
					if(isbn.equals(bookNo2)) {
						books.remove(isbn);
						System.out.printf("삭제하였습니다");
						break;
					}
				}
				
				break;
			case "3" : 
				// 도서 검색
				System.out.print("검색할 도서 ISBN:");
				String isbn2 = sc.nextLine();
				for(String isbn : books.keySet()) {
					if(isbn.equals(isbn2)) {
						System.out.printf("검색 결과>>ISBN:%s 이름:%s 가격:%d\n", isbn, books.get(isbn).bookTitle, books.get(isbn).price);
						break;
					}
				}
				break;
			case "4" : 
				// 도서 목록 조회
				System.out.printf("도서목록 \n 도서 수 : %d \n", books.size());
				for(String isbn :books.keySet()) { //*********************
					System.out.printf(" ISBN:%s 이름:%s 가격:%d \n",isbn, books.get(isbn).bookTitle, books.get(isbn).price );
				}
				break;
			case "5" : 
				// ISBN 목록 조회
				System.out.printf("ISBN 목록 \n 도서 수 : %d \n", books.size());
				for(String isbn : books.keySet()) {
					System.out.println(isbn);
				}
				break;
			case "0" : 
				// 종료
				System.out.println("도서시스템을 종료합니다.");
				System.exit(0);
				break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	
	void addBook(String bookNo, String bookTitle, int price) {
		this.books.put(bookNo, new Book(bookNo, bookTitle, price));
	}
}
/*
 // 반장님의 깔끔한 코드
  * 
  * package kr.or.kosa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BookManager {
	private HashMap<Integer, Book> books;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public BookManager() {
		this.books = new HashMap<>();
	}
	
	
	public void run() throws NumberFormatException, IOException {
		
		boolean runState = true;
		while(runState) {			
			System.out.println("1:추가\t2:삭제\t3:검색\t4:도서 목록\t5:ISBN 목록\t 0:종료");
			System.out.println("원하시는 메뉴번호를 입력하세요");
			int inputValue = Integer.parseInt(br.readLine());
			switch(inputValue) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: showBookList(); break;
			case 5: showIsbnList(); break;
			case 0: runState = false; break;
			default: System.out.println("잘못된 값입니다");
			}	
		}
	}
	
	private void addBook() throws IOException {
		System.out.print("추가할 도서(ISBN) : ");
		int isbn = Integer.parseInt(br.readLine());
		if(!books.containsKey(isbn)) {
			System.out.println("해당 도서가 이미 존재합니다");
		} else {
			System.out.print("도서 제목 : ");
			String bookName = br.readLine();
			System.out.print("가격 : ");
			int bookPrice = Integer.parseInt(br.readLine());
			books.put(isbn, new Book(isbn, bookName, bookPrice));
			System.out.printf("ISBN:%d 이름:%s 가격:%d 생성하였습니다.\n",isbn, bookName, bookPrice);		
		}
	}
	
	private void removeBook() throws NumberFormatException, IOException {
		System.out.print("삭제할 도서의 ISBN : ");
		int isbn = Integer.parseInt(br.readLine());
		if(books.containsKey(isbn)) {
			books.remove(isbn);
			System.out.println("해당 도서를 삭제하였습니다");
			System.out.println("삭제된 도서 ISBN : " + isbn);
		} else {
			System.out.println("해당 도서가 없습니다.");
		}
	}
	
	private void findBook() throws NumberFormatException, IOException {
		System.out.print("검색할 도서의 ISBN : ");
		int isbn = Integer.parseInt(br.readLine());
		if(books.containsKey(isbn)) {
			System.out.printf("검색 결과>> ISBN:%d 이름:%s 가격:%d\n",isbn, books.get(isbn).getBookName(),books.get(isbn).getBookPrice());
		} else {
			System.out.println("해당 도서가 없습니다.");
		}
	}
	
	private void showBookList() {
		System.out.println("도서목록");
		System.out.println("도서 수 : "+ books.size());
		for (int i : books.keySet()) {
			System.out.printf("ISBN:%d 이름:%s 가격:%d\n", books.get(i).getIsbn(), books.get(i).getBookName(), books.get(i).getBookPrice());			
		}
	}
	private void showIsbnList() {
		System.out.println("도서목록");
		System.out.println("도서 수 : "+ books.size());
		for (int i : books.keySet()) {
			System.out.printf("ISBN:%d\n", books.get(i).getIsbn());			
		}
	}
}
 */
