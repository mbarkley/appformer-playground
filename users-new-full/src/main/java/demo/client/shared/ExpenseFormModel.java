package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.FormModel;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import javax.inject.Named;
import javax.validation.Valid;
import org.jboss.errai.common.client.api.annotations.MapsTo;

@Portable
@Bindable
@Named("ExpenseFormModel")
public class ExpenseFormModel extends FormModel<Expense> {

	@Valid
	private Expense expense;

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	@Override
	public Expense getModel() {
		return expense;
	}

	@Override
	public void initModel() {
		expense = new Expense();
	}

	public ExpenseFormModel() {
	}

	public ExpenseFormModel(
			@MapsTo("expense") demo.client.shared.Expense expense) {
		this.expense = expense;
	}
}