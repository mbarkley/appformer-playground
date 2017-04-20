package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.ListView;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import demo.client.shared.ExpenseFormModel;
import demo.client.local.ExpenseFormView;
import demo.client.shared.ExpenseRestService;
import java.util.List;
import java.util.ArrayList;
import org.uberfire.ext.widgets.table.client.ColumnMeta;
import com.google.gwt.user.cellview.client.TextColumn;
import java.lang.Override;
import demo.client.shared.Expense;

@Templated
public class ExpenseListView extends ListView<Expense, ExpenseFormModel> {

	@Override
	public String getListTitle() {
		return "Expense";
	}

	@Override
	public String getFormTitle() {
		return "Expense Form";
	}

	@Override
	protected String getFormId() {
		return "Expense Form";
	}

	@Override
	public List<ColumnMeta<Expense>> getCrudColumns() {
		List<ColumnMeta<Expense>> columnMetas = new ArrayList<>();
		ColumnMeta<Expense> id_columnMeta = new ColumnMeta<Expense>(
				new TextColumn<Expense>() {
					@Override
					public String getValue(Expense model) {
						Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "id");
		columnMetas.add(id_columnMeta);
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
		return columnMetas;
	}

	@Override
	public ExpenseFormModel createFormModel(Expense expense) {
		ExpenseFormModel formModel = new ExpenseFormModel();
		formModel.setExpense(expense);
		return formModel;
	}

	public Expense newModel() {
		return new Expense();
	}
}