package com.whackyard.mytest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nazila on 18/10/2016.
 */

public class PopUpActivity extends AppCompatActivity {

    private Button btnPop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);btnPop=(Button)findViewById(R.id.btnBgChange);
        btnPop.setText("Choose Color for BG");
        btnPop.setTextSize(25f);
        btnPop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(PopUpActivity.this, btnPop);

                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId()== R.id.clRed)
                            btnPop.setBackgroundColor(Color.RED);

                        if (item.getItemId()==R.id.clBlue)
                            btnPop.setBackgroundColor(Color.BLUE);

                        if (item.getItemId()==R.id.clGreen)
                            btnPop.setBackgroundColor(Color.GREEN);

                        if( item.getItemId()== R.id.clCyan)
                            btnPop.setBackgroundColor(Color.CYAN);


                        return true;

                    }

                });
                popup.show();
            }

        });
    }
}

