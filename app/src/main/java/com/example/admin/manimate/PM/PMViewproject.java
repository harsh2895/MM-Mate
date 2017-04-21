package com.example.admin.manimate.PM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.manimate.Adptr.BugAdptr;
import com.example.admin.manimate.AsyncTasks.AsyncResponse;
import com.example.admin.manimate.AsyncTasks.WebserviceCall;
import com.example.admin.manimate.DL.DLViewbug;
import com.example.admin.manimate.Helper.Utils;
import com.example.admin.manimate.Model.ViewBug;
import com.example.admin.manimate.Model.ViewProject;
import com.example.admin.manimate.R;
import com.google.gson.Gson;

public class PMViewproject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmviewproject);

        // ArrayAdapter adapter =new ArrayAdapter<String>(this,R.layout.activity_dlviewbug,bagArray);
        String[] keys = new String[]{"mode", "userId"};
        String[] values = new String[]{"viewprojects","2" };
        String jsonRequest = Utils.createJsonRequest(keys, values);

        String URL = "http://development.ifuturz.com/core/iflameapi/pms/admin/webservice.php";

        new WebserviceCall(PMViewproject.this, URL, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("app", response);
                ViewProject model = new Gson().fromJson(response, ViewProject.class);
                Toast.makeText(PMViewproject.this, model.getMessage(), Toast.LENGTH_SHORT).show();

                ListView listView =(ListView) findViewById(R.id.LvDLViewbag);




            }
        }).execute();



    }
}
