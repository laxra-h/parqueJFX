module org.example.parquejfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.parquejfx to javafx.fxml;
    exports org.example.parquejfx;
}