package finance_tracker;

public final class RequiresReview implements ApprovalDecision {

	@Override
	public ExpenditureStatus checkStatus(Expenditure expenditure) {
		// TODO Auto-generated method stub
		return ExpenditureStatus.REQUIRESREVIEW;
	}

}
