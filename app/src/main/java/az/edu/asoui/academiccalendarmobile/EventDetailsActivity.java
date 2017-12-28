package az.edu.asoui.academiccalendarmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import models.Event;
import models.EventList;

/**
 * Created by Rustem on 12/27/2017.
 */

public class EventDetailsActivity extends AppCompatActivity {

    private EditText dateET, titleET, detailsET;
    private boolean isGoingToBeAdded;
    private Event event;
    private String date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        ((ImageButton) findViewById(R.id.logoImageButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        dateET = (EditText) findViewById(R.id.dateEditText);
        titleET = (EditText) findViewById(R.id.titleEditText);
        detailsET = (EditText) findViewById(R.id.detailsEditText);

        Button addButton = (Button) findViewById(R.id.addButton);

        int eventIndex = getIntent().getExtras().getInt("eventIndex");

        if (eventIndex != -1)
        {
            //If existing event's being modified
            event = EventList.getInstance().get(eventIndex);

            //Set existed values to editTexts
            dateET.setText(event.getDate());
            titleET.setText(event.getTitle());
            detailsET.setText(event.getDetails());
            addButton.setText("Change");
            isGoingToBeAdded = false;
        }
        else
        {
            isGoingToBeAdded = true;
            dateET.setText(getIntent().getExtras().getString("date"));
        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGoingToBeAdded)
                {
                    EventList.getInstance().add(new Event(
                            dateET.getText().toString(),
                            titleET.getText().toString(),
                            detailsET.getText().toString()));
                }
                else
                {
                    event.setDate(dateET.getText().toString());
                    event.setTitle(titleET.getText().toString());
                    event.setDetails(detailsET.getText().toString());
                }

                Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
                intent.putExtra("date", dateET.getText().toString());
                startActivity(intent);
            }
        });
    }
}
