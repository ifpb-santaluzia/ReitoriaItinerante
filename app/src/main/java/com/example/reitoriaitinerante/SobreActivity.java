package com.example.reitoriaitinerante;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SobreActivity extends AppCompatActivity {

    public TextView kaylanniTextView;
    public TextView gabrielTextView;
    public TextView tulioTextView;
    public TextView pedroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();
        kaylanniTextView = findViewById(R.id.kaylanniTextView);
        kaylanniTextView.setMovementMethod(LinkMovementMethod.getInstance());
        kaylanniTextView.setLinkTextColor(Color.GRAY);

        tulioTextView = findViewById(R.id.tulioTextView);
        tulioTextView.setMovementMethod(LinkMovementMethod.getInstance());
        tulioTextView.setLinkTextColor(Color.GRAY);

        gabrielTextView = findViewById(R.id.gabrielTextView);
        gabrielTextView.setMovementMethod(LinkMovementMethod.getInstance());
        gabrielTextView.setLinkTextColor(Color.GRAY);

        pedroTextView = findViewById(R.id.pedroTextView);
        pedroTextView.setMovementMethod(LinkMovementMethod.getInstance());
        pedroTextView.setLinkTextColor(Color.GRAY);
    }


}
