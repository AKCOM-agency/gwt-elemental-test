package agency.akcom.gwt.client;

import static elemental.client.Browser.getDocument;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

import elemental.client.Browser;
import elemental.dom.Document;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.*;

public class TestForm implements EntryPoint {

    public interface Css extends CssResource {
        @ClassName("form-control")
        String formControl();

        @ClassName("form-signin")
        String formSignin();

        String checkbox();

        String wrapper();

        String badge();
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
    private HeadingElement headingElement;
    private SelectElement selectElement;
    private OptionElement disabledOption;
    private OptionElement tinkerOption;
    private OptionElement tailorOption;
    private OptionElement soldierOption;
    private OptionElement sailorOption;
    private LabelElement checkBox;
    private InputElement checkboxInput;
    private ButtonElement submitButton;
    private DivElement usernameInputFailBadge;
    private SpanElement usernameInputFailureMessage;
    private DivElement checkBoxInputFailBadge;
    private SpanElement checkBoxInputFailureMessage;

    public void onModuleLoad() {
        injectStyles(Browser.getDocument(), css.getText());

        headingElement = (HeadingElement) getDocument().createElement("h1");
        headingElement.setInnerText("Test Form");

        wrapper = divWithClassName(css.wrapper());

        getDocument().getBody().appendChild(headingElement);

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

        usernameInputFailBadge = divWithClassName(css.badge());
        usernameInputFailureMessage = getDocument().createSpanElement();

        usernameInputFailureMessage.setInnerText("Please fill in all fields");

        usernameInputFailBadge.appendChild(usernameInputFailureMessage);


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
        disabledOption = getDocument().createOptionElement();
        disabledOption.setInnerText("Select a job");
        disabledOption.setDisabled(true);
        disabledOption.setDefaultSelected(true);
        disabledOption.setHidden(true);
        tinkerOption.setInnerText("Tinker");
        tinkerOption.setValue("tinker");
        soldierOption.setInnerText("Soldier");
        soldierOption.setValue("soldier");
        tailorOption.setInnerText("Tailor");
        tailorOption.setValue("tailor");
        sailorOption.setInnerText("Sailor");
        sailorOption.setValue("sailor");

        selectElement.appendChild(disabledOption);
        selectElement.appendChild(tinkerOption);
        selectElement.appendChild(soldierOption);
        selectElement.appendChild(tailorOption);
        selectElement.appendChild(sailorOption);

        formSignin.appendChild(selectElement);

        checkBox = getDocument().createLabelElement();


        checkBoxInputFailBadge = divWithClassName(css.badge());
        checkBoxInputFailureMessage = getDocument().createSpanElement();
        checkBoxInputFailureMessage.setInnerText("Please check the checkbox");

        checkBoxInputFailBadge.appendChild(checkBoxInputFailureMessage);

        checkboxInput = getDocument().createInputElement();
        checkboxInput.setClassName(css.checkbox());
        checkboxInput.setType("checkbox");
        checkboxInput.setValue("agree");
        checkboxInput.setId("agree");
        checkboxInput.setName("userAgree");
        checkboxInput.setRequired(true);

        checkBox.setInnerText("I agree to send information");
        checkBox.setHtmlFor("agree");

        formSignin.appendChild(checkboxInput);

        formSignin.appendChild(checkBox);


        submitButton = getDocument().createButtonElement();
        submitButton.setInnerText("SEND ⇒");

        formSignin.appendChild(submitButton);

        getDocument().getBody().appendChild(wrapper);

        getDocument().getBody().appendChild(usernameInputFailBadge);
        getDocument().getBody().appendChild(checkBoxInputFailBadge);

        usernameInput.setOninvalid(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
               usernameInputFailBadge.setAttribute("style", "display:flex;");
            }
        });

        selectElement.setOninvalid(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                usernameInputFailBadge.setAttribute("style", "display:flex;");
            }
        });

        checkboxInput.setOninvalid(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                checkBoxInputFailBadge.setAttribute("style", "display:flex;");
            }
        });

        usernameInput.setOnchange(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                usernameInputFailBadge.setAttribute("style", "display:none;");
            }
        });

        selectElement.setOnchange(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                usernameInputFailBadge.setAttribute("style", "display:none;");
            }
        });

        checkboxInput.setOnclick(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                checkBoxInputFailBadge.setAttribute("style", "display:flex;");
            }
        });
    }
}