package com.example.obstreperous.AuthenticationAndAuthorization;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.obstreperous.R;
import com.example.obstreperous.SettingsActivity;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;



public class SecureAuthentication extends AppCompatActivity implements View.OnClickListener {

    private EditText userName, password;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_authentication);

        userName = (EditText) findViewById(R.id.editText13);
        password = (EditText) findViewById(R.id.editText14);
        Button login = (Button) findViewById(R.id.button35);
        login.setOnClickListener(this);


        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent Settings = new Intent(SecureAuthentication.this, SettingsActivity.class);
            startActivity(Settings);
        }

        return super.onOptionsItemSelected(item);
    }


    // Checks to see if the text fields are empty, will not continue until filled

    private boolean CheckFields() {
        String testUser, testPass;
        userName = (EditText) findViewById(R.id.editText13);
        password = (EditText) findViewById(R.id.editText14);
        testUser = userName.getEditableText().toString();
        testPass = password.getEditableText().toString();
        if (testUser.isEmpty() || testPass.isEmpty() || testUser.contentEquals("") || testPass.contentEquals("")) {
            return false;
        } else {
            return true;
        }
    }


    // After clicking the Auth Button, the entered texts will be passed into the POST argument

    @Override
    public void onClick(View v) {
        final String givenUsername = userName.getEditableText().toString();
        final String givenPassword = password.getEditableText().toString();
        if (v.getId() == R.id.button35) {
            try {
                if (CheckFields()) {
                    sendPost(givenUsername, givenPassword);
                }

            } catch (Exception e) {

            }
        }
    }


    private void sendPost(final String givenUsername, final String givenPassword) throws Exception {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                OutputStream os;

                try {
                    CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");
                    KeyStore ksTrust = KeyStore.getInstance("BKS");
                    InputStream caInput = new BufferedInputStream(getResources().openRawResource(R.raw.mytruststore));





                    try {


                        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

                        final String IPAddress = SP.getString("Changed_IPAddress", "NA");

                        final String IP = "https://" + IPAddress + ":4430";
                        URL url = new URL(IP);



                        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                            @Override
                            public boolean verify(final String hostname, SSLSession session) {

                                if (IPAddress.equals(hostname))

                                    return true;
                                else

                                    return false;

                            }
                        };

                        // Initialise the TMF as you normally would, for example:
                        // TrustManager decides which certificate authorities to use.
                        TrustManagerFactory tmf = TrustManagerFactory
                                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        tmf.init(ksTrust);


                        TrustManager[] trustManagers = tmf.getTrustManagers();
                        final X509TrustManager origTrustmanager = (X509TrustManager)trustManagers[0];

                        TrustManager[] wrappedTrustManagers = new TrustManager[]{
                                new X509TrustManager() {
                                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                        return origTrustmanager.getAcceptedIssuers();
                                    }

                                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                                        try {
                                            origTrustmanager.checkClientTrusted(certs, authType);
                                        } catch (CertificateException uo) {

                                        }
                                    }

                                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                                        try {
                                            origTrustmanager.checkServerTrusted(certs, authType);
                                        } catch (CertificateException e) {

                                        }


                                    }
                                }
                        };



                        SSLContext sslContext = SSLContext.getInstance("TLS");
                        sslContext.init(null, wrappedTrustManagers, null);
                        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

                        HttpsURLConnection urlConnection =
                                (HttpsURLConnection) url.openConnection();

                        urlConnection.setHostnameVerifier(hostnameVerifier);

                        String parameters = "username="+givenUsername+"&password="+givenPassword;

                        urlConnection.setRequestMethod("POST");
                        urlConnection.setDoInput(true);
                        urlConnection.setDoOutput(true);

                        OutputStreamWriter request;

                        HttpsURLConnection httpResponse = (HttpsURLConnection) url.openConnection();
                        httpResponse.setHostnameVerifier(hostnameVerifier);
                        httpResponse.setRequestMethod("POST");
                        request = new OutputStreamWriter(httpResponse.getOutputStream());
                        request.write(parameters);
                        request.flush();
                        request.close();

                        String line = "";

                        InputStreamReader isr = new InputStreamReader(httpResponse.getInputStream());
                        BufferedReader reader = new BufferedReader(isr);
                        StringBuilder sb = new StringBuilder();
                        while ((line = reader.readLine()) != null)
                        {
                            sb.append(line + "\n");
                        }
                        isr.close();
                        reader.close();




                    } catch (RuntimeException cpe) {
                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                } catch (CertificateException cert) {
                    System.out.println(cert);

                }  catch (KeyStoreException keys) {
                    System.out.println(keys);

                } catch (NoSuchAlgorithmException nsa) {
                    System.out.println(nsa);

                } catch (KeyManagementException kme) {
                    System.out.println(kme);

                } catch (IllegalStateException nc) {
                    Toast.makeText(getApplicationContext(), "Import certificate into burp", Toast.LENGTH_LONG).show();
                }

                 catch (NoSuchProviderException prov) {
                    System.out.println(prov);

                }
                String parameters = params.toString();
                return parameters;
            }


            @Override
            protected void onPostExecute(String result) {
                try {

                    super.onPostExecute(result);

                    if (result.equals("OK")) {
                        Toast.makeText(getApplicationContext(), "Check Burp for Credentials...", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Check Burp for Credentials...", Toast.LENGTH_LONG).show();
                    }

                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Make sure http server, burpsuite and IP address are set and running", Toast.LENGTH_LONG).show();
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        try {
            sendPostReqAsyncTask.execute(givenUsername, givenPassword);

        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Make sure proxy server is running", Toast.LENGTH_LONG).show();
        }
    }
}

//Password for certificate.p12 is "secret" <-- upload this to burp to see https traffic
