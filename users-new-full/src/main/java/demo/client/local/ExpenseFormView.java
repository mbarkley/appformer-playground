package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.FormView;
import java.util.List;
import java.util.ArrayList;
import demo.client.shared.ExpenseFormModel;
import demo.client.shared.Expense;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import org.gwtbootstrap3.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;

@Templated
@Named("ExpenseFormView")
public class ExpenseFormView extends FormView<Expense, ExpenseFormModel> {

	@Inject
	@Bound(property = "expense.price")
	@DataField
	private TextBox expense_price;
	@Inject
	@Bound(property = "expense.subject")
	@DataField
	private TextBox expense_subject;
	@Inject
	@Bound(property = "expense.date")
	@DataField
	private DatePicker expense_date;

	@Override
	protected void initForm() {
		validator.registerInput("expense_price", expense_price);
		validator.registerInput("expense_subject", expense_subject);
		validator.registerInput("expense_date", expense_date);
		expense_date.setAutoClose(true);
		expense_date.setHighlightToday(true);
		expense_date.setShowTodayButton(true);
	}

	@Override
	public void beforeDisplay() {
	}

	@Override
	public boolean doExtraValidations() {
		boolean valid = true;
		return valid;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		expense_price.setReadOnly(readOnly);
		expense_subject.setReadOnly(readOnly);
		expense_date.setReadOnly(readOnly);
	}
}