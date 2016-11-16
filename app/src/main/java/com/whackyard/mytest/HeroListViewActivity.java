package com.whackyard.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HeroListViewActivity extends AppCompatActivity {

    String[] heroArray = {"BatMan","SuperMan","SpiderMan","IronMan",
            "CaptainAmerica","Hulk","Thor","HitMan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list_view);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, heroArray);

        ListView listView = (ListView) findViewById(R.id.lvSuperHero);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
                switch (position){
                    case 0:
                        Intent batMan = new Intent(HeroListViewActivity.this, SuperHeroDetailsActivity.class);
                        batMan.putExtra("title", "BatMan");
                        batMan.putExtra("desc", "Batman is a fictional superhero appearing in American comic books published by DC Comics. " +
                                "The character was created by artist Bob Kane and writer Bill Finger, and first appeared in Detective Comics #27.");
                        batMan.putExtra("ID", 0);
                        startActivity(batMan);
                        break;
                    case 1:
                        Intent superMan = new Intent(HeroListViewActivity.this, SuperHeroDetailsActivity.class);
                        superMan.putExtra("title", "SuperMan");
                        superMan.putExtra("desc", "Superman is a fictional superhero appearing in American comic books published by DC Comics. " +
                                "The character was created by writer Jerry Siegel and artist Joe Shuster, high school students living in Cleveland, Ohio, in 1933.");
                        superMan.putExtra("ID", 1);
                        startActivity(superMan);
                        break;
                    case 2:
                        Intent spiderMan = new Intent(HeroListViewActivity.this, SuperHeroDetailsActivity.class);
                        spiderMan.putExtra("title", "SpiderMan");
                        spiderMan.putExtra("desc", "Spider-Man is an upcoming open world action-adventure video game based on the Marvel Comics superhero Spider-Man. " +
                                "It is being developed by Insomniac Games and is to be published by Sony Interactive Entertainment for the PlayStation 4 console");
                        spiderMan.putExtra("ID", 2);
                        startActivity(spiderMan);
                        break;
                }
            }
        });
    }
}
