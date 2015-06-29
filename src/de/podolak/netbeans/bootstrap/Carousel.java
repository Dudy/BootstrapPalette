package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;
import org.openide.util.Exceptions;

/**
 *
 * @author podolak
 */
public class Carousel implements ActiveEditorDrop {
    
    public Carousel() {
    }
    
    private String createBody() {
        return
                  "<div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n"
                + "    <ol class=\"carousel-indicators\">\n"
                + "        <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n"
                + "        <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n"
                + "        <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n"
                + "    </ol>\n"
                + "    <div class=\"carousel-inner\" role=\"listbox\">\n"
                + "        <div class=\"item active\">\n"
                + "            <img data-src=\"holder.js/1140x500/auto/#777:#555/text:First slide\" alt=\"First slide\">\n"
                + "        </div>\n"
                + "        <div class=\"item\">\n"
                + "            <img data-src=\"holder.js/1140x500/auto/#666:#444/text:Second slide\" alt=\"Second slide\">\n"
                + "        </div>\n"
                + "        <div class=\"item\">\n"
                + "            <img data-src=\"holder.js/1140x500/auto/#555:#333/text:Third slide\" alt=\"Third slide\">\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\n"
                + "        <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n"
                + "        <span class=\"sr-only\">Previous</span>\n"
                + "    </a>\n"
                + "    <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\n"
                + "        <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n"
                + "        <span class=\"sr-only\">Next</span>\n"
                + "    </a>\n"
                + "</div>\n";
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
//        try {
// no customizable information by now
//        CarouselCustomizer c = new CarouselCustomizer(this, targetComponent);
//        boolean accept = c.showDialog();
//        if (accept) {
//        
//            String body = createBody();
//            try {
//                HTMLPaletteUtilities.insert(body, targetComponent);
//            } catch (BadLocationException ble) {
//                accept = false;
//            }
//        }
//        
//        return accept;

        
        
        
        try {
            HTMLPaletteUtilities.insert(createBody(), targetComponent);
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return true;
    }
    
}
