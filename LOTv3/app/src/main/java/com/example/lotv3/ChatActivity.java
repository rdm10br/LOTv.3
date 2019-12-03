package com.example.lotv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lotv3.util.Mensagem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ChatActivity extends AppCompatActivity
{

    private FirebaseUser Userid = FirebaseAuth.getInstance().getCurrentUser();
    String Uid = Userid.getUid();
    private FirebaseFirestore DB = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }
    public void onSend(View view)
    {
        EditText msgEdt = findViewById(R.id.messageET);
        String Msg= msgEdt.toString();
        if(!TextUtils.isEmpty(Msg)){
            Mensagem msg= new Mensagem(Uid,Msg);
            DB.collection("Mensagens").document(Userid.getUid()).set(msg);
            alert("teste 2");
            }
        alert("teste 1");
    }



    public void alert(String msg)
    {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}
