package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.AppFormerRestService;
import javax.ws.rs.Path;
import demo.client.shared.Expense;
import java.util.List;

@Path("expense")
public interface ExpenseRestService extends AppFormerRestService<Expense> {
}