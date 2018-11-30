import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner scanner= new Scanner(System.in);
        scanner.useLocale(Locale.US);
        BookDao bookDao=new BookDao();
        String answer;
        do{
        System.out.println("Co chcesz zrobić? \n1 - dodaj książkę\n2 - usuń książke \n3-wyszukaj książkę\nend- koniec");
        answer=scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.print("Podaj tytuł książki: ");
                String title = scanner.nextLine();
                System.out.print("Podaj imię autora");
                String name = scanner.nextLine();
                System.out.print("Podaj nazwisko autora");
                String lastName = scanner.nextLine();
                System.out.print("Podaj rok wydania");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Podaj isbn");
                String isbn = scanner.nextLine();
                bookDao.addBook(new Book(title, name, lastName, year, isbn));
                break;
            case "2":
                System.out.print("Chcesz usunąć książkę, podaj jej tytuł: ");
                String titDelete=scanner.nextLine();
                bookDao.deletebook(titDelete);
                break;
            case "3":

                try {
                    System.out.println(bookDao.findBook().toString());
                }catch(NullPointerException e){
                System.err.println("Nie ma takiej książki");
            }
                break;
            case "end":
                System.out.println("Do widzenia!");
                break;
            default:
                System.out.println("Wybierz jeszcze raz, wybrana opcja nie istnieje");
        }

        }while (!(answer.equals("end")));

    }
}
