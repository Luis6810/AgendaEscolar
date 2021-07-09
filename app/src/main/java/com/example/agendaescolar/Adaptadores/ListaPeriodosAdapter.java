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

public class ListaPeriodosAdapter extends RecyclerView.Adapter<ListaPeriodosAdapter.TareaViewHolder> {

    ArrayList<Tareas> listaTareas;

    public ListaPeriodosAdapter(ArrayList<Tareas> listaTareas){
        this.listaTareas = listaTareas;
    }

    @NonNull
    @NotNull
    @Override
    public ListaPeriodosAdapter.TareaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_periodos,null,false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListaPeriodosAdapter.TareaViewHolder holder, int position) {
        holder.viewPeriodo.setText(listaTareas.get(position).getMateria());

    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder {

        TextView viewPeriodo;

        public TareaViewHolder(View itemView){
            super(itemView);

            viewPeriodo=itemView.findViewById(R.id.viewNombrePeriodo);


        }
    }
}
