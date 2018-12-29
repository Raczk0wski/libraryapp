package app;

public enum Option {

    EXIT(0, "Wyjście z programu"),
    ADD_BOOK(1, "Dodanie nowej książki"),
    ADD_MAGAZINE(2, "Dodanie nowego magazynu"),
    PRINT_BOOKS(3, "Wyślietlenie dostępnych książek"),
    PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów");

    private int value;
    private String description;


    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    public static Option createFromInt(int option) throws NoSuchFieldException {
        Option result=null;
        try{
            result=Option.values()[option];
        }catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException("Brak elemwntu o wskazanym ID!");
        }
        return result;
    }
}

