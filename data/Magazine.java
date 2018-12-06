package data;

import java.util.Objects;

public class Magazine extends Publication {

    private int Month;
    private int day;
    private String language;

    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return day;
    }

    public String getLanguage() {
        return language;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(year, title, publisher);
        setLanguage(language);
        setMonth(month);
        setDay(day);
    }

    public void printInfo() {
        String info = getTitle() + "; " + getPublisher() + "; " + getYear() + "-"
                + getMonth() + "-" + getDay() + "; " + getLanguage();
        System.out.println(info);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Month == magazine.Month &&
                day == magazine.day &&
                Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), Month, day, language);
    }
}
