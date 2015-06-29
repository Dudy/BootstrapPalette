package de.podolak.netbeans.bootstrap;

/**
 *
 * @author podolak
 */
public enum ButtonSize {
    
    LARGE      ("btn-lg"),
    DEFAULT    (""),
    SMALL      ("btn-sm"),
    EXTRA_SMALL("btn-xs");
    
    private final String cssClass;
    
    private ButtonSize(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * @return the cssClass
     */
    public String getCssClass() {
        return cssClass;
    }
    
}
