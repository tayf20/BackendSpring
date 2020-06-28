package com.example.demo.dtos;

public class AppResultDto {

	private boolean actionDone = true;
	private String englishMessage = "Action Performed Suucessfully";
	private String arabicMessage = "تمت العملية بنجاح";

	public AppResultDto() {

	}

	public boolean isActionDone() {
		return actionDone;
	}

	public void setActionDone(boolean actionDone) {
		this.actionDone = actionDone;
	}

	public String getEnglishMessage() {
		return englishMessage;
	}

	public void setEnglishMessage(String englishMessage) {
		this.englishMessage = englishMessage;
	}

	public String getArabicMessage() {
		return arabicMessage;
	}

	public void setArabicMessage(String arabicMessage) {
		this.arabicMessage = arabicMessage;
	}

}
