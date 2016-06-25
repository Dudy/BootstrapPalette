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

/**
 *
 * @author Dirk Podolak
 */
public enum GridBreakpoint {

    EXTRA_SMALL(   0, "col-xs-"),
    SMALL      ( 768, "col-sm-"),
    MEDIUM     ( 992, "col-md-"),
    LARGE      (1200, "col-lg-");
    
    public static final Integer[] COLUMNS_PER_ROW = { 1, 2, 3, 4, 6, 12 };
    public static final String[] PREFIXES = new String[] {
        EXTRA_SMALL.getPrefix(),
        SMALL.getPrefix(),
        MEDIUM.getPrefix(),
        LARGE.getPrefix()
    };
    
    private final int pixel;
    private final String prefix;
    
    private GridBreakpoint(int pixel, String prefix) {
        this.pixel = pixel;
        this.prefix = prefix;
    }
    
    public int getPixel() {
        return pixel;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return getPrefix();
    }
    
}
