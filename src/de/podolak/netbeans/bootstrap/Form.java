package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;
import org.openide.util.Exceptions;

/**
 *
 * @author podolak
 */
public class Form implements ActiveEditorDrop {
    
    public Form() {
    }
    
    private String createBody() {
        return
                  "<form class=\"form-horizontal\">\n"
                + "    <div class=\"form-group\">\n"
                + "        <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Email</label>\n"
                + "        <div class=\"col-sm-10\">\n"
                + "            <input type=\"email\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Email\">\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <div class=\"form-group\">\n"
                + "        <label for=\"inputPassword3\" class=\"col-sm-2 control-label\">Password</label>\n"
                + "        <div class=\"col-sm-10\">\n"
                + "            <input type=\"password\" class=\"form-control\" id=\"inputPassword3\" placeholder=\"Password\">\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <div class=\"form-group\">\n"
                + "        <label for=\"note3\" class=\"col-sm-2 control-label\">Note</label>\n"
                + "        <div class=\"col-sm-10\">\n"
                + "            <input type=\"text\" class=\"form-control\" id=\"note3\" placeholder=\"Note\">\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <div class=\"form-group\">\n"
                + "        <div class=\"col-sm-offset-2 col-sm-10\">\n"
                + "            <div class=\"checkbox\">\n"
                + "                <label>\n"
                + "                    <input type=\"checkbox\"> Remember me\n"
                + "                </label>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <div class=\"form-group\">\n"
                + "        <div class=\"col-sm-offset-2 col-sm-10\">\n"
                + "            <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</form>\n";
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
