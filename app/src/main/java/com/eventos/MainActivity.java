package com.eventos;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCities;
    private TextView tvEventList;
    private String[] cities = {"Bogota", "Medellin", "Barranquilla"};
    private Map<String, String> eventsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCities = findViewById(R.id.spinnerCities);
        tvEventList = findViewById(R.id.tvEventList);
        Button btnViewEvents = findViewById(R.id.btnViewEvents);
        FloatingActionButton fabAddEvent = findViewById(R.id.fabAddEvent);

        // Cargar el Spinner con las ciudades
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCities.setAdapter(adapter);

        // Crear un mapa con eventos para cada ciudad
        eventsMap = new HashMap<>();
        eventsMap.put("Bogota", "Concierto de Rock, Feria de libros");
        eventsMap.put("Medellin", "Exposición de arte, Carrera 10K");
        eventsMap.put("Barranquilla", "Festival de comida, Concierto de jazz");

        // Acción al hacer clic en "Ver eventos"
        btnViewEvents.setOnClickListener(v -> {
            String selectedCity = spinnerCities.getSelectedItem().toString();
            String events = eventsMap.get(selectedCity);

            if (events != null) {
                tvEventList.setText("Eventos en " + selectedCity + ":\n" + events);
            } else {
                tvEventList.setText("No hay eventos disponibles para " + selectedCity);
            }
        });

        // Acción para añadir un nuevo evento
        fabAddEvent.setOnClickListener(v -> {
            showAddEventDialog();
        });
    }

    // Método para mostrar el diálogo de añadir eventos
    private void showAddEventDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Añadir nuevo evento");

        final EditText input = new EditText(this);
        input.setHint("Ingresa el nombre del evento");
        builder.setView(input);

        builder.setPositiveButton("Añadir", (dialog, which) -> {
            String selectedCity = spinnerCities.getSelectedItem().toString();
            String newEvent = input.getText().toString();

            if (!newEvent.isEmpty()) {
                String currentEvents = eventsMap.get(selectedCity);
                currentEvents = currentEvents == null ? newEvent : currentEvents + ", " + newEvent;
                eventsMap.put(selectedCity, currentEvents);

                tvEventList.setText("Eventos en " + selectedCity + ":\n" + currentEvents);
            }
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}



