package core.memberlog;

import core.member.Member;

public class MemberLog {
	private int logId;
	private Member member;
	private String logDate;
	private String logMode;
	
	public MemberLog(int logId, Member member, String logDate, String logMode) {
		this.logId = logId;
		this.member = member;
		this.logDate = logDate;
		this.logMode = logMode;
	}

	public int getLogId() {
		return logId;
	}

	public Member getMember() {
		return member;
	}

	public String getLogDate() {
		return logDate;
	}

	public String getLogMode() {
		return logMode;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public void setLogMode(String logMode) {
		this.logMode = logMode;
	}

	@Override
	public String toString() {
		return "MemberLog [logId=" + logId + ", " + member + ", logDate=" + logDate + ", logMode=" + logMode
				+ "]";
	}
	
	
}
