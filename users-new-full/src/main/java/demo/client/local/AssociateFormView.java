package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.FormView;
import java.util.List;
import java.util.ArrayList;
import demo.client.shared.AssociateFormModel;
import demo.client.shared.Associate;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import org.gwtbootstrap3.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.gwtbootstrap3.client.ui.TextArea;

@Templated
@Named("AssociateFormView")
public class AssociateFormView extends FormView<Associate, AssociateFormModel> {

	@Inject
	@Bound(property = "associate.name")
	@DataField
	private TextBox associate_name;
	@Inject
	@Bound(property = "associate.lastName")
	@DataField
	private TextBox associate_lastName;
	@Inject
	@Bound(property = "associate.address")
	@DataField
	private TextArea associate_address;

	@Override
	protected void initForm() {
		validator.registerInput("associate_name", associate_name);
		validator.registerInput("associate_lastName", associate_lastName);
		validator.registerInput("associate_address", associate_address);
	}

	@Override
	public void beforeDisplay() {
	}

	@Override
	public boolean doExtraValidations() {
		boolean valid = true;
		return valid;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		associate_name.setReadOnly(readOnly);
		associate_lastName.setReadOnly(readOnly);
		associate_address.setReadOnly(readOnly);
	}
}