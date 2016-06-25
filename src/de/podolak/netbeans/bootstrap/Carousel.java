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
