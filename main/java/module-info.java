module com.example.knk2526 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.knk2526 to javafx.fxml;
    exports com.example.knk2526;

    // Java 01
    opens group_01.java_01 to javafx.fxml;
    opens group_02.java_01 to javafx.fxml;
    opens group_03.java_01 to javafx.fxml;
    opens group_04.java_01 to javafx.fxml;

    exports group_01.java_01;
    exports group_02.java_01;
    exports group_03.java_01;
    exports group_04.java_01;

    // Java 02
    opens group_01.java_02 to javafx.fxml;
    opens group_02.java_02 to javafx.fxml;
    opens group_03.java_02 to javafx.fxml;

    exports group_01.java_02;
    exports group_02.java_02;
    exports group_03.java_02;

    // Java 03
    opens group_01.java_03 to javafx.fxml;
    opens group_02.java_03 to javafx.fxml;
    opens group_03.java_03 to javafx.fxml;
    opens group_04.java_03 to javafx.fxml;

    exports group_01.java_03;
    exports group_02.java_03;
    exports group_03.java_03;
    exports group_04.java_03;
}