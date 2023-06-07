package com.jquery.ajax.dto;

public class CommentVO {
	
	private int seq; // co_no
	private String comment; // co_contents
	private int bseq; // board_no
 	
	public CommentVO(){}

	public CommentVO(int seq, String comment, int bseq) {
		super();
		this.seq = seq;
		this.comment = comment;
		this.bseq = bseq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	@Override
	public String toString() {
		return "CommentVO [seq=" + seq + ", comment=" + comment + ", bseq=" + bseq + "]";
	}
	
	
	
}
