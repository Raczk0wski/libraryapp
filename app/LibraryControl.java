package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.FileMenager;
import utils.LibraryUtils;
import utils.Reader;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class LibraryControl extends RuntimeException {
    // zmienna do komunikacji z użytkownikiem
    private Reader dataReader;
    private FileMenager fileMenager;

    // biblioteka przechowująca dane
    private Library library;

    public LibraryControl() {
        dataReader = new Reader();
        fileMenager = new FileMenager();
        try {
            library = fileMenager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku ");
        } catch (ClassNotFoundException | IOException e) {
            library = new Library();
            System.out.println("Utworzono nową bazę biblioteki.");
        }
    }


    //Główna pętla

    public void controlLoop() throws NoSuchFieldException {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                        break;
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case EXIT:
                        exit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
            }
        }
        dataReader.close();
    }

    private void exit() {

            fileMenager.writeLibraryToFile(library);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję:");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }
    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie nowej książki"),
        ADD_MAGAZINE(2, "Dodanie nowego magazynu"),
        PRINT_BOOKS(3, "Wyślietlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów");

        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch(ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }

            return result;
        }
    }

}