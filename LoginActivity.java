package namy.healthtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText input_emailLogin, input_passwordLogin;
    TextInputLayout input_layoutEmailLogin,input_layoutPasswordLogin;
   // public String getUserEmail,getUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //loginButton= (Button)findViewById(R.id.loginButton);
         //   loginButton.setOnClickListener(this);
        //inputs for loginActivity
        input_emailLogin = (EditText)findViewById(R.id.input_emailLogin);
        input_layoutEmailLogin= (TextInputLayout) findViewById(R.id.input_layoutEmailLogin);
        input_passwordLogin = (EditText)findViewById(R.id.input_passwordLogin);
        input_layoutPasswordLogin= (TextInputLayout) findViewById(R.id.input_layoutPasswordLogin);

    }
/*
    //login process starts here
    public void registerEmailLogin(){
        String getUserEmail= input_emailLogin.getText().toString().trim();
        if((getUserEmail.isEmpty())){
            input_layoutEmailLogin.setError(getString(R.string.err_msg_email));
            requestFocus(input_emailLogin);
        }else{
             registerPasswordLogin();
            }

    }

    public void registerPasswordLogin() {
        String getUserPassword = input_passwordLogin.getText().toString().trim();
        if (getUserPassword.isEmpty()) {
            input_layoutPasswordLogin.setError(getString(R.string.err_msg_passwordLogin));
            requestFocus(input_passwordLogin);

        } else if((input_emailLogin.equals("naamini@gmail.com"))&&(input_passwordLogin.equals("12345"))){
            startActivity(new Intent(this, HomePage.class));
            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(LoginActivity.this, "Someting is also wrong", Toast.LENGTH_SHORT).show();
            //fetch database then start activity
            //Networking n = new Networking();
            //n.execute(Networking.NETWORK_STATE_REGISTER);
            //startActivity(new Intent(this, HomePage.class));
            //startActivity(new Intent(this, HomePage.class));
           // startActivity(new Intent(this,ChatMessaging.class));
            //  startActivity(new Intent(this,ChatMessaging.class));
        }
    }*/
        /*
        String getUserEmail = editTextEmail.getText().toString();
        String getUserPassword = editTextPassword.getText().toString();

        if(getUserEmail.equals("naaminicharles@gmail.com")&& getUserPassword.equals("12345")){
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, HomeActivity.class));
        }else{
            editTextEmail.setError(getString(R.string.err_msg_emailLogin));
            requestFocus(editTextEmail);
            // Toast.makeText(MainActivity.this, "incorrect email or password", Toast.LENGTH_SHORT).show();
        }*/

    public void requestFocus(View vw){
        if(vw.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void doSomething(View v){
        switch(v.getId()){
           case R.id.loginButton:
               //registerEmailLogin();
                Toast.makeText(LoginActivity.this, "Successfully Logged in!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomePage.class));
               //startActivity(new Intent(ResetPassword.this, LoginActivity.class));
               break;
            case R.id.registerButton:
                Toast.makeText(LoginActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.forgotPass:
                Toast.makeText(LoginActivity.this, "'forgot password' button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, ResetPassword.class));
                break;
        }
    }

    /*@Override
    public void onClick(View v) {
        Toast.makeText(LoginActivity.this, "Login button clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, ResetPassword.class));

    }*/
}//end main class
