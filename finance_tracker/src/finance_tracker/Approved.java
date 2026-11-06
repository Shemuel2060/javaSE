package finance_tracker;

import java.time.LocalDateTime;

public final class Approved implements ApprovalDecision {
	
	private final String whoDecided;
	private final LocalDateTime whenDecided;
	private final String reason;
	
	public Approved(String decisionMaker, LocalDateTime when, String why){
		this.whoDecided = decisionMaker;
		this.whenDecided = when;
		this.reason = why;
	}

	@Override
	public ExpenditureStatus checkStatus(Expenditure expenditure) {
		// TODO Auto-generated method stub
		return ExpenditureStatus.APPROVED;
	}

	public Approved getDetails() {
		return this;
	}
}
