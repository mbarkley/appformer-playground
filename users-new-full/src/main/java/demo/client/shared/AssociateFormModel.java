package demo.client.shared;

import org.kie.appformer.formmodeler.rendering.client.shared.FormModel;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import javax.inject.Named;
import javax.validation.Valid;
import org.jboss.errai.common.client.api.annotations.MapsTo;

@Portable
@Bindable
@Named("AssociateFormModel")
public class AssociateFormModel extends FormModel<Associate> {

	@Valid
	private Associate associate;

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	@Override
	public Associate getModel() {
		return associate;
	}

	@Override
	public void initModel() {
		associate = new Associate();
	}

	public AssociateFormModel() {
	}

	public AssociateFormModel(
			@MapsTo("associate") demo.client.shared.Associate associate) {
		this.associate = associate;
	}
}