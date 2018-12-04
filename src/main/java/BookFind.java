import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookFind {

    public String[] bookf(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mozesz wyszukac ksiązke po: \nn - nazwisku autora\nt - tytule\ni - isbn\n " +
                "jeżeli chcesz wyjsc wpisz end");
        String type=scanner.nextLine();
        String[] options=new String[2];
        String value="";

        switch (type) {
            case "n":
                System.out.print("Podaj nazwisko autora: ");
                String authorLastname = scanner.nextLine();
                options[0]="authorLastname";
                options[1]=authorLastname;
                break;
            case "t":
                System.out.print("Podaj tytul ksiazki: ");
                String title = scanner.nextLine();
                options[0]="title";
                options[1]=title;
                break;
            case "i":
                System.out.print("Podaj isbn ksiazki: ");
                String isbn = scanner.nextLine();
                options[0]="isbn";
                options[1]=isbn;
                break;
            case "end":
                System.out.println("wychodzenie z opcji wyszukiwania książki");
            default:
                System.out.println("jeszcze nie wyszukujemy po tej opcji");
        }
    return options;}
}
