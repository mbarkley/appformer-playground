package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.FormModel;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import javax.inject.Named;
import javax.validation.Valid;
import org.jboss.errai.common.client.api.annotations.MapsTo;

@Portable
@Bindable
@Named("ExpenseReportFormModel")
public class ExpenseReportFormModel extends FormModel<ExpenseReport> {

	@Valid
	private ExpenseReport expenseReport;

	public ExpenseReport getExpenseReport() {
		return expenseReport;
	}

	public void setExpenseReport(ExpenseReport expenseReport) {
		this.expenseReport = expenseReport;
	}

	@Override
	public ExpenseReport getModel() {
		return expenseReport;
	}

	@Override
	public void initModel() {
		expenseReport = new ExpenseReport();
	}

	public ExpenseReportFormModel() {
	}

	public ExpenseReportFormModel(
			@MapsTo("expenseReport") demo.client.shared.ExpenseReport expenseReport) {
		this.expenseReport = expenseReport;
	}
}