package com.example.lotv3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lotv3.util.Mensagem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>
{

    public static  final int MSG_TYPE_OTHER = 0;
    public static  final int MSG_TYPE_USER = 1;

    private Context mContext;
    /*private List<Chat> mChat;*/
    private List<Mensagem> mChat;

    FirebaseUser fuser;

    public ChatAdapter(Context mContext, List<Mensagem> mChat){
        this.mChat = mChat;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_USER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_currentuser_message, parent, false);
            return new ChatAdapter.ViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_other_user_message, parent, false);
            return new ChatAdapter.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {

        Mensagem chat = mChat.get(position);
        holder.show_message.setText(chat.getMsg());

        /*if (imageurl.equals("default")){
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(mContext).load(imageurl).into(holder.profile_image);
        }*/

        /*if (position == mChat.size()-1){
            if (chat.isIsseen()){
                holder.txt_seen.setText("Seen");
            } else {
                holder.txt_seen.setText("Delivered");
            }
        } else {
            holder.txt_seen.setVisibility(View.GONE);
        }*/

    }

    @Override
    public int getItemCount()
    {
        return mChat.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView show_message;
        /*public ImageView profile_image;*/
        public TextView txt_seen;

        public ViewHolder(View itemView)
        {
            super(itemView);

            show_message = itemView.findViewById(R.id.messageET);
            txt_seen = itemView.findViewById(R.id.messageTV);
        }
    }

    @Override
    public int getItemViewType(int position) {
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getSender().equals(fuser.getUid())){
            return MSG_TYPE_USER;
        } else {
            return MSG_TYPE_OTHER;
        }
    }
}