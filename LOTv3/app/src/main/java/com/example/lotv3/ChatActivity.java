package com.example.lotv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lotv3.util.Mensagem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ChatActivity extends AppCompatActivity
{

    private FirebaseUser Userid = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseFirestore DB = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }
    public void onSend(View view)
    {
        TextView msgEdt = findViewById(R.id.messageET);
        String Msg= msgEdt.toString();
        if(!TextUtils.isEmpty(Msg)){
            Mensagem msg= new Mensagem(Userid.toString(),Msg);
            DB.collection("Mensagens").document(Userid.toString()).set(msg);
            }
        alert("teste 1");
        alert("teste 2");
    }



    public void alert(String msg)
    {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}
