package com.example.placestest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

import static com.google.android.libraries.places.widget.AutocompleteActivity.RESULT_ERROR;

public class MainActivity extends AppCompatActivity {
    static int AUTOCOMPLETE_REQUEST_CODE = 11;
    private Button btnLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Places.initialize(getApplicationContext(), "PLACES_API_KEY");
        PlacesClient placesClient = Places.createClient(this);

        btnLocation = findViewById(R.id.btn_location);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSearchActivity();
            }
        });
    }

    private void startSearchActivity() {
        List<Place.Field> fields = Arrays.asList(Place.Field.LAT_LNG);
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode != AUTOCOMPLETE_REQUEST_CODE) {
            return;
        }

        if (resultCode == RESULT_OK) {
            Place place = Autocomplete.getPlaceFromIntent(data);
            Log.i("Location", place.getLatLng().longitude + ", " + place.getLatLng().latitude);
        } else if (resultCode == RESULT_ERROR) {
            Status status = Autocomplete.getStatusFromIntent(data);
            Log.i("Error", status.getStatusMessage());
        } else if (resultCode == RESULT_CANCELED) {
            Log.i("Cancel", "User has cancelled location search.");
        }
    }
}
