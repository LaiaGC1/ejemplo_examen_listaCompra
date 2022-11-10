package com.example.ejemplo_examen_listacompra;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.ejemplo_examen_listacompra.databinding.ActivityMainBinding;
import com.example.ejemplo_examen_listacompra.modelos.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Producto> listProductos;
    private ActivityResultLauncher<Intent> AddProductoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        listProductos = new ArrayList<>();
        inicializaLaunchers();



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddProductoLauncher.launch(new Intent(MainActivity.this, AddProductoActivity.class));
            }
        });
    }

    private void inicializaLaunchers() {
        AddProductoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Producto producto = (Producto) result.getData().getExtras().getSerializable("PRODUCTO");
                                listProductos.add(producto);
                                mostrarProductosContenedor();
                            }
                        }
                    }
                });
    }

    private void mostrarProductosContenedor(){
        binding.contentMain.contenedor.removeAllViews();
        for (int i= 0; i < listProductos.size(); i++){
            //Dato
            Producto producto = listProductos.get(i);

            //Plantilla
            View productoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.producto_view_holder, null);
            TextView lblNombre = productoView.findViewById(R.id.lblNombreProductoViewHolder);
            TextView lblCantidad = productoView.findViewById(R.id.lblCantidadProductoViewHolder);
            TextView lblPrecio = productoView.findViewById(R.id.lblPrecioProductoViewHolder);

            //Asignar Valores
            lblNombre.setText(producto.getNombre());
            lblCantidad.setText(String.valueOf(producto.getCantidad()));
            lblPrecio.setText(String.valueOf(producto.getPrecio()));

            binding.contentMain.contenedor.addView(productoView);

            productoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });

        }
    }
}