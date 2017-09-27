package agency.akcom.gwt.client.elements;

import com.google.gwt.core.client.GWT;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.*;

import static agency.akcom.gwt.shared.resources.CssResources.Css;
import static agency.akcom.gwt.shared.resources.CssResources.Resources;
import static elemental.client.Browser.getDocument;
import static agency.akcom.gwt.client.Utils.*;

public class MainForm {

    private DivElement flexContainerDiv;
    private SpanElement paragraphU0;
    private DivElement mainForm;
    private SpanElement paragraphU1;
    private DivElement inputFormDivUsername;
    private DivElement inputFormDivJob;
    private InputElement usernameInput;
    private SpanElement paragraphU2;
    private SelectElement selectJob;
    private OptionElement disabledOption;
    private DivElement inputCheckboxDiv;
    private InputElement inputCheckbox;
    private LabelElement userAgreement;
    private ButtonElement sendButton;
    private DivElement badgeFillAllFields;
    private DivElement badgeCheckTheCheckBox;


    private final Css css = GWT.<Resources>create(Resources.class).css();

    public MainForm() {
        initElements();
        buildHTMLCarcass();

        addEventListenerToSendButton();
    }

    private void initElements() {
        flexContainerDiv = div(css.flexContainer());
        paragraphU0 = span(css.paragraph(), "u0");
        mainForm = div(css.main_form());
        paragraphU1 = span(css.paragraph(), "u1");
        inputFormDivUsername = div(css.input_form());
        inputFormDivJob = div(css.input_form());
        usernameInput = input(css.inner_editor(), "username_editor");
        paragraphU2 = span(css.paragraph(), "u2");
        selectJob = select(css.inner_editor(), "job_editor");
        disabledOption = getDocument().createOptionElement();
        inputCheckboxDiv = div(css.input_checkbox());
        inputCheckbox = input(css.input_checkbox(), "u4_checkbox");
        userAgreement = getDocument().createLabelElement();
        sendButton = getDocument().createButtonElement();
        badgeFillAllFields = createNewBadgeWithCustomText("Please fill in all fields");
        badgeCheckTheCheckBox = createNewBadgeWithCustomText("Please check the checkbox");
    }

    private void buildHTMLCarcass() {
        sendButton.setClassName(css.send_button());

        flexContainerDiv.appendChild(paragraphU0);
        flexContainerDiv.appendChild(mainForm);

        mainForm.appendChild(paragraphU1);
        mainForm.appendChild(inputFormDivUsername);
        inputFormDivUsername.appendChild(usernameInput);

        mainForm.appendChild(paragraphU2);
        mainForm.appendChild(inputFormDivJob);

        disabledOption.setDefaultSelected(true);
        disabledOption.setHidden(true);
        disabledOption.setDisabled(true);
        disabledOption.setInnerText("Select a job");
        selectJob.setRequired(true);
        selectJob.appendChild(disabledOption);

        inputFormDivJob.appendChild(selectJob);

        mainForm.appendChild(inputCheckboxDiv);
        inputCheckboxDiv.appendChild(inputCheckbox);
        inputCheckboxDiv.appendChild(userAgreement);

        mainForm.appendChild(sendButton);

        flexContainerDiv.appendChild(badgeFillAllFields);
        flexContainerDiv.appendChild(badgeCheckTheCheckBox);
    }

    public DivElement getFlexContainerDiv() {
        return flexContainerDiv;
    }

    public void setParagraphU0InnerText(String text) {
        paragraphU0.setInnerText(text);
    }

    public void setParagraphU1InnerText(String text) {
        paragraphU1.setInnerText(text);
    }

    public void setParagraphU2InnerText(String text) {
        paragraphU2.setInnerText(text);
    }

    public void setUsernameInputType(String type) {
        usernameInput.setType(type);
    }

    public void setUsernameInputName(String name) {
        usernameInput.setName(name);
    }

    public void setUsernameInputRequired(boolean required) {
        usernameInput.setRequired(required);
    }

    public void setUsernameInputPlaceHolder(String text) {
        usernameInput.setPlaceholder(text);
    }

    public void setInputCheckboxType(String type) {
        inputCheckbox.setType(type);
    }

    public void setInputCheckboxRequired(boolean required) {
        inputCheckbox.setRequired(required);
    }

    public void setSendButtonInnerText(String text) {
        sendButton.setInnerText(text);
    }

    private DivElement createNewBadgeWithCustomText(String text) {
        DivElement badgeElement = div(css.badge());
        SpanElement badgeSpanElement = span(css.badgeSpan());

        badgeSpanElement.setInnerText(text);

        badgeElement.appendChild(badgeSpanElement);

        return badgeElement;
    }

    private void showErrorBadge(DivElement badgeElement) {
        badgeElement.setAttribute("style", "display: flex");
    }

    private void hideErrorBadge(DivElement badgeElement) {
        badgeElement.setAttribute("style", "display: none");
    }

    private void addEventListenerToSendButton() {
        sendButton.setOnclick(evt -> {
            if(!usernameInput.checkValidity() || !selectJob.checkValidity()) {
                showErrorBadge(badgeFillAllFields);
            }

            else {
                hideErrorBadge(badgeFillAllFields);
            }

            if(!inputCheckbox.isChecked()) {
                showErrorBadge(badgeCheckTheCheckBox);
            }

            else {
                hideErrorBadge(badgeCheckTheCheckBox);
            }
        });
    }

    public void setUserAgreementLabelInnerText(String text) {
        userAgreement.setInnerText(text);
    }

    public void appendOptionOnSelectJobElement(OptionElement element) {
        selectJob.appendChild(element);
    }
}
