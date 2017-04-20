package demo.client.local;

import org.kie.appformer.formmodeler.rendering.client.view.ListView;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import demo.client.shared.AssociateFormModel;
import demo.client.local.AssociateFormView;
import demo.client.shared.AssociateRestService;
import java.util.List;
import java.util.ArrayList;
import org.uberfire.ext.widgets.table.client.ColumnMeta;
import com.google.gwt.user.cellview.client.TextColumn;
import java.lang.Override;
import demo.client.shared.Associate;

@Templated
public class AssociateListView extends ListView<Associate, AssociateFormModel> {

	@Override
	public String getListTitle() {
		return "Associate";
	}

	@Override
	public String getFormTitle() {
		return "Associate Form";
	}

	@Override
	protected String getFormId() {
		return "Associate Form";
	}

	@Override
	public List<ColumnMeta<Associate>> getCrudColumns() {
		List<ColumnMeta<Associate>> columnMetas = new ArrayList<>();
		ColumnMeta<Associate> id_columnMeta = new ColumnMeta<Associate>(
				new TextColumn<Associate>() {
					@Override
					public String getValue(Associate model) {
						Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "id");
		columnMetas.add(id_columnMeta);
		ColumnMeta<Associate> name_columnMeta = new ColumnMeta<Associate>(
				new TextColumn<Associate>() {
					@Override
					public String getValue(Associate model) {
						Object value = model.getName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Name");
		columnMetas.add(name_columnMeta);
		ColumnMeta<Associate> lastName_columnMeta = new ColumnMeta<Associate>(
				new TextColumn<Associate>() {
					@Override
					public String getValue(Associate model) {
						Object value = model.getLastName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Last Name");
		columnMetas.add(lastName_columnMeta);
		ColumnMeta<Associate> address_columnMeta = new ColumnMeta<Associate>(
				new TextColumn<Associate>() {
					@Override
					public String getValue(Associate model) {
						Object value = model.getAddress();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Address");
		columnMetas.add(address_columnMeta);
		return columnMetas;
	}

	@Override
	public AssociateFormModel createFormModel(Associate associate) {
		AssociateFormModel formModel = new AssociateFormModel();
		formModel.setAssociate(associate);
		return formModel;
	}

	public Associate newModel() {
		return new Associate();
	}
}