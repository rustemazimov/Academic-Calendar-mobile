package az.edu.asoui.academiccalendarmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
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

        registerForContextMenu(listView);

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
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Delete");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle().equals("Edit"))
        {
            openEventDetails(info.position);
        }
        else if (item.getTitle().equals("Delete"))
        {
            EventList.getInstance().delete(info.position);
        }
        return true;
    }

    private void openEventDetails(int eventIndex){
        Intent intent = new Intent(getApplicationContext(), EventDetailsActivity.class);
        intent.putExtra("eventIndex", eventIndex);
        intent.putExtra("date", getIntent().getExtras().getString("date"));
        startActivity(intent);
    }
}
