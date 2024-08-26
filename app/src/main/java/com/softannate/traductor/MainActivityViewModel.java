package com.softannate.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
public class MainActivityViewModel extends AndroidViewModel {

    // Constructor del ViewModel, recibe una instancia de Application y la pasa al constructor de la superclase
    public MainActivityViewModel(@NonNull Application application){
        super(application);
    }

    public void traducir(String palabra){
        //creo un intent para iniciar el activity "traduccionActivity"
        Intent intent=new Intent(getApplication().getApplicationContext(), traduccionActivity.class);

        //agrego la palabra a traducir en el intent
        intent.putExtra("palabra",palabra);

        //indico que el activity debe iniciarse en una nueva tarea
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//hacer cuando no se inicia desde un activity

        //inicio el activity usando el intent creado
        getApplication().startActivity(intent);
    }
}
