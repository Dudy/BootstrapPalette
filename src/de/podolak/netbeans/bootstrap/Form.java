/* 
 * Copyright (C) 2015 Dirk Podolak
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA
or see <http://www.gnu.org/licenses/>.
 */
package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;
import org.openide.util.Exceptions;

/**
 *
 * @author Dirk Podolak
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
