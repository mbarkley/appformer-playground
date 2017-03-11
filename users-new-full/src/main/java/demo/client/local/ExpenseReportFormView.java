package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.FormView;
import java.util.List;
import java.util.ArrayList;
import demo.client.shared.ExpenseReportFormModel;
import demo.client.shared.ExpenseReport;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import org.gwtbootstrap3.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;
import org.kie.appformer.formmodeler.rendering.client.shared.fields.SubForm;
import demo.client.shared.Associate;
import demo.client.shared.AssociateFormModel;
import demo.client.local.AssociateFormView;
import org.kie.appformer.formmodeler.rendering.client.shared.fields.SubFormModelAdapter;
import org.kie.appformer.formmodeler.rendering.client.shared.fields.MultipleSubForm;
import demo.client.shared.Expense;
import demo.client.shared.ExpenseFormModel;
import demo.client.local.ExpenseFormView;
import org.kie.appformer.formmodeler.rendering.client.shared.fields.MultipleSubFormModelAdapter;
import org.uberfire.ext.widgets.table.client.ColumnMeta;
import com.google.gwt.user.cellview.client.TextColumn;
import java.lang.Override;

@Templated
@Named("ExpenseReportFormView")
public class ExpenseReportFormView
		extends
			FormView<ExpenseReport, ExpenseReportFormModel> {

	@Inject
	@Bound(property = "expenseReport.id")
	@DataField
	private TextBox expenseReport_id;
	@Inject
	@Bound(property = "expenseReport.date")
	@DataField
	private DatePicker expenseReport_date;
	@DataField
	private SubForm expenseReport_associate = new SubForm(
			new ExpenseReport_associateSubFormModelAdapter());
	@DataField
	private MultipleSubForm expenseReport_expenses = new MultipleSubForm(
			new ExpenseReport_expensesMultipleSubFormModelAdapter());
	@Inject
	@Bound(property = "expenseReport.total")
	@DataField
	private TextBox expenseReport_total;

	@Override
	protected void initForm() {
		validator.registerInput("expenseReport_id", expenseReport_id);
		validator.registerInput("expenseReport_date", expenseReport_date);
		expenseReport_date.setAutoClose(true);
		expenseReport_date.setHighlightToday(true);
		expenseReport_date.setShowTodayButton(true);
		validator.registerInput("expenseReport_associate",
				expenseReport_associate);
		updateNestedModels(true);
		validator.registerInput("expenseReport_expenses",
				expenseReport_expenses);
		validator.registerInput("expenseReport_total", expenseReport_total);
	}

	@Override
	public void beforeDisplay() {
	}

	@Override
	public boolean doExtraValidations() {
		boolean valid = true;
		if (!expenseReport_associate.validate() && valid) {
			valid = false;
		}
		return valid;
	}

	public class ExpenseReport_associateSubFormModelAdapter
			implements
				SubFormModelAdapter<Associate, AssociateFormModel> {
		@Override
		public Class<AssociateFormView> getFormViewType() {
			return AssociateFormView.class;
		}

		@Override
		public AssociateFormModel getFormModelForModel(Associate model) {
			return new AssociateFormModel(model);
		}
	}

	@Override
	protected void updateNestedModels(boolean init) {
		demo.client.shared.Associate associate = getModel().getExpenseReport()
				.getAssociate();
		if (associate == null && init) {
			associate = new demo.client.shared.Associate();
			getModel().getExpenseReport().setAssociate(associate);
		}
		expenseReport_associate.setModel(associate);
		List expenses = getModel().getExpenseReport().getExpenses();
		if (expenses == null && init) {
			expenses = new ArrayList<demo.client.shared.Expense>();
			getModel().getExpenseReport().setExpenses(expenses);
		}
		expenseReport_expenses.setModel(expenses);
	}

	@Override
	public void setModel(ExpenseReportFormModel model) {
		super.setModel(model);
		updateNestedModels(false);
	}

	public class ExpenseReport_expensesMultipleSubFormModelAdapter
			implements
				MultipleSubFormModelAdapter<List<Expense>, Expense, ExpenseFormModel, ExpenseFormModel> {
		@Override
		public Class<ExpenseFormView> getCreationForm() {
			return ExpenseFormView.class;
		}

		@Override
		public Class<ExpenseFormView> getEditionForm() {
			return ExpenseFormView.class;
		}

		@Override
		public ExpenseFormModel getEditionFormModel(Expense model) {
			return new ExpenseFormModel(model);
		}

		@Override
		public List<ColumnMeta<Expense>> getCrudColumns() {
			List<ColumnMeta<Expense>> columnMetas = new ArrayList<>();
			ColumnMeta<Expense> date_columnMeta = new ColumnMeta<Expense>(
					new TextColumn<Expense>() {
						@Override
						public String getValue(Expense model) {
							Object value = model.getDate();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Date");
			columnMetas.add(date_columnMeta);
			ColumnMeta<Expense> price_columnMeta = new ColumnMeta<Expense>(
					new TextColumn<Expense>() {
						@Override
						public String getValue(Expense model) {
							Object value = model.getPrice();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Price");
			columnMetas.add(price_columnMeta);
			ColumnMeta<Expense> subject_columnMeta = new ColumnMeta<Expense>(
					new TextColumn<Expense>() {
						@Override
						public String getValue(Expense model) {
							Object value = model.getSubject();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Subject");
			columnMetas.add(subject_columnMeta);
			return columnMetas;
		}
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		expenseReport_date.setReadOnly(readOnly);
		expenseReport_associate.setReadOnly(readOnly);
		expenseReport_total.setReadOnly(readOnly);
	}
}