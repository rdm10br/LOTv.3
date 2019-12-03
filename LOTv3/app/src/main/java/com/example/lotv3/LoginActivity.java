package com.example.lotv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.lotv3.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity

{
    //private TextView mStatusTextView = findViewById(R.id.progressLayout);
    /*private TextView User = (TextView) findViewById(R.id.emailET);
    private String user =  User.getText().toString();
    private TextView Password = findViewById(R.id.passwordET);
    private String password = Password.getText().toString();*/

   private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onStart()
    {

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        if (currentUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //Button loginB = findViewById(R.id.login);
    //loginB.setOnClickListener(new)


    public void SignUp(View view){
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

    public void SignIn(View view)
    {
        TextView User = findViewById(R.id.emailET);
        String user =  User.getText().toString();
        TextView Password = findViewById(R.id.passwordET);
        String password = Password.getText().toString();

        if (validateForm())
        {
        mAuth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            alert("logado com sucesso");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else
                        {
                            alert("falha no login");
                        }
                    }
                });
        }

    }

    private boolean validateForm()
    {
        TextView User = findViewById(R.id.emailET);
        String user =  User.getText().toString();
        TextView Password = findViewById(R.id.passwordET);
        String password = Password.getText().toString();
        boolean valid = true;
        //EditText mEmailField = findViewById(R.id.username);
        //String email = mEmailField.getText().toString();

        if (TextUtils.isEmpty(user))
        {
            User.setError("Required.");
            valid = false;
        } else
        {
            User.setError(null);
        }
        //EditText mPasswordField = findViewById(R.id.password);
        //String password = mPasswordField.getText().toString();

        if (TextUtils.isEmpty(password))
        {
            Password.setError("Required.");
            valid = false;
        } else
        {
            Password.setError(null);
        }
        return valid;
    }

    private void updateUI(FirebaseUser username)
    {
        if (username != null){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

    /*private void getCurrentUser()
    {
        FirebaseUser username = FirebaseAuth.getInstance().getCurrentUser();
        if (username != null){
            String name = username.getDisplayName();
            String email = username.getEmail();

            String uid = username.getUid();
        }
    }*/

    public void alert(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}
