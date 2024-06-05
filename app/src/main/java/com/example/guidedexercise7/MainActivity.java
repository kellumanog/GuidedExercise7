package com.example.guidedexercise7;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView rate;
    Button click, close;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge7_rating_bar_alert_dialog);

        // Initialize views
        ratingBar = findViewById(R.id.ratingBar);
        rate = findViewById(R.id.tvResultGE7);
        click = findViewById(R.id.btnClickGE7);
        close = findViewById(R.id.btnCloseGE7);
        alertDialogBuilder = new AlertDialog.Builder(this);

        // Set listeners and handlers
        showRating();
        closeApplication();
    }

    public void showRating(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(ratingBar.getRating() >= 3){
                    rate.setTextColor(Color.GREEN);
                }else{
                    rate.setTextColor(Color.RED);
                }
                rate.setText("Rate: " + ratingBar.getRating());
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Rate: " +
                        ratingBar.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void closeApplication(){
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder.setTitle("Warning Message!")
                        .setMessage("Do you want to close the Application?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false);
                alertDialogBuilder.show();
            }
        });
    }
}