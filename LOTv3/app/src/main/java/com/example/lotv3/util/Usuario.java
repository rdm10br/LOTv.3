package com.example.lotv3.util;

public class Usuario {
        private String Nome;
        private String Email;
        private String Numero;

        public Usuario(){}

        public Usuario(String Nome,String Email,String Numero){
            this.Nome= Nome;
            this.Email=Email;
            this.Numero=Numero;
        }
        public String getNome(){
            return Nome;
        }
        public String getEmail(){
            return Email;
        }
        public String getNumero(){
        return Numero;
        }


}
