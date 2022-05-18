package `in`.myinnos.codescanner

import `in`.myinnos.codescanner.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.fullscreenContent.setOnClickListener {
            val options = GmsBarcodeScannerOptions.Builder()
                .setBarcodeFormats(
                    Barcode.FORMAT_QR_CODE,
                    Barcode.FORMAT_AZTEC
                )
                .build()

            //GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(this, options);
            val scanner = GmsBarcodeScanning.getClient(this)
            scanner.startScan()
                .addOnSuccessListener { barcode: Barcode ->
                    Toast.makeText(
                        applicationContext,
                        "SUCCESS: " + barcode.rawValue, Toast.LENGTH_LONG
                    ).show()
                }
                .addOnFailureListener { e: Exception ->
                    Log.d(
                        "CODE_SCAN_FAILED",
                        e.message!!
                    )
                }
        }

    }
}