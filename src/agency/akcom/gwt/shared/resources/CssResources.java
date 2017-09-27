package agency.akcom.gwt.shared.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public class CssResources {
	public interface Css extends CssResource {
		String paragraph();

		String input_checkbox();

		@ClassName("flex-container")
		String flexContainer();

		String inner_editor();

		String main_form();

		String input_form();

		String send_button();

		String inner_option();

		String badge();

		String badgeSpan();
	}

	public interface Resources extends ClientBundle {
		@Source("test-form.css")
		Css css();
	}
}
