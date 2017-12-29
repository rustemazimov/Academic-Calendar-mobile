package models;

/**
 * Created by Rustem on 12/27/2017.
 */

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Designed with Singleton Design Pattern
 * Will contain list of all events that's
 * going to be used during the program's execution
 */
public class EventList {
    private static EventList instance;

    private ArrayAdapter<Event> list;
    /**
     * No-arg constructor
     * <code>private</code> for letting only this class
     * itself to create an object of this class
     * Finally it's for applying Singleton Design Pattern principles
     */
    private EventList(Context context, int resource) {
        list = new ArrayAdapter<Event>(context, resource);
    }

    /**
     * Creates an object of this class first time the method's called
     * @return the object of this class that's only one copy of this class
     */
    public static EventList findInstance(Context context, int resource) {
        /*
         * If it's the first time the method's called
         * create an instance - object then assign to instance field
         */
        if (instance == null)
        {
            instance = new EventList(context, resource);
        }

        return instance;
    }

    /**
     * @return the object of this class that's only one copy of this class
     */
    public static EventList getInstance() {
        return instance;
    }

    public ArrayAdapter<Event> getList() {
        return list;
    }

    public void add(Event event) {
        this.list.add(event);
    }

    public Event get(int index) {
        return this.list.getItem(index);
    }

    public int search(Event event) {
        return this.list.getPosition(event);
    }

    public void delete(int index){
        this.list.remove(this.list.getItem(index));
    }

}
