package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.ListView;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import demo.client.shared.ExpenseReportFormModel;
import demo.client.local.ExpenseReportFormView;
import demo.client.shared.ExpenseReportRestService;
import java.util.List;
import java.util.ArrayList;
import org.uberfire.ext.widgets.table.client.ColumnMeta;
import com.google.gwt.user.cellview.client.TextColumn;
import java.lang.Override;
import demo.client.shared.ExpenseReport;

@Templated
public class ExpenseReportListView
		extends
			ListView<ExpenseReport, ExpenseReportFormModel> {

	@Override
	public String getListTitle() {
		return "ExpenseReport";
	}

	@Override
	public String getFormTitle() {
		return "ExpenseReport Form";
	}

	@Override
	protected String getFormId() {
		return "ExpenseReport Form";
	}

	@Override
	public List<ColumnMeta<ExpenseReport>> getCrudColumns() {
		List<ColumnMeta<ExpenseReport>> columnMetas = new ArrayList<>();
		ColumnMeta<ExpenseReport> id_columnMeta = new ColumnMeta<ExpenseReport>(
				new TextColumn<ExpenseReport>() {
					@Override
					public String getValue(ExpenseReport model) {
						Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "id");
		columnMetas.add(id_columnMeta);
		ColumnMeta<ExpenseReport> date_columnMeta = new ColumnMeta<ExpenseReport>(
				new TextColumn<ExpenseReport>() {
					@Override
					public String getValue(ExpenseReport model) {
						Object value = model.getDate();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Date");
		columnMetas.add(date_columnMeta);
		ColumnMeta<ExpenseReport> total_columnMeta = new ColumnMeta<ExpenseReport>(
				new TextColumn<ExpenseReport>() {
					@Override
					public String getValue(ExpenseReport model) {
						Object value = model.getTotal();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Total");
		columnMetas.add(total_columnMeta);
		return columnMetas;
	}

	@Override
	public ExpenseReportFormModel createFormModel(ExpenseReport expenseReport) {
		ExpenseReportFormModel formModel = new ExpenseReportFormModel();
		formModel.setExpenseReport(expenseReport);
		return formModel;
	}

	public ExpenseReport newModel() {
		return new ExpenseReport();
	}
}