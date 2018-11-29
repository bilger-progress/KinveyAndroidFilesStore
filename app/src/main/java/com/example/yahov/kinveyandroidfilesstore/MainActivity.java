package com.example.yahov.kinveyandroidfilesstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

public class MainActivity extends AppCompatActivity {

    private Client kinveyClient;
    private String kinveyAppKey = "xxx";
    private String kinveyAppSecret = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set-up the Kinvey Client.
        kinveyClient = new Client.Builder(kinveyAppKey, kinveyAppSecret, this).build();

        // Ping Kinvey Backend to check connection.
        kinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Exception was thrown. Check logs.", Toast.LENGTH_LONG).show();
                System.out.println("Exception was thrown: " + t.getMessage());
            }

            public void onSuccess(Boolean b) {
                Toast.makeText(getApplicationContext(), "Kinvey Ping Response: " + b.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
