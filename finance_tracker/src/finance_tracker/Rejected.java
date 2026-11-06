package finance_tracker;

public final class Rejected implements ApprovalDecision {

	@Override
	public ExpenditureStatus checkStatus(Expenditure expenditure) {
		// TODO Auto-generated method stub
		return ExpenditureStatus.REJECTED;
	}

}
