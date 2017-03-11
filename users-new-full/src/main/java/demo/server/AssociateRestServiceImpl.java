package demo.server;

import demo.client.shared.Associate;
import java.util.List;
import demo.client.shared.AssociateRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import org.kie.appformer.formmodeler.rendering.client.shared.query.QueryCriteria;

@Stateless
public class AssociateRestServiceImpl implements AssociateRestService {

	@Inject
	private AssociateEntityService entityService;

	@Override
	public Associate create(Associate model) {
		return entityService.create(model);
	}

	@Override
	public List<Associate> load() {
		return entityService.listAll(Associate.class);
	}

	@Override
	public List<Associate> load(int start, int end) {
		return entityService.list(Associate.class, start, end);
	}

	@Override
	public Boolean update(Associate model) {
		entityService.update(model);
		return true;
	}

	@Override
	public Boolean delete(Associate model) {
		entityService.delete(model);
		return true;
	}

	@Override
	public List<Associate> list(QueryCriteria criteria) {
		return entityService.list(Associate.class, criteria);
	}
}