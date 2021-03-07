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

public class Videos extends AppCompatActivity {
    int[] IMAGES = {R.drawable.thumbnail, R.drawable.thumbnail};
    String[] DESCRIPTION = {"Video 1", "Video 2"};

    String [] Adventure = {"Video 1", "Video 2 "};
    String [] Drama = {"Video 1", "Video 2"};
    String [] Comedy = {"Video 1", "Video 2"};
    String [] SciFi = {"Video 1", "Video 2"};
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        key = extras.getString("Category");


        ListView listView = (ListView) findViewById(R.id.item);
        listAdapter listAdapter = new listAdapter();
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(Videos.this, video.class);
                startActivity(i);
                if(key.equals("Adventure")) {
                    switch (position) {
                        case 0:
                            i.putExtra("Category", "Adventure 1");
                            startActivity(i);
                            break;
                        case 1:
                            i.putExtra("Category", "Adventure 2");
                            startActivity(i);
                            break;
                    }
                }
                else if(key.equals("Drama")){
                    switch (position) {
                        case 0:
                            i.putExtra("Category", "Drama 1");
                            startActivity(i);
                            break;
                        case 1:
                            i.putExtra("Category", "Drama 2");
                            startActivity(i);
                            break;
                    }
                }
                else if(key.equals("Comedy")){
                    switch (position) {
                        case 0:
                            i.putExtra("Category", "Comedy 1");
                            startActivity(i);
                            break;
                        case 1:
                            i.putExtra("Category", "Comedy 2");
                            startActivity(i);
                            break;
                    }
                }
                else if(key.equals("SciFi")){
                    switch (position) {
                        case 0:
                            i.putExtra("Category", "SciFi 1");
                            startActivity(i);
                            break;
                        case 1:
                            i.putExtra("Category", "SciFi 2");
                            startActivity(i);
                            break;
                    }
                }
            }

        });


        FloatingActionButton fab = findViewById(R.id.about);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAbout();
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
            if (key.equals("Adventure")) {
                name.setText(Adventure[i]);
            }
            else if (key.equals("Drama")) {
                name.setText(Drama[i]);
            }
            else if (key.equals("Comedy")) {
                name.setText(Comedy[i]);
            }
            else if (key.equals("SciFi")) {
                name.setText(SciFi[i]);
            }
            desc.setText(DESCRIPTION[i]);
            return view;
        }

    }

    private void showAbout(){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

}
