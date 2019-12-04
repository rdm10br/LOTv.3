package com.example.lotv3;

import androidx.annotation.Nullable;
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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity
{

    private List<Mensagem>mChat;
    private FirebaseUser Userid = FirebaseAuth.getInstance().getCurrentUser();
    String Uid = Userid.getUid();
    private FirebaseFirestore DB = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


    }

    private void readMessage(){
        mChat = new ArrayList<>();

        final DocumentReference msg = DB.collection("Mensagens").document();
        msg.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e !=null){
                    alert("falha");
                    return;
                }
                if (documentSnapshot !=null && documentSnapshot.exists()){
                    mChat
                }
            }
        });
    }

    public void onSend(View view)
    {
        TextView msgEdt = findViewById(R.id.messageET);
        String Msg= msgEdt.getText().toString();
        if(!TextUtils.isEmpty(Msg)){
            Mensagem msg= new Mensagem(Uid,Msg);
            DB.collection("Mensagens").document(Userid.getUid()).set(msg);
            msgEdt.setText("",TextView.BufferType.EDITABLE);
            alert("teste 2");
            }
        alert("teste 1");

    }





    public void alert(String msg)
    {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}
