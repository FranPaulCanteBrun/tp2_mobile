package com.example.app_tp2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
public class TraductorViewModel extends ViewModel {
    private final MutableLiveData<String> palabraIng = new MutableLiveData<>();
    private final MutableLiveData<Integer> imagen = new MutableLiveData<>();
    private final List<Palabra> palabras;

    public TraductorViewModel() {
        palabras = new ArrayList<>();
        palabras.add(new Palabra("gato", "cat", R.drawable.gato));
        palabras.add(new Palabra("perro", "dog", R.drawable.perro));
        palabras.add(new Palabra("perrito", "puppy", R.drawable.perrito));
        palabras.add(new Palabra("casa", "house", R.drawable.casa));
        palabras.add(new Palabra("conejo", "bunny", R.drawable.conejito));
        palabras.add(new Palabra("manzana", "apple", R.drawable.manzana));
    }

    public LiveData<String> getPalabraIng() {
        return palabraIng;
    }

    public LiveData<Integer> getImagen() {
        return imagen;
    }

    public void traducirPalabra(String palabraEsp) {
        for (Palabra palabra : palabras) {
            if (palabra.getPalabraEsp().equalsIgnoreCase(palabraEsp)) {
                palabraIng.setValue(palabra.getPalabraIng());
                imagen.setValue(palabra.getImg());
                return;
            }
        }
        palabraIng.setValue("No disponible");
        imagen.setValue(R.drawable.nada1);
    }
}
