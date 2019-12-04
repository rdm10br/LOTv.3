package com.example.lotv3.util;

public class Mensagem {
    private String Usuario;
    private String msg;

    public Mensagem(){
    }

    public Mensagem(String Usuario,String msg){
        this.Usuario= Usuario;
        this.msg=msg;
    }
    public String getUsuario(){
        return Usuario;
    }
    public String getMsg(){
        return msg;
    }
}
