package agency.akcom.gwt.client;

import static elemental.client.Browser.getDocument;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

import elemental.client.Browser;
import elemental.dom.Document;
import elemental.html.*;

public class TestForm implements EntryPoint {

    public interface Css extends CssResource {
        @ClassName("form-control")
        String formControl();

        @ClassName("form-signin")
        String formSignin();

        @ClassName("form-signin-heading")
        String formSigninHeading();

        String checkbox();

        String wrapper();
    }

    public interface Resources extends ClientBundle {
        @Source("test-form.css")
        Css css();
    }

    private static void injectStyles(Document document, String css) {
        final StyleElement style = (StyleElement) document.createElement("style");
        style.setTextContent(css);
        document.getHead().appendChild(style);
    }

    private final Css css = GWT.<Resources>create(Resources.class).css();

    private DivElement div() {
        return getDocument().createDivElement();
    }

    private DivElement divWithClassName(String className) {
        DivElement divElement = getDocument().createDivElement();
        divElement.setClassName(className);

        return divElement;
    }

    private DivElement divWithClassNameAndId(String className, String id) {
        DivElement divElement = getDocument().createDivElement();
        divElement.setClassName(className);
        divElement.setId(id);

        return divElement;
    }

    private DivElement wrapper;
    private FormElement formSignin;
    private SpanElement nameSpan;
    private InputElement usernameInput;
    private SpanElement jobSpan;
    private SelectElement selectElement;
    private OptionElement tinkerOption;
    private OptionElement tailorOption;
    private OptionElement soldierOption;
    private OptionElement sailorOption;
    private LabelElement checkBox;
    private InputElement checkboxInput;
    private ButtonElement submitButton;

    public void onModuleLoad() {
        injectStyles(Browser.getDocument(), css.getText());

        wrapper = divWithClassName(css.wrapper());
        formSignin = getDocument().createFormElement();
        formSignin.setClassName(css.formSignin());

        wrapper.appendChild(formSignin);

        nameSpan = getDocument().createSpanElement();
        nameSpan.setInnerText("Name");

        formSignin.appendChild(nameSpan);

        usernameInput = getDocument().createInputElement();
        usernameInput.setType("text");
        usernameInput.setName("username");
        usernameInput.setRequired(true);
        usernameInput.setClassName(css.formControl());
        usernameInput.setPlaceholder("Enter your name");

        formSignin.appendChild(usernameInput);

        jobSpan = getDocument().createSpanElement();
        jobSpan.setInnerText("Job");

        formSignin.appendChild(jobSpan);

        selectElement = getDocument().createSelectElement();
        selectElement.setClassName(css.formControl());
        selectElement.setRequired(true);
        selectElement.setName("job");

        tinkerOption = getDocument().createOptionElement();
        soldierOption = getDocument().createOptionElement();
        tailorOption = getDocument().createOptionElement();
        sailorOption = getDocument().createOptionElement();
        tinkerOption.setInnerText("Tinker");
        tinkerOption.setValue("tinker");
        soldierOption.setInnerText("Soldier");
        soldierOption.setValue("soldier");
        tailorOption.setInnerText("Tailor");
        tailorOption.setValue("tailor");
        sailorOption.setInnerText("Sailor");
        sailorOption.setValue("sailor");

        selectElement.appendChild(tinkerOption);
        selectElement.appendChild(soldierOption);
        selectElement.appendChild(tailorOption);
        selectElement.appendChild(sailorOption);

        formSignin.appendChild(selectElement);

        checkBox = getDocument().createLabelElement();
        checkBox.setClassName(css.checkbox());

        checkboxInput = getDocument().createInputElement();
        checkboxInput.setType("checkbox");
        checkboxInput.setValue("remember-me");
        checkboxInput.setId("rememberMe");
        checkboxInput.setName("rememberMe");
        checkboxInput.setRequired(true);
        checkBox.setTextContent("I agree to send information");

        checkBox.appendChild(checkboxInput);
        formSignin.appendChild(checkBox);

        submitButton = getDocument().createButtonElement();
        submitButton.setInnerText("SEND ⇒");

        formSignin.appendChild(submitButton);

        getDocument().getBody().appendChild(wrapper);
    }
}
