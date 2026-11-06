package finance_tracker;

public sealed interface ApprovalDecision permits Approved, Rejected, RequiresReview {
	ExpenditureStatus checkStatus(Expenditure expenditure);

}
