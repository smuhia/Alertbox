package com.muhia.alertbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonclose;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonclose =(Button)findViewById(R.id.btnclose);
        builder=new AlertDialog.Builder(this);
    }

    public void CloseApp(View view) {
       builder.setMessage(R.string.dialog_message)
               .setCancelable(false)
               .setPositiveButton("Yes close", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                       Toast.makeText(MainActivity.this, "You closed the app", Toast.LENGTH_SHORT).show();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                       Toast.makeText(MainActivity.this, "thanks for sticking around", Toast.LENGTH_SHORT).show();
                   }
               });
       AlertDialog alertDialog=builder.create();
       alertDialog.setTitle(R.string.dialog_title);
       alertDialog.show();


    }
}
