module org.example.parquejfx {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires java.logging;
=======
    requires java.desktop;
>>>>>>> dev_Daniel

    requires java.logging;
    opens org.example.parquejfx.viewController to javafx.fxml;

    exports org.example.parquejfx;
    opens org.example.parquejfx.util to javafx.fxml;
}