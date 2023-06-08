# Android Google Code Scanner
The Google code scanner API provides a complete solution for scanning codes without requiring your app to request camera permission, while preserving user privacy. This is accomplished by delegating the task of scanning the code to Google Play services and returning only the scan results to your app. All image processing occurs on the device and Google doesn't store the results or image data.

<a href="#"><img alt="Android Language Badge" src="https://badgen.net/badge/OS/Android?icon=https://raw.githubusercontent.com/androiddevnotes/awesome-jetpack-compose-android-apps/master/assets/android.svg&color=3ddc84"/></a>

 ![Android-Google Code Scanner - Example](https://raw.githubusercontent.com/myinnos/Android-Google-Code-Scanner/main/photo1652692783_1.jpeg)
  
#### Kindly use the following links to use this library:

> This API requires Android API level 21 or above. Make sure that your app's build file uses a minSdkVersion value of 21 or higher.

In your top-level settings.gradle file, include Google's Maven repository and Maven central repository in under the dependencyResolutionManagement block:

```kotlin
dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
  }
}
```
Add the Google Play services dependency for the play-services-code-scanner SDK to your module's Gradle build file, which is commonly app/build.gradle:
```kotlin
dependencies {
  implementation 'com.google.android.gms:play-services-code-scanner:16.0.0'
}
``` 
You can configure your app to have Google Play services automatically download the scanner module to the device while your app is installed from the Play Store. If you skip this step, Google Play services will download the scanner module the first time it is used, if it has not already been installed for another use case.
```xml
<application ...>
  ...
  <meta-data
      android:name="com.google.mlkit.vision.DEPENDENCIES"
      android:value="barcode_ui"/>
  ...
</application>
``` 

How to use
-----
**(Optional) Configure the code scanner**

If you know which barcode formats you expect to read, you can improve the speed of the barcode detector by configuring it to only detect those formats. For example, to detect only Aztec code and QR codes, build a GmsBarcodeScannerOptions object as in the following example:


```kotlin
//**** kotlin ****
val options = GmsBarcodeScannerOptions.Builder()
                .setBarcodeFormats(
                    Barcode.FORMAT_QR_CODE,
                    Barcode.FORMAT_AZTEC
                )
                .build()
```   
```java
//**** java ****
GmsBarcodeScannerOptions options = new GmsBarcodeScannerOptions.Builder()
    .setBarcodeFormats(
        Barcode.FORMAT_QR_CODE,
        Barcode.FORMAT_AZTEC)
    .build();
```

**Get an instance of GmsBarcodeScanner**
```kotlin
//**** kotlin ****
val scanner = GmsBarcodeScanning.getClient(this)
// Or with a configured options
// val scanner = GmsBarcodeScanning.getClient(this, options)
```
```java
//**** java ****
GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(this);
// Or with a configured options
// GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(context, options);
```
**Request a code scanning by calling startScan()**
```kotlin
//**** kotlin ****
scanner.startScan()
    .addOnSuccessListener { barcode ->
        // Task completed successfully
    }
    .addOnCanceledListener {
        // Task canceled
    }
    .addOnFailureListener { e ->
        // Task failed with an exception
    }
```
```java
//**** java ****
scanner
    .startScan()
    .addOnSuccessListener(
        barcode -> {
          // Task completed successfully
        })
    .addOnCanceledListener(
        () -> {
          // Task canceled
        })
    .addOnFailureListener(
        e -> {
          // Task failed with an exception
        });
```
**Handle the resulting Barcode**
```kotlin
//**** kotlin ****
val rawValue: String? = barcode.rawValue
```
```java
//**** java ****
String rawValue = barcode.getRawValue();
```
##### Watch the code [here (MainActivity.java)](https://github.com/myinnos/Android-Google-Code-Scanner/blob/main/app/src/main/java/in/myinnos/googlecodescanner/MainActivity.java) and ref [Google code scanner (Beta)](https://developers.google.com/ml-kit/code-scanner)

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/Android-Google-Code-Scanner/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")    
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [PayPal](https://www.paypal.me/fansfolio)

License
-------

    Copyright 2022 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
