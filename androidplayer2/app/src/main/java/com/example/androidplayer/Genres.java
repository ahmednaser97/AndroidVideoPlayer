package com.example.androidplayer;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Genres extends AppCompatActivity {

    int[] IMAGES = {R.drawable.adventure, R.drawable.drama, R.drawable.comedy, R.drawable.scifi};

    String[] NAMES = {"Adventure", "Drama", "Comedy", "SciFi"};

    String[] DESCRIPTION = {"Trending " + NAMES[0] + "Movies", "Trending " + NAMES[1] + "Movies", "Trending " + NAMES[2] + "Movies", "Trending " + NAMES[3] + "Movies"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // About page
        FloatingActionButton fab = findViewById(R.id.about);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAbout();
            }
        });

        ListView listView = findViewById(R.id.item);
        listAdapter listAdapter = new listAdapter();
        listView.setAdapter(listAdapter);

        final String[] genres = {"Adventure", "Drama", "Comedy", "SciFi"};
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putCharSequence("Category_Chosen", genres[position]);
                Intent i = new Intent(getApplicationContext(), Movies.class);
                switch(position) {
                    case 0:
                        i.putExtra("Category","Adventure");
                        startActivity(i);
                    break;
                    case 1:
                        i.putExtra("Category","Drama");
                        startActivity(i);
                        break;
                    case 2:
                        i.putExtra("Category","Comedy");
                        startActivity(i);
                        break;
                    case 3:
                        i.putExtra("Category","SciFi");
                        startActivity(i);
                        break;
                }
            }

        });

        }

    class listAdapter extends BaseAdapter {

        @Override
            public int getCount() {
                return IMAGES.length;
            }
            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }


            @Override
            public View getView(int i, View view, ViewGroup parent) {
                view = getLayoutInflater().inflate(R.layout.item_layout,null);
                ImageView thumbnail = view.findViewById(R.id.thumbnail);
                TextView name = view.findViewById(R.id.name);
                TextView desc = view.findViewById(R.id.description);

                thumbnail.setImageResource(IMAGES[i]);
                name.setText(NAMES[i]);
                desc.setText(DESCRIPTION[i]);
                return view;
            }

    }

    // Start about activity
    private void showAbout(){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }
}



