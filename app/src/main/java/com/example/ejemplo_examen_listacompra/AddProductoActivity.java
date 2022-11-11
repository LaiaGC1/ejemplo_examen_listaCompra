package com.example.ejemplo_examen_listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ejemplo_examen_listacompra.databinding.ActivityAddProductoBinding;
import com.example.ejemplo_examen_listacompra.databinding.ActivityMainBinding;
import com.example.ejemplo_examen_listacompra.modelos.Producto;

public class AddProductoActivity extends AppCompatActivity {

    private ActivityAddProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Boton Cancelar
        binding.btnCancelarAddProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        //Boton Crear
        binding.btnCrearAddProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.txtNombreAddProducto.getText().toString();
                String cantidad = binding.txtCantidadAddProducto.getText().toString();
                String precio = binding.txtPrecioAddProducto.getText().toString();

                if(!nombre.isEmpty() && !cantidad.isEmpty() && !precio.isEmpty()){
                    Producto producto = new Producto(nombre,Integer.parseInt(cantidad),Integer.parseInt(precio));
                    Bundle bundle= new Bundle();
                    bundle.putSerializable("PRODUCTO", producto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(AddProductoActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}