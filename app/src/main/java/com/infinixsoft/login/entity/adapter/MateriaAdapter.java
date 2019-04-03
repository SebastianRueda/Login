package com.infinixsoft.login.entity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infinixsoft.login.R;
import com.infinixsoft.login.entity.Materia;

import java.util.List;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.ViewHolder> {

    private List<Materia> materias;

    public MateriaAdapter(List<Materia> materias) {
        this.materias = materias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_materia, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(this.materias.get(i));
    }

    @Override
    public int getItemCount() {
        return this.materias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewMateria;
        private TextView textViewOfertada;
        private TextView textViewEstado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewMateria = itemView.findViewById(R.id.textViewMateria);
            this.textViewOfertada = itemView.findViewById(R.id.textViewOfertada);
            this.textViewEstado = itemView.findViewById(R.id.textViewEstado);
        }

        public void onBind(Materia materia) {
            this.textViewMateria.setText(materia.getNombre());
            this.textViewOfertada.setText(materia.getOfertadaCuatrimestre());
            this.textViewEstado.setText(materia.getEstado());
        }
    }
}
