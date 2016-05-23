package namy.healthtrack;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by BANGALORE on 5/15/2016.
 */
public class ResetPassword extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

    }

    public void doSomething(View v){
        switch (v.getId()){
            case R.id.resetButton:
                Toast.makeText(ResetPassword.this, "password reset", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ResetPassword.this, LoginActivity.class));
                break;
            case R.id.cancelButton:
                Toast.makeText(ResetPassword.this, "cancel button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ResetPassword.this, LoginActivity.class));

        }
    }

}
