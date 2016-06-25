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
