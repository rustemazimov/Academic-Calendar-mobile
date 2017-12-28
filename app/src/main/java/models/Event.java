package models;

/**
 * Created by Rustem on 12/27/2017.
 */

public class Event {
    private String date;
    private String title;
    private String details;


    public Event(String date, String title, String details) {
        this.date = date;
        this.title = title;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
