package az.edu.asoui.academiccalendarmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import models.Event;
import models.EventList;

/**
 * Created by Rustem on 12/27/2017.
 */

public class EventsListActivity extends AppCompatActivity {
    private final String TAG = "EventsListActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);


        /*final ListView listView = (ListView) findViewById(R.id.eventsListView);
        listView.setAdapter(EventList.findInstance(this, R.id.eventsListView).getList());

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                openEventDetails(listView.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ((Button) findViewById(R.id.addEventButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventDetails(-1);
            }
        });*/

    }

    private void openEventDetails(int eventIndex){
        Intent intent = new Intent(EventsListActivity.this, EventDetailsActivity.class);
        intent.putExtra("eventIndex", eventIndex);
        startActivity(intent);
    }
}
