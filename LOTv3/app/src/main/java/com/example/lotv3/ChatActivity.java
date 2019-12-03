package com.example.lotv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
    public void onSend(View view)
    {
        alert("teste 1");
        alert("teste 2");
    }

    public void alert(String msg)
    {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}
