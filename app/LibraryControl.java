package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.LibraryUtils;
import utils.Reader;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {
    // zmienna do komunikacji z użytkownikiem
    private Reader dataReader;

    // biblioteka przechowująca dane
    private Library library;

    public LibraryControl() {
        dataReader = new Reader();
        library = new Library();
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
                        ;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
            }
        }
        dataReader.close();
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
}