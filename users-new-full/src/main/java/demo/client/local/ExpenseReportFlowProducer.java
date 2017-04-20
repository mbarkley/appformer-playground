package demo.client.local;

import demo.client.shared.ExpenseReport;
import demo.client.shared.ExpenseReportFormModel;
import demo.client.shared.ExpenseReportRestService;
import org.kie.appformer.flow.api.Unit;
import java.util.Optional;
import org.kie.appformer.formmodeler.rendering.client.flow.FlowProducer;
import org.jboss.errai.ioc.client.api.EntryPoint;
import javax.inject.Singleton;
import javax.enterprise.inject.Produces;
import org.kie.appformer.flow.api.AppFlow;
import org.kie.appformer.formmodeler.rendering.client.flow.ForEntity;
import javax.inject.Named;

@EntryPoint
public class ExpenseReportFlowProducer
		extends
			FlowProducer<ExpenseReport, ExpenseReportFormModel, ExpenseReportFormView, ExpenseReportListView, ExpenseReportRestService> {

	@Override
	public ExpenseReportFormModel modelToFormModel(ExpenseReport model) {
		return new ExpenseReportFormModel(model);
	}

	@Override
	public ExpenseReport formModelToModel(ExpenseReportFormModel formModel) {
		return formModel.getExpenseReport();
	}

	@Override
	public ExpenseReport newModel() {
		return new ExpenseReport();
	}

	@Override
	public Class<ExpenseReport> getModelType() {
		return ExpenseReport.class;
	}

	@Override
	public Class<ExpenseReportFormModel> getFormModelType() {
		return ExpenseReportFormModel.class;
	}

	@Singleton
	@Produces
	public Class<ExpenseReport> entityType() {
		return ExpenseReport.class;
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.ExpenseReport")
	@Named("create")
	public AppFlow<Unit, Optional<ExpenseReportFormModel>> create() {
		return super.create();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.ExpenseReport")
	@Named("crud")
	public AppFlow<Unit, Unit> crud() {
		return super.crud();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.ExpenseReport")
	@Named("createAndReview")
	public AppFlow<Unit, Unit> createAndReview() {
		return super.createAndReview();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.ExpenseReport")
	@Named("view")
	public AppFlow<Unit, Unit> view() {
		return super.view();
	}
}