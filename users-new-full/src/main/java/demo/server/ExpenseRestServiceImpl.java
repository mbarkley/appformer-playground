package demo.server;

import demo.client.shared.Expense;
import java.util.List;
import demo.client.shared.ExpenseRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import org.kie.appformer.formmodeler.rendering.client.shared.query.QueryCriteria;

@Stateless
public class ExpenseRestServiceImpl implements ExpenseRestService {

	@Inject
	private ExpenseEntityService entityService;

	@Override
	public Expense create(Expense model) {
		return entityService.create(model);
	}

	@Override
	public List<Expense> load() {
		return entityService.listAll(Expense.class);
	}

	@Override
	public List<Expense> load(int start, int end) {
		return entityService.list(Expense.class, start, end);
	}

	@Override
	public Boolean update(Expense model) {
		entityService.update(model);
		return true;
	}

	@Override
	public Boolean delete(Expense model) {
		entityService.delete(model);
		return true;
	}

	@Override
	public List<Expense> list(QueryCriteria criteria) {
		return entityService.list(Expense.class, criteria);
	}
}