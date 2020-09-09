package com.example.gadsassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class SubmitForm extends AppCompatActivity {

    public static final String url="https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";
    //input element ids found from the live form page
    public static final String Email_Address = "entry.1824927963";
    public static final String Name = "entry.1877115667";
    public static final String Last_Name = "entry.2006916086";
    public static final String Link_to_project = "entry.284483984" ;
    
    Toolbar toolbar_submit;
    TextView etFName,etLName,etEmail,etUrl;
    Button btnSubmit;
    RequestQueue queue;

    //  private final Context context;

    /*public SubmitForm(Context context) {
        this.context = context;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_form);

//        context=this;
 //       toolbar_submit= findViewById(R.id.toolbar_submit);
        etFName= findViewById(R.id.etFName);
        etLName= findViewById(R.id.etLName);
        etEmail= findViewById(R.id.etEmail);
        etUrl= findViewById(R.id.etUrl);
        btnSubmit= findViewById(R.id.btnSubmit);

        // Initializing Queue for Volley
        queue = Volley.newRequestQueue(getApplicationContext());
       // setSupportActionBar(toolbar_submit);
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make sure all the fields are filled with values
                if(TextUtils.isEmpty(etEmail.getText().toString()) ||
                        TextUtils.isEmpty(etFName.getText().toString()) ||
                        TextUtils.isEmpty(etLName.getText().toString()) ||
                    TextUtils.isEmpty(etUrl.getText().toString()))
                {
                    Toast.makeText(SubmitForm.this,"All fields are mandatory.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Check if a valid email is entered
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())
                {
                    Toast.makeText(SubmitForm.this,"Please enter a valid email.",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    postData(etEmail.getText().toString().trim(),etFName.getText().toString().trim(),etLName.getText().toString().trim(),etUrl.getText().toString().trim());
                }
/*
                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();

                //execute asynctask
                postDataTask.execute(URL,emailEditText.getText().toString(),
                        subjectEditText.getText().toString(),
                        messageEditText.getText().toString());*/
            }
        });
    }


    public void postData(final String firstName, final String lastName, final String email, final String urlGit)
    {
        /*public static final*/ String url="https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";
        //input element ids found from the live form page
        /*public static final String Email_Address = "entry.1824927963";
        public static final String Name = "entry.1877115667";
        public static final String Last_Name = "entry.2006916086";
        public static final String Link_to_project = "entry.284483984" ;*/

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.d("TAG","Response:",+ response);
                if (response.length() > 0) {
                    Snackbar.make(btnSubmit, "Successfully Posted", Snackbar.LENGTH_LONG).show();
                    etEmail.setText(null);
                    etFName.setText(null);
                    etLName.setText(null);
                    etUrl.setText(null);
                } else {
                    Snackbar.make(btnSubmit, "Try Again", Snackbar.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(btnSubmit, "Error while Posting Data", Snackbar.LENGTH_LONG).show();

            }
        }){
            /**
             * Returns a Map of parameters to be used for a POST or PUT request. Can throw {@link
             * AuthFailureError} as authentication may be required to provide these values.
             *
             * <p>Note that you can directly override {@link #getBody()} for custom data.
             *
             * @throws AuthFailureError in the event of auth failure
             */
            @Override
            protected Map<String, String> getParams() /*throws AuthFailureError*/ {
                Map<String, String> params = new HashMap<>();
                params.put(Email_Address, email);
                params.put(Name, firstName);
                params.put(Last_Name, lastName);
                params.put(Link_to_project, urlGit);
                return params /*super.getParams()*/;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        queue.add(request);
    }
}