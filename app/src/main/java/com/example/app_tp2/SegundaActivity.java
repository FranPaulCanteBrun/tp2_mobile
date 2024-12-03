package com.example.app_tp2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.app_tp2.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private ActivitySegundaBinding binding;
    private TraductorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(TraductorViewModel.class);

        String palabraEsp = getIntent().getStringExtra("palabraEsp");
        viewModel.traducirPalabra(palabraEsp);

        viewModel.getPalabraIng().observe(this, palabraIng ->
            binding.txtPalabraIng.setText(palabraIng)
        );

        viewModel.getImagen().observe(this, img ->
                binding.imgPalabra.setImageResource(img)
        );
    }
}
