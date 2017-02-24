package com.example.babarmustafa.saylani_marathon.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.babarmustafa.saylani_marathon.MainActivity;
import com.example.babarmustafa.saylani_marathon.Model_Classes.User;
import com.example.babarmustafa.saylani_marathon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Signup extends Fragment {

    private FirebaseAuth mAuth;
    DatabaseReference databse;
    EditText for_s_name;
    EditText for_s_email;
    EditText for_s_password;
    EditText for_s_confirm_password;
    EditText for_s_country;
    EditText for_s_city;
    Button for_s_signup;
    RadioGroup u_sex ;
    RadioButton radioButton;
    User user;
    public HashMap<String, String> hashObj = new HashMap<>();
    ProgressDialog progres;
    boolean to_check =false;
    public Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        databse = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();



        for_s_name = (EditText) view.findViewById(R.id.for_student_name);
        for_s_email = (EditText) view.findViewById(R.id.for_student_email);
        for_s_country = (EditText) view.findViewById(R.id.for_student_country);
        for_s_city = (EditText) view.findViewById(R.id.for_student_city);
        for_s_password = (EditText) view.findViewById(R.id.for_student_password);
        for_s_confirm_password = (EditText) view.findViewById(R.id.for_student_password_confirm);
        for_s_signup = (Button) view.findViewById(R.id.for_student_signup);
        u_sex = (RadioGroup) view.findViewById(R.id.radioSex);
        int selectedId=u_sex.getCheckedRadioButtonId();
        radioButton=(RadioButton)view.findViewById(selectedId);
        progres = new ProgressDialog(getActivity());
        for_s_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String get_name_of_student = for_s_name.getText().toString();
                final String get_email_of_student = for_s_email.getText().toString();
                final String get_country_of_student = for_s_country.getText().toString();
                final String get_city_of_student = for_s_city.getText().toString();
                final String get_pass_of_student = for_s_password.getText().toString();
                String confirm_of_student = for_s_confirm_password.getText().toString();
                final String to_get_gender =  radioButton.getText().toString();
                if (for_s_name.getText().toString().length() == 0) {
                    Toast.makeText(getContext(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
                    for_s_name.setError("Enter the Name");
                    return;
                }  else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(for_s_email.getText().toString()).matches()) {
                    //Validation for Invalid Email Address
                    Toast.makeText(getContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    for_s_email.setError("Invalid Email address ");
                    return;
                }
                else if (for_s_password.getText().toString().length() < 5) {

                    Toast.makeText(getContext(), "Password too short", Toast.LENGTH_LONG).show();
                    for_s_password.setError(" Password must be 6 characters");
                    return;
                }

                if (get_pass_of_student.equals(confirm_of_student)){
                    to_check = true;
                    progres.setMessage("Creating a user One moment Please....");
                    progres.show();
                    progres.setCancelable(false);
                    mAuth.createUserWithEmailAndPassword(get_email_of_student,get_pass_of_student)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //if authentication failed soo....
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Authentication Failed",
                                                Toast.LENGTH_SHORT).show();
                                        progres.dismiss();
                                    }
                                    else {
//                                        if(to_check = true) {

                                        String id  = task.getResult().getUser().getUid();

//                                        String id =

                                            user = new User(id, get_name_of_student, get_email_of_student, get_country_of_student, get_city_of_student, get_pass_of_student, to_get_gender);


                                            hashObj.put("UID",user.getUID());
                                            hashObj.put("Name", user.getName());
                                            hashObj.put("Email", user.getEmail());
                                            hashObj.put("Country", user.getCountry());
                                            hashObj.put("City", user.getCity());
                                            hashObj.put("Password", user.getPassword());
                                            hashObj.put("GEnder", user.getGEnder());

                                            Toast.makeText(getActivity(), "USer  Created Succesfully", Toast.LENGTH_SHORT).show();
                                            databse
                                                    .child("User_info")
                                                    .child(Signup.this.user.getUID())
                                                    .setValue(hashObj);

                                        for_s_name.setText("");
                                        for_s_email.setText("");
                                        for_s_country.setText("");
                                        for_s_city.setText("");
                                        for_s_password.setText("");
                                        for_s_confirm_password.setText("");

                                            progres.dismiss();

                                        getActivity().getSupportFragmentManager().beginTransaction()
                                                .add(R.id.container, new Login())
                                                .commit();
//                                        getActivity().getSupportFragmentManager().popBackStack();
////                                        }
//                                        //to close activity


                                    }

                                }
                            });
//                    Toast.makeText(getContext(), "password Matc
// hed", Toast.LENGTH_SHORT).show();
                }
                else{
                    to_check = false;
                    Toast.makeText(getContext(), "PaasWord Donot Matched Please Re-Enter The password", Toast.LENGTH_SHORT).show();
                }





            }
        });
        return view;
    }

}
