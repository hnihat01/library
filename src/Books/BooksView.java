package Books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;
import Exception.*;
public class BooksView {

    public void booksView() throws JAXBException, NotLoggedIn {
        if(Login.getAccess().equals("admin") || !Login.isLogin()){
            throw new NotLoggedIn();
        }
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("File name: ");
            String fileName = scanner.nextLine();
            CommandLine commandLine = new CommandLine();
            commandLine.commands("C:\\Users\\h.n\\IdeaProjects\\Project20621628\\src\\Books\\"+fileName);
            if(commandLine.isStatus()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                ListBooks books = (ListBooks) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\h.n\\IdeaProjects\\Project20621628\\src\\Books\\"+fileName));
                System.out.println("Books information: ");
                for (Book book : books.getBook()) {
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Genre: " + book.getGenre());
                    System.out.println("Description: " + book.getDescription());
                    System.out.println("Keyword: " + book.getKeywords());
                    System.out.println("Year: " + book.getYear());
                    System.out.println("Isbn: " + book.getIsbn());
                    System.out.println("Rating: " + book.getRating() + "\n");

                }
            }
        }

    }
}
