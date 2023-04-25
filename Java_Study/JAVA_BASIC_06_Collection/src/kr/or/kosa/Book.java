package kr.or.kosa;

import java.util.*;

public class Book {
	final String bookNo;
	String bookTitle;
	int price;
	
	
	public Book(String bookNo, String bookTitle, int price) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.price = price;
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}


	public int getPrice() {
		return price;
	}
	
}

/*
 package kr.or.kosa;

public class Book {
	private int isbn;
	private String bookName;
	private int bookPrice;	
	
	public Book(int isbn, String bookNam
	e, int bookPrice) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
	public int getIsbn() {
		return isbn;
	}//
	
	public String getBookName() {
		return bookName;
	}
	
	public int getBookPrice() {
		return bookPrice;
	}
	
}
 */

