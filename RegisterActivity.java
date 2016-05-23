package namy.healthtrack;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    ListView list;
    CheckBox male, female;
    UserAdapter adapter;
    ArrayList<UserDetails> userList;
    EditText userPass1;
    EditText userPass2;
    EditText input_fName;
    EditText input_lName;
    EditText input_email_SignUpActivity;
    EditText input_address;
    EditText input_phoneNo;
    EditText yob;
    boolean sex;
    TextInputLayout input_layoutFName,input_layoutLName,input_layoutEmail,input_layoutPass1,input_layoutPass2,input_layoutYOB,input_layoutAddress,input_layoutPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        //fname
        input_fName = (EditText)findViewById(R.id.input_fName);
        input_layoutFName= (TextInputLayout) findViewById(R.id.input_layoutFName);
        //lname
        input_lName = (EditText)findViewById(R.id.input_lName);
        input_layoutLName= (TextInputLayout) findViewById(R.id.input_layoutLName);
        //sex
        male = (CheckBox)findViewById(R.id.male);
        female = (CheckBox)findViewById(R.id.female);
        //email
        input_email_SignUpActivity = (EditText)findViewById(R.id.input_email_SignUpActivity);
        input_layoutEmail= (TextInputLayout) findViewById(R.id.input_layoutEmail);
        //password
        userPass1 = (EditText)findViewById(R.id.input_password_SignUpActivity);
        userPass2 = (EditText)findViewById(R.id.input_Retype_Password_SignUpActivity);

        input_layoutPass1= (TextInputLayout) findViewById(R.id.input_layoutPass1);
        input_layoutPass2= (TextInputLayout) findViewById(R.id.input_layoutPass2);
        //setYear
        yob = (EditText)findViewById(R.id.yob);
        input_layoutYOB= (TextInputLayout) findViewById(R.id.input_layoutYOB);
        //address
        input_address = (EditText)findViewById(R.id.input_address);
        input_layoutAddress= (TextInputLayout) findViewById(R.id.input_layoutAddress);
        //phoneNumber
        input_phoneNo= (EditText) findViewById(R.id.input_phoneNo);
        input_layoutPhoneNo= (TextInputLayout) findViewById(R.id.input_layoutPhoneNo);

        list = (ListView)findViewById(R.id.list);
        userList=new ArrayList<UserDetails>();

        new UserAsyncTask().execute("http://178.62.42.245.4400/registerUser");//pass uri

    }//onCreate

    public class UserAsyncTask extends AsyncTask<String, Void, Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {

            try{
                DefaultHttpClient client= new DefaultHttpClient();
                HttpPost post=new HttpPost(params[0]);
                  HttpResponse response = client.execute(post);

                int status = response.getStatusLine().getStatusCode();
                if(status==200){
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);

                    try {
                        JSONObject jobj = new JSONObject(data);
                        JSONArray jarray = jobj.getJSONArray("userdetails");//he kept actors
                            for(int i=0; i<jarray.length(); i++){
                                UserDetails userdetail = new UserDetails();
                                /*Keys keys = new Keys() {

                                };*/
                                JSONObject jRealObject = jarray.getJSONObject(i);
                               // String name = jRealObject.getString("fName");
                                userdetail.setfName(jRealObject.getString("fName"));
                                userdetail.setlName(jRealObject.getString("lName"));
                                userdetail.setSex(jRealObject.getString("sex"));
                                userdetail.setEmail(jRealObject.getString("email"));
                                userdetail.setPassword(jRealObject.getString("password"));
                                userdetail.setAddress(jRealObject.getString("address"));
                                userdetail.setPhoneNo(jRealObject.getString("phoneNo"));

                                userList.add(userdetail);

                            }
                      //  return true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                      return true;
                }//end if

            }catch (ClientProtocolException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            return false;
        }//end doInBackground


        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if(!result){
            //if(result==false){
                //show message to user that data was not parsed
                Toast.makeText(RegisterActivity.this, "Server not responding..Connection failed!", Toast.LENGTH_SHORT).show();
            }else{
                UserAdapter adapter = new UserAdapter(getApplicationContext(),R.layout.sign_up,userList);
                list.setAdapter(adapter);
            }
        }
    }//end UserAsyncTask

    public void registerFirstName(){
        String getUserFName = input_fName.getText().toString().trim();
        if((getUserFName.isEmpty())){
            input_layoutFName.setError(getString(R.string.err_msg_fName));
            requestFocus(input_fName);
        }else{
            registerLastName();
        }
    }

    public void registerLastName(){
        String getUserLName = input_lName.getText().toString().trim();
        if((getUserLName.isEmpty())){
            input_layoutLName.setError(getString(R.string.err_msg_lName));
            requestFocus(input_lName);

        }else{
            registerEmail();
        }
    }

    public void checkBoxClicked(View view) {

        // Is the view now checked?
       // boolean checked = ((CheckBox) view).isChecked();
        CheckBox t = (CheckBox) view;
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.male:
                if (t.isChecked()){
                    sex=male.isChecked();
                    Toast.makeText(RegisterActivity.this, "Selected Male", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RegisterActivity.this, "Select your gender", Toast.LENGTH_SHORT).show();
                break;
            case R.id.female:
                if (t.isChecked()){
                    sex=female.isChecked();
                    Toast.makeText(RegisterActivity.this, "Selected Female", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RegisterActivity.this, "Select your gender", Toast.LENGTH_SHORT).show();break;
        }//end switch

    }


    public void registerEmail(){
        String getUserEmail= input_email_SignUpActivity.getText().toString().trim();
        if((getUserEmail.isEmpty())){
            input_layoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(input_email_SignUpActivity);
        }else{
            registerPassword();
        }
    }

    public void registerPassword(){
        String st1 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&_+-=]).{8,}$";

        String getUserPass1 = userPass1.getText().toString().trim();
        String getUserPass2 = userPass2.getText().toString().trim();

        if((getUserPass1.matches(st1))){
            {

                if((getUserPass1.equals(getUserPass2))){
                    Toast.makeText(RegisterActivity.this, "verifying..", Toast.LENGTH_SHORT).show();
                }
                else{
                    // startActivity(new Intent(this, SignUpActivity.class));
                    input_layoutPass2.setError(getString(R.string.err_msg_pass2));
                    requestFocus(userPass2);
                    Toast.makeText(RegisterActivity.this, "password do not match", Toast.LENGTH_SHORT).show();
                }
            }
            //next input
            registerYear();
        }else {
            input_layoutPass1.setError(getString(R.string.err_msg_pass1));
            requestFocus(userPass1);
            //startActivity(new Intent(this, SignUpActivity.class));
            Toast.makeText(RegisterActivity.this, "password length SHOULD be an alphanumeric with 8 characters or more", Toast.LENGTH_SHORT).show();

        }
    }//registerPassword

    public void registerYear(){
        String getUserBirthYear= yob.getText().toString().trim();
        if((getUserBirthYear.isEmpty())){
            input_layoutYOB.setError(getString(R.string.err_msg_yob));
            requestFocus(yob);
        }else{
            registerAddress();
        }
    }
    public void registerAddress(){
        String getUserAddress= input_address.getText().toString().trim();
        if((getUserAddress.isEmpty())){
            input_layoutAddress.setError(getString(R.string.err_msg_address));
            requestFocus(input_address);
        }else{
            registerPhoneNo();
        }
    }

    public void registerPhoneNo(){
        String getUserPhone= input_phoneNo.getText().toString().trim();
        if((getUserPhone.isEmpty())){
            input_layoutPhoneNo.setError(getString(R.string.err_msg_phoneNo));
            requestFocus(input_phoneNo);

        }else{
            Toast.makeText(RegisterActivity.this, "Registered!!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomePage.class));
            }
    }

    public void requestFocus(View vw){
        if(vw.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void process(View v){
        switch (v.getId()){
            case R.id.loginButton_signUpActivity:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.registerButton_signUpActivity:
                registerFirstName();
                break;
        }
    }

}//main class
