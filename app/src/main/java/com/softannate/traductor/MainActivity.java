package com.softannate.traductor;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.softannate.traductor.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;//con el binding puedo acceder a las vistas de layout
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Llamo al constructor de la superclase (AppCompatActivity)
        super.onCreate(savedInstanceState);

        //inflo el diseño usando el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //seteo el contenido de la vista del activity usando el root del binding
        setContentView(binding.getRoot());

        //creo la instancia del ViewModel
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        //configuro un onClickListener para el boton traducir
        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamo al metodo traducir del viewModel con la palabra ingresada en el editText
                vm.traducir(binding.texto.getText().toString());
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        //cuando la activity se reanuda busco el editText y...
        EditText texto = findViewById(R.id.texto);
        texto.setText(""); // Limpia el texto
    }
}