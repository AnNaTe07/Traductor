package com.softannate.traductor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softannate.traductor.databinding.TraduccionBinding;

public class traduccionActivity extends AppCompatActivity {

    private TraduccionBinding binding;//declaro binding para enlazar datos
    private traduccionActivityViewModel vm;//declaro view model

  @Override
    protected void onCreate(Bundle savedInstanceState){

      super.onCreate(savedInstanceState);// Llamo al método en la clase base para inicializar la actividad

      //se infla el dideño usando el binding
      binding = TraduccionBinding.inflate(getLayoutInflater());
        //vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(traduccionActivityViewModel.class);

      //seteo el contenido de la vista del activity usando el root del binding
      setContentView(binding.getRoot());

      //ViewModelProvider crea y administra las instancias del ViewModel
      vm=new ViewModelProvider(this).get(traduccionActivityViewModel.class);

      //observador para la traduccion, actualiza el TextView con la traducción
      vm.getMutableIngles().observe(this,new Observer<String>(){
          @Override
          public void onChanged(String traduccion){
              binding.etIngles.setText(traduccion);
          }
        });

        //observador para mensaje no encontrado
        vm.getMutableNoEncontrado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String traduccion) {binding.etIngles.setText(traduccion);
            }
        });

        //observador para imagen
        vm.getMutableImg().observe(this, new Observer<Integer>(){
            @Override
            public void onChanged(Integer imagen){
                binding.img.setImageResource(imagen);
            }
        });

        //observador para imagen no encontrada
        vm.getMutableNoEncontradoImg().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagen) {
                binding.img.setImageResource(imagen);}
        });

      // Llamo al método traducir en el ViewModel con el Intent recibido para traducir la palabra
        vm.traducir(getIntent());
    }
}
