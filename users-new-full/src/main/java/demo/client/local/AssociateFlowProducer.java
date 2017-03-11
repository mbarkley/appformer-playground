package demo.client.local;

import demo.client.shared.Associate;
import demo.client.shared.AssociateFormModel;
import demo.client.shared.AssociateRestService;
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
public class AssociateFlowProducer
		extends
			FlowProducer<Associate, AssociateFormModel, AssociateFormView, AssociateListView, AssociateRestService> {

	@Override
	public AssociateFormModel modelToFormModel(Associate model) {
		return new AssociateFormModel(model);
	}

	@Override
	public Associate formModelToModel(AssociateFormModel formModel) {
		return formModel.getAssociate();
	}

	@Override
	public Associate newModel() {
		return new Associate();
	}

	@Override
	public Class<Associate> getModelType() {
		return Associate.class;
	}

	@Override
	public Class<AssociateFormModel> getFormModelType() {
		return AssociateFormModel.class;
	}

	@Singleton
	@Produces
	public Class<Associate> entityType() {
		return Associate.class;
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Associate")
	@Named("create")
	public AppFlow<Unit, Optional<AssociateFormModel>> create() {
		return super.create();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Associate")
	@Named("crud")
	public AppFlow<Unit, Unit> crud() {
		return super.crud();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Associate")
	@Named("createAndReview")
	public AppFlow<Unit, Unit> createAndReview() {
		return super.createAndReview();
	}

	@Override
	@Produces
	@Singleton
	@ForEntity("demo.client.shared.Associate")
	@Named("view")
	public AppFlow<Unit, Unit> view() {
		return super.view();
	}
}