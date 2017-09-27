package agency.akcom.gwt.client;

import elemental.html.DivElement;
import elemental.html.InputElement;
import elemental.html.SelectElement;
import elemental.html.SpanElement;
import jdk.internal.util.xml.impl.Input;

import static elemental.client.Browser.getDocument;

public class Utils {
    public static DivElement div() {
        return getDocument().createDivElement();
    }

    public static DivElement divWithId(String id) {
        DivElement divElement = getDocument().createDivElement();
        divElement.setId(id);

        return divElement;
    }

    public static DivElement div(String className) {
        DivElement divElement = getDocument().createDivElement();
        divElement.setClassName(className);

        return divElement;
    }

    public static DivElement div(String className, String id) {
        DivElement divElement = getDocument().createDivElement();
        divElement.setClassName(className);
        divElement.setId(id);

        return divElement;
    }

    public static SpanElement span(String className, String id) {
        SpanElement spanElement = getDocument().createSpanElement();

        spanElement.setClassName(className);
        spanElement.setId(id);

        return spanElement;
    }

    public static SpanElement span(String className) {
        SpanElement spanElement = getDocument().createSpanElement();

        spanElement.setClassName(className);

        return spanElement;
    }

    public static InputElement input(String className, String id) {
        InputElement inputElement = getDocument().createInputElement();

        inputElement.setClassName(className);
        inputElement.setId(id);

        return inputElement;
    }

    public static InputElement input(String className) {
        InputElement inputElement = getDocument().createInputElement();

        inputElement.setClassName(className);

        return inputElement;
    }

    public static SelectElement select(String className, String id) {
        SelectElement selectElement = getDocument().createSelectElement();

        selectElement.setClassName(className);
        selectElement.setId(id);

        return selectElement;
    }
}
