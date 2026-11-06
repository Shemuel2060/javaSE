package finance_tracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureService {
	
	private long REVIEW_THRESHOLD = 200000L;
	public final List<ApprovalDecision> decisionHistory = 
			new ArrayList<>();
	
	public ExpenditureService(long reviewThreshold) {
		this.REVIEW_THRESHOLD = reviewThreshold;
	}
	
	/**
	 * Validates that the expenditure amounts are non-negative
	 * and the reference is not blank or empty.
	 * @param expenditure
	 * @return
	 */
	boolean validateExpenditure(Expenditure expenditure){
		if(expenditure.amountInUgx() <0 || expenditure.reference() == "" 
				|| expenditure.reference().isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	long calculateTotalExpenditure(List<Expenditure> expenditures) {
		
		long total = 0L;
		for(Expenditure expenditure : expenditures) {
			total+=expenditure.amountInUgx();
		}
		return total;
	}
	
	
	boolean requiresAdditionalReview(Expenditure expenditure) {
		if(expenditure.amountInUgx() > REVIEW_THRESHOLD) return true;
		return false;
	}
	
	public ApprovalDecision approve(String decisionMaker, String reason) {
		
		ApprovalDecision decision = new Approved(decisionMaker, LocalDateTime.now(), reason);
		decisionHistory.add(decision);
		return decision;
		
	}
	
	public List<ApprovalDecision> getDecisionHistory() {
	        return List.copyOf(decisionHistory);
	}
	
	

}
