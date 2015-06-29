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
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.openide.text.NbDocument;

public class HTMLPaletteUtilities {

    public static void insert(final String s, final JTextComponent target) throws BadLocationException {

        final StyledDocument doc = (StyledDocument) target.getDocument();

        class AtomicChange implements Runnable {

            @Override
            public void run() {
                Document value = target.getDocument();
                if (value == null) {
                    return;
                }
                try {
                    insert(s, target, doc);
                } catch (BadLocationException e) {
                }
            }
        }

        try {
            NbDocument.runAtomicAsUser(doc, new AtomicChange());
        } catch (BadLocationException ex) {
        }

    }

    private static int insert(String s, JTextComponent target, Document doc) throws BadLocationException {

        int start = -1;

        try {

            //firstly, find selected text range:
            Caret caret = target.getCaret();
            int p0 = Math.min(caret.getDot(), caret.getMark());
            int p1 = Math.max(caret.getDot(), caret.getMark());
            doc.remove(p0, p1 - p0);

            //then, replace selected text range with the inserted one:
            start = caret.getDot();
            doc.insertString(start, s, null);

        } catch (BadLocationException ble) {
        }

        return start;

    }

}
