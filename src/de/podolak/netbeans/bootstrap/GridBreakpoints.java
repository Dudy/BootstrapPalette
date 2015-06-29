package de.podolak.netbeans.bootstrap;

/**
 *
 * @author podolak
 */
public enum GridBreakpoints {

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
    
    private GridBreakpoints(int pixel, String prefix) {
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
