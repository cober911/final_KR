import java.io.IOException;

// Класс Main для запуска программы
public class Main {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        Menu menu = new Menu(database);
        menu.displayMenu();
    }
}
