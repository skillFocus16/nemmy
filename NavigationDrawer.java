//acting as the main activity

package namy.healthtrack;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class NavigationDrawer extends AppCompatActivity {

    private Toolbar toolbar;
    ListView mLeftDrawerList;
    FrameLayout frameLayout;

    android.support.v4.app.FragmentTransaction fragmentTransaction;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_bar);
        //setContentView(R.layout.activity_main_drawer);

        toolbar = (Toolbar) findViewById(R.id.action_tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        final NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_nav_drawer);
        drawerFragment.setUp(R.id.fragment_nav_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_frame,new HomeFragment());
        fragmentTransaction.commit();


        // navigationView = (NavigationView) findViewById(R.id.activity_main_drawer);
        navigationView = (NavigationView) findViewById(R.id.navigationdrawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.activity_frame,new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home Fragment...");
                        item.setChecked(true);
                        break;
                    case R.id.logouticon:
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NavigationDrawer.this);
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
                                startActivity(new Intent(NavigationDrawer.this, LoginActivity.class));
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
                        break;
                }
                return false;
            }
        });
       // mLeftDrawerList.setOnClickListener(new DrawerItemClickListener());

    }

    //DrawerItemClickListener

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }else if(id == R.id.action_about){
            return true;
        }else if(id == R.id.action_logout){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(NavigationDrawer.this);
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
                    startActivity(new Intent(NavigationDrawer.this,LoginActivity.class));
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
}
