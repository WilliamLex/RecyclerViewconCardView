package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapprecyclerview.R;

import java.util.List;

import Modelos.Productos;
import Modelos.Usuario;

public class AdptadorUsuarios extends RecyclerView.Adapter<AdptadorUsuarios.UsuarioViewHolder>{

    private Context Ctx;
    private List<Productos> lstUsuarios;

    public AdptadorUsuarios(Context mCtx, List<Productos> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.layitemview, null);
        return new UsuarioViewHolder(view);
    }

    // adapta la data con la vista
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Productos usuario = lstUsuarios.get(position);
        holder.textViewName.setText(usuario.getTitle());
        holder.textViewMail.setText(usuario.getCategory());
        holder.textViewURLAvatar.setText(usuario.getDescription());
        Glide.with(Ctx)
                .load(usuario.getThumbnail())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {return lstUsuarios.size(); }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewURLAvatar, textViewMail;
        ImageView imageView;
        public UsuarioViewHolder(View itemView) {
            super(itemView);
            textViewName= itemView.findViewById(R.id.txtName);
            textViewURLAvatar = itemView.findViewById(R.id.txtAvatar);
            textViewMail = itemView.findViewById(R.id.txtMail);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
