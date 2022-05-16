package in.myinnos.googlecodescanner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;

import in.myinnos.googlecodescanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fullscreenContent.setOnClickListener(view -> {

            GmsBarcodeScannerOptions options = new GmsBarcodeScannerOptions.Builder()
                    .setBarcodeFormats(
                            Barcode.FORMAT_QR_CODE,
                            Barcode.FORMAT_AZTEC)
                    .build();

            //GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(this, options);
            GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(this);
            scanner.startScan()
                    .addOnSuccessListener(
                            barcode -> Toast.makeText(getApplicationContext(),
                                    "SUCCESS: " + barcode.getRawValue(), Toast.LENGTH_LONG).show())
                    .addOnFailureListener(
                            e -> Log.d("CODE_SCAN_FAILED", e.getMessage()));
        });
    }
}