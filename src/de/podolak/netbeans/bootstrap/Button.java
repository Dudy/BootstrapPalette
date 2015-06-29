package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;

/**
 *
 * @author podolak
 */
public class Button implements ActiveEditorDrop {
    
    private String text;
    private ButtonType buttonType = null;
    private ButtonSize buttonSize = null;

    public Button() {
    }
    
    private String createBody() {
        return "<button type=\"button\" class=\"btn "
                + getButtonSize().getCssClass() + (getButtonSize().getCssClass().length() > 0 ? " " : "")
                + getButtonType().getCssClass() + "\">"
                + getText()
                + "</button>";
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        ButtonCustomizer c = new ButtonCustomizer(this, targetComponent);
        boolean accept = c.showDialog();
        if (accept) {
        
            String body = createBody();
            try {
                HTMLPaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }
        
        return accept;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the buttonType
     */
    public ButtonType getButtonType() {
        return buttonType;
    }

    /**
     * @param buttonType the buttonType to set
     */
    public void setButtonType(ButtonType buttonType) {
        this.buttonType = buttonType;
    }

    /**
     * @return the buttonSize
     */
    public ButtonSize getButtonSize() {
        return buttonSize;
    }

    /**
     * @param buttonSize the buttonSize to set
     */
    public void setButtonSize(ButtonSize buttonSize) {
        this.buttonSize = buttonSize;
    }

}
