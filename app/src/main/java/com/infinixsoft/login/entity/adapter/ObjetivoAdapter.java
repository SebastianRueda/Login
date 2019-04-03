package com.infinixsoft.login.entity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.infinixsoft.login.R;

import java.util.List;

public class ObjetivoAdapter extends RecyclerView.Adapter<ObjetivoAdapter.ViewHolder> {

    private List<String> objetivos;

    public ObjetivoAdapter(List<String> objetivos) {
        this.objetivos = objetivos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_objetivo, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(objetivos.get(i));
    }

    @Override
    public int getItemCount() {
        return this.objetivos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewObjectivo;
        private CheckBox checkBoxObjetivo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewObjectivo = itemView.findViewById(R.id.textViewItemObjetivo);
            this.checkBoxObjetivo = itemView.findViewById(R.id.checkboxItem);
        }

        public void onBind(String objetivo) {
            this.textViewObjectivo.setText(objetivo);
        }
    }
}
