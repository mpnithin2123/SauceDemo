package utilities;

import org.openqa.selenium.WebElement;

public class CustomWebElement
{
    private final WebElement element;

    public CustomWebElement(WebElement element)
    {
        this.element=element;
    }

    public String getText()
    {
        String text = element.getText();
        System.out.println("Overridden getText(): " + text);
        return text;
    }

    public String getAttribute(String attribute)
    {
        String text1=element.getDomAttribute(attribute);
        System.out.println("Overridden getText(): " + text1);
        return text1;
    }
}
