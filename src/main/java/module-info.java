module org.example.parquejfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires java.logging;
    opens org.example.parquejfx.viewController to javafx.fxml;

    exports org.example.parquejfx;
    opens org.example.parquejfx.util to javafx.fxml;
}