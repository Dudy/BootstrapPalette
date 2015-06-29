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
public class Grid implements ActiveEditorDrop {
    
    private int rows = 0;
    private int columns = 0;
    private GridBreakpoint gridBreakpoint = null;

    public Grid() {
    }
    
    private String createBody() {
        StringBuilder stringBuilder = new StringBuilder();
        int columnSize = 12 / getColumns();
        
        stringBuilder.append("<div class=\"container\">\n");
        
        for (int i = 0; i < getRows(); i++) {
            stringBuilder.append("    <div class=\"row\">\n");
            
            for (int j = 0; j < getColumns(); j++) {
                stringBuilder
                        .append("        <div class=\"")
                        .append(getGridBreakpoint().getPrefix())
                        .append(columnSize)
                        .append("\">\n")
                        .append("        </div>\n");
            }
            
            stringBuilder.append("    </div>\n");
        }
        stringBuilder.append("</div>\n");
        
        return stringBuilder.toString();
    }
    
    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        GridCustomizer c = new GridCustomizer(this, targetComponent);
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
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the gridBreakpoint
     */
    public GridBreakpoint getGridBreakpoint() {
        return gridBreakpoint;
    }

    /**
     * @param gridBreakpoint the gridBreakpoint to set
     */
    public void setGridBreakpoint(GridBreakpoint gridBreakpoint) {
        this.gridBreakpoint = gridBreakpoint;
    }
    
}
