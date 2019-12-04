package com.example.lotv3;

import com.example.lotv3.util.Mensagem;

public class ChatAdapter extends Mensagem
{
    /*TextView Password = findViewById(R.id.passwordET);
    String password = Password.getText().toString();*/

    private Mensagem message = new Mensagem(this.getMsg(),this.getUsuario());

    /*public Mensagem getMessage() {
        return message;
    }*/



}
