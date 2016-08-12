package com.example.nocturne.Authentication;

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

import com.example.nocturne.SettingsActivity;
import com.example.obstreperous.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



public class InsecureAuthentication extends AppCompatActivity implements View.OnClickListener {


    // Creates layout of Activity

    private EditText userName, password;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_authentication);
        userName = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText);
        Button login = (Button) findViewById(R.id.button30);
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
            Intent Settings = new Intent(InsecureAuthentication.this, SettingsActivity.class);
            startActivity(Settings);
        }

        return super.onOptionsItemSelected(item);
    }



    // Checks to see if the text fields are empty, will not continue until filled

    private boolean CheckFields() {
        String testUser, testPass;
        userName = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText);
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
        String givenUsername = userName.getEditableText().toString();
        String givenPassword = password.getEditableText().toString();
        if (v.getId() == R.id.button30) {
            if (CheckFields()) {
                sendPostRequest(givenUsername, givenPassword);
            }

        }
    }


    // A HTTP POST agrument is sent with username and password parameters
    // AsyncTask allows this process to be done seperately from the 'main' process

    private void sendPostRequest(String givenUsername, String givenPassword) {


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramPassword = params[1];
                HttpClient httpClient = new DefaultHttpClient();

                SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

                String IPAddress = SP.getString("Changed_IPAddress", "NA");

                String IP = "http://" + IPAddress + ":4431";




                // **** IP will need to be changed accordingly *****

                HttpPost httpPost = new HttpPost(IP);
                BasicNameValuePair username = new BasicNameValuePair("username", paramUsername);
                BasicNameValuePair password = new BasicNameValuePair("password", paramPassword);
                List nameValuePairList = new ArrayList();
                nameValuePairList.add(username);
                nameValuePairList.add(password);

                try {
                    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList);
                    httpPost.setEntity(urlEncodedFormEntity);
                    try {
                        HttpResponse httpResponse = httpClient.execute(httpPost);
                        InputStream inputStream = httpResponse.getEntity().getContent();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String bufferedStrChunk;
                        while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                            stringBuilder.append(bufferedStrChunk);
                        }
                        return stringBuilder.toString();
                    } catch (RuntimeException cpe) {

                        System.out.println("Change IP address:" + cpe);

                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                } catch (UnsupportedEncodingException uee) {
                    System.out.println("An Exception given because of UrlEncodedFormEntity argument :" + uee);
                    uee.printStackTrace();
                }

                return null;
            }

            // After the POST argument is sent, a result can be obtained from the web service
            // Toast can only be done from a 'main' process


            @Override
            protected void onPostExecute(String result) {
                try {

                    super.onPostExecute(result);
                    if (result.equals("OK")) {
                        Toast.makeText(getApplicationContext(), "Check Burp for Credentials...", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Check Burp for Credentials...", Toast.LENGTH_LONG).show();
                    }

                }
                catch (NullPointerException e) {
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


/*

    This example is insecure as it is a way for text fields to be transmitted over HTTP
    unencrypted where traffic can be proxied and suspect to MITM attacks.

    .crt and .keys are included in GitLab and can be used to set up burpsuite.

 */

