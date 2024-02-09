package com.example.internalapplication_open;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button camera_button;
    Button video_button;
    Button gallery_button;
    Button contact_button;
    Button browse_button;

    EditText edit_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           camera_button = findViewById(R.id.camerabtn);
           video_button =findViewById(R.id.videobtn);
           gallery_button =findViewById(R.id.gallerybtn);
           contact_button=findViewById(R.id.contactbtn);
           browse_button=findViewById(R.id.browsebtn);
     edit_text = findViewById(R.id.editText);

           // Open phone camera on button click
         // Code Below -->

           camera_button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                 Intent i = new Intent();
                 i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivity(i);


               }
           });


        // Open phone camera Video option on button click
        // Code Below -->


        video_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);


            }
        });

        // Open phone galary photos on button click
        // Code Below -->

        gallery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
               i.setAction(Intent.ACTION_VIEW);
               //Api for gallery
               i.setData(Uri.parse("content://media/external/images/media/"));
                   startActivity(i);

            }
        });


        // Open phone contact option on button click
        // Code Below -->


        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                //Api for contact
                i.setData(Uri.parse("content://contacts/people"));
                startActivity(i);

            }
        });

        // Open specific website by typing in EditText & on button click
        // Code Below -->

        browse_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                String text = edit_text.getText().toString();
                i.setData(Uri.parse("https://"+text));
                startActivity(Intent.createChooser(i,"title"));

            }
        });




    }
}