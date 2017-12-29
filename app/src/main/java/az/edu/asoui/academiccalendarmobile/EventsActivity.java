package az.edu.asoui.academiccalendarmobile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;
import android.widget.Toast;

import models.EventList;

/**
 * Created by Rustem on 12/27/2017.
 */

public class EventsActivity extends AppCompatActivity {
    private final String TAG = "EventsActivity";
    private boolean isCameFromMainActivityAlready = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        isCameFromMainActivityAlready = true;
        final ListView listView = (ListView) findViewById(R.id.eventsListView);
        listView.setAdapter(EventList.findInstance(getApplicationContext(), R.layout.text_view).getList());
        listView.setClickable(true);
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openEventDetails(position);
            }
        });

        ((Button) findViewById(R.id.addEventButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventDetails(-1);
            }
        });


        ((ImageButton) findViewById(R.id.logoImageButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        /*((Button) findViewById(R.id.addEventButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, EventDetailsActivity.class);
                intent.putExtra("eventIndex", -1);
                startActivity(intent);
            }
        });*/
    }

    private void openEventDetails(int eventIndex){
        Intent intent = new Intent(getApplicationContext(), EventDetailsActivity.class);
        intent.putExtra("eventIndex", eventIndex);
        /*if (!isCameFromMainActivityAlready)
        {
            intent.putExtra("date1", getIntent().getExtras().getString("date"));
        }
        else
        {
            intent.putExtra("date1", getIntent().getExtras().getString("date"));
        }*/
        intent.putExtra("date", getIntent().getExtras().getString("date"));
        startActivity(intent);
    }
}
