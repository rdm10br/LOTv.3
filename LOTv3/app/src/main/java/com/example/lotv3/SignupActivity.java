package com.example.lotv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lotv3.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mauth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    private boolean ValidateForm() {

        TextView name = findViewById(R.id.nameET);
        String Nome = name.getText().toString();
        TextView number = findViewById(R.id.numberET);
        String Numero = number.getText().toString();
        TextView email = findViewById(R.id.emailET2);
        String Email = email.getText().toString();
        TextView password = findViewById(R.id.passwordET2);
        String Password = password.getText().toString();
        boolean valid = true;

        if (TextUtils.isEmpty(Nome)){
            name.setError("required");
            valid =false;
        }else{
            name.setError(null);
        }


        if (TextUtils.isEmpty(Numero)){
            number.setError("required");
            valid =false;
        }else{
            name.setError(null);
        }


        if (TextUtils.isEmpty(Email)){
            email.setError("required");
            valid =false;
        }else{
            name.setError(null);
        }

        if (TextUtils.isEmpty(Password)){
            password.setError("required");
            valid =false;
        }else{
            name.setError(null);
        }

        return valid;

    }

    private void onSignUp(View view) {


        if (ValidateForm()) {


            /*mauth.createUserWithEmailAndPassword(user, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                alert("cadastro realizado com sucesso");
                                UpdateUi(user);
                            }
                            else {
                                alert("erro no cadastro");

                            }
                        }
                    }); */


        }
    }
    private void UpdateUi(FirebaseUser username){
        if (username!=null){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

    public void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

//teste