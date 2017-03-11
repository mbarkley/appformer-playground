package demo.client.local;

import demo.client.shared.Expense;
import demo.client.shared.ExpenseFormModel;
import demo.client.shared.ExpenseRestService;
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
public class ExpenseFlowProducer
		extends
			FlowProducer<Expense, ExpenseFormModel, ExpenseFormView, ExpenseListView, ExpenseRestService> {

	@Override
	public ExpenseFormModel modelToFormModel(Expense model) {
		return new ExpenseFormModel(model);
	}

	@Override
	public Expense formModelToModel(ExpenseFormModel formModel) {
		return formModel.getExpense();
	}

	@Override
	public Expense newModel() {
		return new Expense();
	}

	@Override
	public Class<Expense> getModelType() {
		return Expense.class;
	}

	@Override
	public Class<ExpenseFormModel> getFormModelType() {
		return ExpenseFormModel.class;
	}

	@Singleton
	@Produces
	public Class<Expense> entityType() {
		return Expense.class;
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Expense")
	@Named("create")
	public AppFlow<Unit, Optional<ExpenseFormModel>> create() {
		return super.create();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Expense")
	@Named("crud")
	public AppFlow<Unit, Unit> crud() {
		return super.crud();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Expense")
	@Named("createAndReview")
	public AppFlow<Unit, Unit> createAndReview() {
		return super.createAndReview();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Expense")
	@Named("view")
	public AppFlow<Unit, Unit> view() {
		return super.view();
	}
}