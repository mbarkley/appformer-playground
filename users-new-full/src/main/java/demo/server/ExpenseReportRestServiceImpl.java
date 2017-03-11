package demo.server;

import demo.client.shared.ExpenseReport;
import java.util.List;
import demo.client.shared.ExpenseReportRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import org.kie.appformer.formmodeler.rendering.client.shared.query.QueryCriteria;

@Stateless
public class ExpenseReportRestServiceImpl implements ExpenseReportRestService {

	@Inject
	private ExpenseReportEntityService entityService;

	@Override
	public ExpenseReport create(ExpenseReport model) {
		return entityService.create(model);
	}

	@Override
	public List<ExpenseReport> load() {
		return entityService.listAll(ExpenseReport.class);
	}

	@Override
	public List<ExpenseReport> load(int start, int end) {
		return entityService.list(ExpenseReport.class, start, end);
	}

	@Override
	public Boolean update(ExpenseReport model) {
		entityService.update(model);
		return true;
	}

	@Override
	public Boolean delete(ExpenseReport model) {
		entityService.delete(model);
		return true;
	}

	@Override
	public List<ExpenseReport> list(QueryCriteria criteria) {
		return entityService.list(ExpenseReport.class, criteria);
	}
}