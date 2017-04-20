package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.AppFormerRestService;
import javax.ws.rs.Path;
import demo.client.shared.ExpenseReport;
import java.util.List;

@Path("expensereport")
public interface ExpenseReportRestService
		extends
			AppFormerRestService<ExpenseReport> {
}