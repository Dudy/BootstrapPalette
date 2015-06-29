package de.podolak.netbeans.bootstrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.openide.text.ActiveEditorDrop;

/**
 *
 * @author podolak
 */
public class Grid implements ActiveEditorDrop {
    
    private int rows = 0;
    private int columns = 0;
    private GridBreakpoints gridBreakpoint = null;

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
    public GridBreakpoints getGridBreakpoint() {
        return gridBreakpoint;
    }

    /**
     * @param gridBreakpoint the gridBreakpoint to set
     */
    public void setGridBreakpoint(GridBreakpoints gridBreakpoint) {
        this.gridBreakpoint = gridBreakpoint;
    }
    
}
