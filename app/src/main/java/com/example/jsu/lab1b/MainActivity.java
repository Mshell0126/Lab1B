package com.example.jsu.lab1b;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> phrases;
    private Random random;
    private int counter;
    private int phraseCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        random = new Random(1337);
        counter = 0;

        phrases = new ArrayList<String>(
                Arrays.asList(
                        "you get knocked out",
                        "you go somewhere else",
                        "you find a dead man",
                        "...forget this story, it stinks!",
                        "you are not alone...",
                        "you hear a scream!",
                        "you hear a gunshot!",
                        "you hear footsteps behind you ...",
                        "the telephone rings",
                        "there is a knock at the door",
                        "you smell famiiliar perfume",
                        "you are being followed",
                        "you are almost run over",
                        "a bullet whizzes past your ear!",
                        "you find a frayed rope",
                        "you find a knife",
                        "you find a gun",
                        "you are arrested",
                        "a crooked cop warns you",
                        "someone has searched the place",
                        "you meet a buxom blonde",
                        "you find a dead woman"
                )
        );
        phraseCount = phrases.size();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String pickMessage(){
        int r = random.nextInt(phraseCount - counter);

        String phrase = phrases.get(r);
        phrases.remove(r);
        phrases.add(phrases.size(), phrase);

        counter ++;
        counter = counter % phrases.size();
        return phrase;
    }

    private void setMessage(String s){
        TextView messageView = (TextView) findViewById(R.id.MessageText);
        messageView.setText(s);
    }

    public void clickButton(View v){
        setMessage(pickMessage());

    }
}
