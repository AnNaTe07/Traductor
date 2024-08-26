package com.softannate.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class traduccionActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableIngles;//para mostrar la traduccion
    private MutableLiveData<Integer> mutableImg;//para mostrar la imagen de la traduccion
    private MutableLiveData<String> mutableNoEncontrado;//para mostrar el texto no encontrado
    private MutableLiveData<Integer>mutableNoEncontradoImg;//para mostrar la imagen de no encontrado

    private ArrayList<Palabra>lista;//Array con traducciones

    public traduccionActivityViewModel(@NonNull Application application) {
        super(application);
        lista = new ArrayList<>();
        lista.add(new Palabra("cama", "bed", R.drawable.cama));
        lista.add(new Palabra("escalera", "ladder", R.drawable.escalera));
        lista.add(new Palabra("mesa", "table", R.drawable.mesa));
        lista.add(new Palabra("pelota", "ball", R.drawable.pelota));
        lista.add(new Palabra("puerta", "door", R.drawable.puerta));
        lista.add(new Palabra("silla", "chair", R.drawable.silla));
        lista.add(new Palabra("sillon", "armchair", R.drawable.sillon));
    }

    //LiveData para la traduccion en ingles
    public LiveData<String> getMutableIngles(){
        if(mutableIngles == null){
            mutableIngles = new MutableLiveData<>();
        }
        return mutableIngles;
    }

    //LiveData para la imagen
    public LiveData<Integer> getMutableImg(){
        if(mutableImg == null){
            mutableImg= new MutableLiveData<>();
        }
        return mutableImg;
    }

    //LiveData para texto no encontrado
    public LiveData<String> getMutableNoEncontrado(){
        if(mutableNoEncontrado == null){
            mutableNoEncontrado = new MutableLiveData<>();
        }
        return mutableNoEncontrado;
    }

    //LiveData para imagen no encontrado
    public LiveData<Integer> getMutableNoEncontradoImg(){
        if(mutableNoEncontradoImg == null){
            mutableNoEncontradoImg= new MutableLiveData<>();
        }
        return mutableNoEncontradoImg;
    }

    // metodo para traducir la palabra y actualizo los LiveData
    public void traducir(Intent intent){
        // Obtengo la palabra pasada en el Intent
        String palabra= intent.getStringExtra("palabra");
        boolean encontrado=false;

        // Recorro la lista de palabras para encontrar la traducción
        for(Palabra item:lista) {
            // Si encuentro la palabra, actualizo los LiveData con la traducción y la imagen
            if (item.getEspaniol().equalsIgnoreCase(palabra)) {
                mutableIngles.setValue(item.getIngles());
                mutableImg.setValue(item.getImagen());
                encontrado = true;
                break;
            }
        }
        //sino actualizo los LiveData con mensaje e imagen de no encontrado
        if(!encontrado){
            mutableNoEncontrado.setValue("Palabra no encontrada");
            mutableNoEncontradoImg.setValue((R.drawable.no_encontrado));

        }
    }
}
