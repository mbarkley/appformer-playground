package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.AppFormerRestService;
import javax.ws.rs.Path;
import demo.client.shared.Associate;
import java.util.List;

@Path("associate")
public interface AssociateRestService extends AppFormerRestService<Associate> {
}