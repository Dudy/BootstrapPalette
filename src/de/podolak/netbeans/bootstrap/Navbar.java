package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;

/**
 *
 * @author podolak
 */
public class Navbar implements ActiveEditorDrop {
    
    private String brand = "";

    public Navbar() {
    }
    
    private String createBody() {
        return
                  "<!-- Fixed navbar -->\n"
                + "    <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n"
                + "      <div class=\"container\">\n"
                + "        <div class=\"navbar-header\">\n"
                + "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n"
                + "            <span class=\"sr-only\">Toggle navigation</span>\n"
                + "            <span class=\"icon-bar\"></span>\n"
                + "            <span class=\"icon-bar\"></span>\n"
                + "            <span class=\"icon-bar\"></span>\n"
                + "          </button>\n"
                + "          <a class=\"navbar-brand\" href=\"#\">" + getBrand() + "</a>\n"
                + "        </div>\n"
                + "        <div id=\"navbar\" class=\"navbar-collapse collapse\">\n"
                + "          <ul class=\"nav navbar-nav\">\n"
                + "            <li class=\"active\"><a href=\"#\">Home</a></li>\n"
                + "            <li><a href=\"#about\">About</a></li>\n"
                + "            <li><a href=\"#contact\">Contact</a></li>\n"
                + "            <li class=\"dropdown\">\n"
                + "              <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Dropdown <span class=\"caret\"></span></a>\n"
                + "              <ul class=\"dropdown-menu\">\n"
                + "                <li><a href=\"#\">Action</a></li>\n"
                + "                <li><a href=\"#\">Another action</a></li>\n"
                + "                <li><a href=\"#\">Something else here</a></li>\n"
                + "                <li role=\"separator\" class=\"divider\"></li>\n"
                + "                <li class=\"dropdown-header\">Nav header</li>\n"
                + "                <li><a href=\"#\">Separated link</a></li>\n"
                + "                <li><a href=\"#\">One more separated link</a></li>\n"
                + "              </ul>\n"
                + "            </li>\n"
                + "          </ul>\n"
                + "        </div><!--/.nav-collapse -->\n"
                + "      </div>\n"
                + "    </nav>\n";
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        NavbarCustomizer c = new NavbarCustomizer(this, targetComponent);
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
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
}
