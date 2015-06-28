package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;

/**
 *
 * @author podolak
 */
public class Panel implements ActiveEditorDrop {
    
    private String title = "";
    private String content = "";

    public Panel() {
    }
    
    private String createBody() {
        return
                  "<div class=\"panel panel-default\">\n"
                + "    <div class=\"panel-heading\">\n"
                + "        <h3 class=\"panel-title\">" + getTitle() + "</h3>\n"
                + "    </div>\n"
                + "    <div class=\"panel-body\">\n"
                + "        " + getContent() + "\n"
                + "    </div>\n"
                + "</div>\n";
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        PanelCustomizer c = new PanelCustomizer(this, targetComponent);
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
