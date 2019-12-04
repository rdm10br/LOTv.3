package com.example.lotv3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lotv3.util.Mensagem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    List<Mensagem>mChat;
    private FirebaseUser Userid = FirebaseAuth.getInstance().getCurrentUser();
    String Uid = Userid.getUid();
    private FirebaseFirestore DB = FirebaseFirestore.getInstance();
    ChatAdapter chatAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.chatRV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        /*LinearLayoutManager.setStackFrontEnd(true);*/
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void readMessage(){
        mChat = new ArrayList<>();

        reference= FirebaseDatabase.getInstance().getReference("Mensagens");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mChat.clear();
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    Mensagem mensagem = snapshot.getValue(Mensagem.class);
                    if (mensagem.getUsuario().equals(Uid)&& mensagem.getSender().equals(Userid)
                            ||mensagem.getUsuario().equals(Userid)&& mensagem.getSender().equals(Uid)){

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
