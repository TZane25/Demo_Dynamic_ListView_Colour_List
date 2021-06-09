package sg.edu.rp.c346.id20011280.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText etElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    EditText etPos;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        etPos = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>(); // for storing the colours
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColours); //bindng the data
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toAdd = etElement.getText().toString(); // getting the text into string
                int toPos = Integer.parseInt(etPos.getText().toString()); //parsing the text into int
                alColours.add(toPos,toAdd); // add the new colour into the normal arraylist through the input position
                // index,element added
                aaColour.notifyDataSetChanged();// notifying the array adapter to bind the new data added in to the normal arraylist
                etElement.setText(null); //clear the edit text contents for colour
                etPos.setText(null); // clear the edit text contents for position


            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();// show message

            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int toPos = Integer.parseInt(etPos.getText().toString()); //parsing the text into int
                alColours.remove(toPos); // removing the element at that list position
                aaColour.notifyDataSetChanged();// notifying the array adapter to bind the new data added in to the normal arraylist
                etElement.setText(null); //clear the edit text contents for colour
                etPos.setText(null); // clear the edit text contents for position
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String toAdd = etElement.getText().toString(); // getting the text into string
                int toPos = Integer.parseInt(etPos.getText().toString()); //parsing the text into int
                alColours.set(toPos,toAdd); // setting the input to an existing position
                aaColour.notifyDataSetChanged();// notifying the array adapter to bind the new data added in to the normal arraylist
                etElement.setText(null); //clear the edit text contents for colour
                etPos.setText(null); // clear the edit text contents for position


            }
        });






    }
}