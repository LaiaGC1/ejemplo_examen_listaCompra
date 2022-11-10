package com.example.ejemplo_examen_listacompra.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplo_examen_listacompra.R;
import com.example.ejemplo_examen_listacompra.modelos.Producto;

import java.util.List;

public class ProductAdapters extends RecyclerView.Adapter<ProductAdapters.ProductoVH> {

    private List<Producto> objects;
    private int resource;
    private Context context;

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class ProductoVH extends RecyclerView.ViewHolder {
        TextView lblNombre;
        TextView lblCantidad;
        TextView lblPrecio;
        ImageButton btnEliminar;

        public ProductoVH( View itemView){
            super(itemView);

            lblNombre= itemView.findViewById(R.id.lblNombreProductoViewHolder);
            lblCantidad = itemView.findViewById(R.id.lblCantidadProductoViewHolder);
            lblPrecio = itemView.findViewById(R.id.lblPrecioProductoViewHolder);
        }
    }
}
