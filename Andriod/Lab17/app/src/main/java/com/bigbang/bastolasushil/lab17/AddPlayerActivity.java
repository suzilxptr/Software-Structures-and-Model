package com.bigbang.bastolasushil.lab17;

/**
 * Created by The BigBang on 7.4.2016.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;




public class AddPlayerActivity extends AppCompatActivity {
    Players players = Players.getInstance();
    EditText mInputText;
    Button mAddButton;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        mInputText = (EditText) findViewById(R.id.nameInput);
        mAddButton = (Button) findViewById(R.id.addButton);
        mListView = (ListView) findViewById(R.id.listView);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mInputText.getText().length() == 0){
                    Toast.makeText(AddPlayerActivity.this, "Please input player's name", Toast.LENGTH_LONG).show();
                    return;
                }

                players.add(new Player(Integer.toString(players.getSize()+2), mInputText.getText().toString()));
                Toast.makeText(AddPlayerActivity.this, "Added successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

