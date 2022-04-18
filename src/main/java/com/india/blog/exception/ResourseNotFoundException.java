package com.india.blog.exception;

public class ResourseNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourseName;
	String resourseFild;
	long resourseId;
	public ResourseNotFoundException(String resourseName, String resourseFild, int resourseId) {
		super(String.format("%s not found with this %s : %s",resourseName,resourseName,resourseId));
		this.resourseName = resourseName;
		this.resourseFild = resourseName;
		this.resourseId = resourseId;
	}
	
	
	
	
}
