package namy.healthtrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

import static namy.healthtrack.R.id.female;//idk how this happened

/**
 * Created by BANGALORE on 5/13/2016.
 */
public class UserAdapter extends ArrayAdapter<UserDetails> {

    ArrayList<UserDetails> arraylistUsers;
    int Resource;
    Context context;
    LayoutInflater vi;

    public UserAdapter(Context context, int resource, ArrayList<UserDetails> objects) {
        super(context, resource,objects);

        arraylistUsers = objects;
        Resource = resource;
        this.context=context;

        vi= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        ViewHolder holder;

        if(convertView==null){
            convertView=vi.inflate(Resource,null);
            holder=new ViewHolder();

            holder.input_fName= (EditText) convertView.findViewById(R.id.input_fName);
            holder.input_lName= (EditText) convertView.findViewById(R.id.input_lName);
            holder.sex= (CheckBox)convertView.findViewById(female);//sex
            holder.sex=(CheckBox)convertView.findViewById(R.id.male);//sex (not sure)
            holder.input_email_SignUpActivity= (EditText) convertView.findViewById(R.id.input_email_SignUpActivity);
            holder.userPass2= (EditText) convertView.findViewById(R.id.input_Retype_Password_SignUpActivity);
            holder.yob= (EditText) convertView.findViewById(R.id.yob);
            holder.input_address= (EditText) convertView.findViewById(R.id.input_address);
            holder.input_phoneNo= (EditText) convertView.findViewById(R.id.input_phoneNo);

            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.input_fName.setText(arraylistUsers.get(position).getfName());
        holder.input_lName.setText(arraylistUsers.get(position).getlName());
        holder.sex.setText(arraylistUsers.get(position).getSex());
        holder.input_email_SignUpActivity.setText(arraylistUsers.get(position).getEmail());
        holder.userPass2.setText(arraylistUsers.get(position).getPassword());
        holder.input_address.setText(arraylistUsers.get(position).getAddress());
        holder.input_phoneNo.setText(arraylistUsers.get(position).getPhoneNo());
        return convertView;
    }

   static class ViewHolder{
        public EditText userPass1;
       public EditText userPass2;
       public EditText input_fName;
       public EditText input_lName;
       public EditText input_email_SignUpActivity;
       public EditText input_address;
       public EditText input_phoneNo;
       public EditText yob;
       public CheckBox sex;

    }
}//main class
