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

/**
 *
 * @author Dirk Podolak
 */
public class Page implements ActiveEditorDrop {
    
    private String title = "";

    public Page() {
    }
    
    private String createBody() {
        return
                  "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n"
                + "        <meta name=\"description\" content=\"\">\n"
                + "        <meta name=\"author\" content=\"\">\n"
                + "        <link rel=\"icon\" href=\"../../favicon.ico\">\n"
                + "\n"
                + "        <title>" + getTitle() + "</title>\n"
                + "\n"
                + "        <!-- Bootstrap core CSS -->\n"
                + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n"
                + "\n"
                + "        <!-- Custom styles for this template -->\n"
                + "        <link href=\"theme.css\" rel=\"stylesheet\">\n"
                + "\n"
                + "        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n"
                + "        <!--[if lt IE 9]>\n"
                + "            <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n"
                + "            <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n"
                + "        <![endif]-->\n"
                + "    </head>\n"
                + "    <body>\n"
                + "\n"
                + "\n"
                + "\n"
                + "        <script src=\"https://code.jquery.com/jquery-2.1.4.min.js\"></script>\n"
                + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n"
                + "    </body>\n"
                + "</html>\n";
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        PageCustomizer c = new PageCustomizer(this, targetComponent);
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
    
}
