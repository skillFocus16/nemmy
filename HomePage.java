package namy.healthtrack;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by BANGALORE on 5/13/2016.
 */
public class HomePage extends AppCompatActivity {  //} implements OnItemClickListener, View.OnClickListener {

    private Toolbar toolbar;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_bar);

        toolbar = (Toolbar) findViewById(R.id.action_tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Next button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomePage.this, UserSymptomInput.class));
            }
        });
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_nav_drawer);
        drawerFragment.setUp(R.id.fragment_nav_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            return true;
        }
        if(id==R.id.action_logout){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePage.this);
            // Setting Dialog Title
            alertDialog.setTitle("Logout...");
            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to logout?");
            // Setting Icon to Dialog
            //alertDialog.setIcon(R.drawable.logout_icon);
            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke YES event
                    startActivity(new Intent(HomePage.this,LoginActivity.class));
                    Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
                }
            });
            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            // Showing Alert Message
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }
    /*
    public void doSomething(View vw){
        switch (vw.getId()){
            case R.id.nextButton:
                //Toast.makeText(getApplicationContext(), "Next button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomePage.this,UserSymptomInput.class));
            break;
            default: System.out.println("what is this");
        }
    }*/
}//end main class
