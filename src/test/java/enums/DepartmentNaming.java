package enums;

public enum DepartmentNaming {
    PRODUCTS("Products"),
    CARTS("Your Cart");

    private final String displayName;

    DepartmentNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
