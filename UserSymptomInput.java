package namy.healthtrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by BANGALORE on 5/13/2016.
 */
public class UserSymptomInput extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_symptom_input);
       // super.onCreateDrawer();
        //setContentView(R.layout.activity_main2);
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserSymptomInput.this, "Submit button clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }//end onCreate

    /*public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_login,menu);
        return true;
    }*/


    public void submit(View v){
        switch(v.getId()){
            case R.id.submitButton:
                Toast.makeText(UserSymptomInput.this, "Submit button clicked", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
