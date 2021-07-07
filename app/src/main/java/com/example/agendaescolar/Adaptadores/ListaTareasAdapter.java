package com.example.agendaescolar.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendaescolar.Entidades.Tareas;
import com.example.agendaescolar.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListaTareasAdapter extends RecyclerView.Adapter<ListaTareasAdapter.TareaViewHolder> {

    ArrayList<Tareas> listaTareas;

    public ListaTareasAdapter(ArrayList<Tareas> listaTareas){
        this.listaTareas = listaTareas;
    }

    @NonNull
    @NotNull
    @Override
    public ListaTareasAdapter.TareaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tareas,null,false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListaTareasAdapter.TareaViewHolder holder, int position) {
        holder.viewNombre.setText(listaTareas.get(position).getNombre());
        holder.viewMateria.setText(listaTareas.get(position).getMateria());
        holder.viewFecha.setText(listaTareas.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewMateria, viewFecha;

        public TareaViewHolder(View itemView){
            super(itemView);

            viewNombre=itemView.findViewById(R.id.viewNombre);
            viewMateria=itemView.findViewById(R.id.viewMaterias);
            viewFecha=itemView.findViewById(R.id.viewFecha);

        }
    }
}
