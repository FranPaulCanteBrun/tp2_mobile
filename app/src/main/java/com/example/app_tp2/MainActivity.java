package com.example.app_tp2;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app_tp2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTraducir.setOnClickListener(v -> {
            String palabraEsp = binding.inputPalabraEsp.getText().toString();
            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("palabraEsp", palabraEsp);
            startActivity(intent);
        });
    }
}