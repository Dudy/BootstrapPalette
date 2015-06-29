package de.podolak.netbeans.bootstrap;

/**
 *
 * @author podolak
 */
public enum ButtonType {
    
    DEFAULT("btn-default"),
    PRIMARY("btn-primary"),
    SUCCESS("btn-success"),
    INFO("btn-info"),
    WARNING("btn-warning"),
    DANGER("btn-danger"),
    LINK("btn-link");
    
    private final String cssClass;
    
    private ButtonType(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * @return the cssClass
     */
    public String getCssClass() {
        return cssClass;
    }
    
}
