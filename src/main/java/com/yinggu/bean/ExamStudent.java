package com.yinggu.bean;


public class ExamStudent {

	private int FlowID;
	private int Type;
	private String IDCard;
	private String ExamCard;
	private String StudentName;
	private String Location;
	private int Grade;

	@Override
	public String toString() {
		return "ExamStudent [FlowID=" + FlowID + ", Type=" + Type + ", IDCard=" + IDCard + ", ExamCard=" + ExamCard
				+ ", StudentName=" + StudentName + ", Location=" + Location + ", Grade=" + Grade + "]";
	}

	public ExamStudent() {
		super();
	}

	public ExamStudent(int flowID, int type, String iDCard, String examCard, String studentName, String location,
			int grade) {
		super();
		FlowID = flowID;
		Type = type;
		IDCard = iDCard;
		ExamCard = examCard;
		StudentName = studentName;
		Location = location;
		Grade = grade;
	}

	public int getFlowID() {
		return FlowID;
	}

	public void setFlowID(int flowID) {
		FlowID = flowID;
	}

	public int getType() {
		return Type;
	}

	public void setType(int Type) {
		this.Type = Type;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getExamCard() {
		return ExamCard;
	}

	public void setExamCard(String examCard) {
		ExamCard = examCard;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

}
