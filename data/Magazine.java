package data;

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
        setTitle(title);
        setPublisher(publisher);
        setLanguage(language);
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public void printInfo() {
        String info = getTitle() + "; " + getPublisher() + "; " + getYear() + "-"
                + getMonth() + "-" + getDay() + "; " + getLanguage();
        System.out.println(info);
    }
}
