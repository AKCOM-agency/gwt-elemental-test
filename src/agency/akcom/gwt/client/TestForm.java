package agency.akcom.gwt.client;

import agency.akcom.gwt.client.elements.MainForm;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import elemental.client.Browser;
import elemental.dom.Document;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.events.MouseEvent;
import elemental.html.OptionElement;
import elemental.html.StyleElement;
import elemental.html.Window;

import static agency.akcom.gwt.shared.resources.CssResources.Css;
import static agency.akcom.gwt.shared.resources.CssResources.Resources;
import static elemental.client.Browser.getDocument;

public class TestForm implements EntryPoint, EventListener {
    private static void injectStyles(Document document, String css) {
        final StyleElement style = (StyleElement) document.createElement("style");
        style.setTextContent(css);
        document.getHead().appendChild(style);
    }

    private final Css css = GWT.<Resources>create(Resources.class).css();

    private MainForm mainForm;

    @Override
    public void handleEvent(Event evt) {

    }

    private enum JobsOption {
        TINKER("Tinker"),
        TAYLOR("Taylor"),
        SOLDIER("Soldier"),
        SAILOR("Sailor");

        private final String text;

        JobsOption(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public void onModuleLoad() {
        injectStyles(Browser.getDocument(), css.getText());

        mainForm = new MainForm();

        addJobValuesToJobSelectElement();

        mainForm.setParagraphU0InnerText("Test Form");
        mainForm.setParagraphU1InnerText("Name");
        mainForm.setParagraphU2InnerText("Job");

        mainForm.setUsernameInputType("text");
        mainForm.setUsernameInputName("username");
        mainForm.setUsernameInputRequired(true);
        mainForm.setUsernameInputPlaceHolder("Enter your name");


        mainForm.setInputCheckboxType("checkbox");
        mainForm.setInputCheckboxRequired(true);

        mainForm.setUserAgreementLabelInnerText("I agree to send information");

        mainForm.setSendButtonInnerText("SEND");

        getDocument().getBody().appendChild(mainForm.getFlexContainerDiv());
    }

    private void addJobValuesToJobSelectElement() {
        for(JobsOption j : JobsOption.values()) {
            OptionElement jobOption = getDocument().createOptionElement();
            jobOption.setInnerText(j.text);

            mainForm.appendOptionOnSelectJobElement(jobOption);
        }
    }
}