```bash
javac --module-path /Users/harsh/javafx-sdk-23.0.2/lib
 --add-modules javafx.controls,javafx.fxml -d out src/**/*.java
```

jar --create --file LibraryManagementSystem.jar -C out .
