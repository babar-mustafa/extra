package com.example.babarmustafa.saylani_marathon.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BabarMustafa on 2/24/2017.
 */

public class Tabadapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mfragmentArrayListl;
    Context context;

    public Tabadapter(FragmentManager fm, ArrayList mfragmentArrayListl) {
        super(fm);
        this.mfragmentArrayListl = mfragmentArrayListl;

    }




    @Override
    public Fragment getItem(int position) {
        return mfragmentArrayListl.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentArrayListl.size();
    }
}
/*
//package com.example.babarmustafa.chatapplication;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.drawable.GlideDrawable;
//import com.bumptech.glide.request.RequestListener;
//import com.bumptech.glide.request.target.Target;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.mikhaellopez.circularimageview.CircularImageView;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
///**
// * Created by BabarMustafa on 10/20/2016.
// */
//
//public class Signup_Adapter extends BaseAdapter {
//
//    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    private Signup_Adapter listapater;
//    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//
//    private ArrayList<User> dataList;
//    private Context context;
//
//    public Signup_Adapter(ArrayList<User> dataList, Context context) {
//        this.dataList = dataList;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return dataList.size();
//    }
//
//    @Override
//    public User getItem(int position) {
//        return dataList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        // final View inflater = LayoutInflater.from(MainView.this).inflate(R.layout.for_messages,null);
//        View view = inflater.inflate(R.layout.signle_user_show, null);
//
//
//        TextView forname = (TextView) view.findViewById(R.id.v_username);
//        CircularImageView pcircularImageView = (CircularImageView) view.findViewById(R.id.profile_view);
//        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_user);
//
//
//        final User data = dataList.get(position);
//
//        String username = data.getName();
////        String iml = data.getProfile_image();
////        Toast.makeText(context, ""+iml, Toast.LENGTH_SHORT).show();
//
//
//
////mAuth.getCurrentUser().toString();
//
//        //to still the condition after changes
//        final User todoChekd = (User) getItem(position);
//        forname.setText(dataList.get(position).getName());
////        System.out.print(""+data.getProfile_image());
////        Picasso.with(context).load(data.getProfile_image()).into(pcircularImageView);
//        Glide.with(context)
//                .load(data.getProfile_image())
//                .error(R.drawable.user1)
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        progressBar.setVisibility(View.GONE);
//                        return false;
////                        pcircularImageView.setImageURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/chatapplication-f99c2.appspot.com/o/grou_ico.png?alt=media&token=b664fb78-2b74-49b5-8297-6bc0e9e3c6c9"));
//
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        progressBar.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
//                .into(pcircularImageView);
//
//
//        return view;
//    }
//}
//usagers
//package com.example.babarmustafa.chatapplication.Chat_Work;
//
//
//        import android.content.Context;
//        import android.content.DialogInterface;
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.support.annotation.NonNull;
//        import android.support.v4.app.Fragment;
//        import android.support.v7.app.AlertDialog;
//        import android.util.Log;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.AdapterView;
//        import android.widget.EditText;
//        import android.widget.ListView;
//        import android.widget.Toast;
//
//        import com.example.babarmustafa.chatapplication.MainActivity;
//        import com.example.babarmustafa.chatapplication.R;
//        import com.example.babarmustafa.chatapplication.Signup_Adapter;
//        import com.example.babarmustafa.chatapplication.User;
//        import com.google.firebase.auth.FirebaseAuth;
//        import com.google.firebase.auth.FirebaseUser;
//        import com.google.firebase.database.ChildEventListener;
//        import com.google.firebase.database.DataSnapshot;
//        import com.google.firebase.database.DatabaseError;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//        import com.google.firebase.database.ValueEventListener;
//
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.Map;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class Members extends Fragment {
//    private ListView emailList;
//    private ArrayList<User> messages;
//    private Signup_Adapter listAdapter;
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    private User uSer;
//    ArrayList<String> list;
//    User data;
//    DatabaseReference database;
//    String pId;
//    private Context context;
//    String push1;
//    String push2;
//    String push3;
//    public HashMap<String, String> hashObj = new HashMap<>();
//    public HashMap<String, String> hashObj2 = new HashMap<>();
//    String friend_uid_on_clicked;
//    String friend_pic;
//    String friend_name;
//    String friend_email;
//    String friend_gender;
//
//    Conver e;
//
//
//    //toDO myTodo;
//
//
//    public Members() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_members, container, false);
//
//
//        list = new ArrayList<>();
//
//        mAuth = FirebaseAuth.getInstance();
//        if(mAuth.getCurrentUser().getUid() != null) {
//            final String login_user = mAuth.getCurrentUser().getUid();
//        }
//        database = FirebaseDatabase.getInstance().getReference();
//
//
//        emailList = (ListView) view.findViewById(R.id.list_view);
//        messages = new ArrayList<>();
//        listAdapter = new Signup_Adapter(messages, getActivity());
//        emailList.setAdapter(listAdapter);
//
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//
//                    // User is signed in
//
//
//                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
//                } else {
//                    // User is signed out
//                    Intent call = new Intent(getActivity(), MainActivity.class);
//                    call.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(call);
//                    Log.d("TAG", "onAuthStateChanged:signed_out");
//                }
//                // ...
//            }
//        };
//
//
//        //for cne to one
////        push2 = database.getRef().push().getKey();
////        push3 = database.getRef().push().getKey();
////        conversationId = database.getRef().push().getKey();
////        Toast.makeText(getActivity(), "" + conversationId, Toast.LENGTH_SHORT).show();
//        // conversationId = database.getRef().push().getKey();
//
//        emailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                Intent conwindow = new Intent(getActivity(), ConversationActivity.class);
////
//
//
//                friend_uid_on_clicked = list.get(position);
//                friend_pic = messages.get(position).getProfile_image();
//                friend_name = messages.get(position).getName();
//                friend_gender = messages.get(position).getGEnder();
//                friend_email =  messages.get(position).getEmail();
//
//
//                conwindow.putExtra("friend_uid", friend_uid_on_clicked);
//                conwindow.putExtra("friend_image", friend_pic);
//                conwindow.putExtra("friend_name", friend_name);
//                conwindow.putExtra("friend_email", friend_email);
//                conwindow.putExtra("friend_gender", friend_gender);
//
//
//                conwindow.putExtra("imp", friend_uid_on_clicked);
//                startActivity(conwindow);
//            }
//        });
//
//
//        emailList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, final View view, int position, long id) {
//                pId = list.get(position);
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                final View vieww = LayoutInflater.from(getActivity()).inflate(R.layout.for_messages, null);
//                final EditText mytext = (EditText) vieww.findViewById(R.id.formessages);
//
//                builder.setTitle("Notifications window");
//                builder.setMessage("Write the Meeage...?");
//                builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        String UUID = mAuth.getCurrentUser().getUid();
//                        Log.d("v", "" + UUID);
//
//
//                        // EditText mytext = (EditText) view.findViewById(R.id.formessages);
//
//                        Log.d("v", "" + mytext.getText().toString());
//
//                        NotificationMessage notificationMessage = new NotificationMessage(mytext.getText().toString(), database.child("Notifications").child(UUID).push().getKey().toString(), UUID);
//
///*
//                        HashMap<String, String> result = new HashMap<>();
//                        result.put("uid", UUID);
//                        result.put("pushId", database.child("Notifications").child(UUID).push().getKey());
//                        result.put("message", mytext.getText().toString());*/
//
//                        database.child("Notifications").child(pId).child(notificationMessage.getPushId()).setValue(notificationMessage);
//
//                    }
//                });
//
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getActivity(), "cancel", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                builder.setView(vieww);
//                builder.create().show();
//                return true;
//            }
//        });
//
//
//        FirebaseDatabase.getInstance().getReference().child("User Info").addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                // This method is called once with the initial value and again
//                // whenever Data at this location is updated.
//                data = dataSnapshot.getValue(User.class);
//                list.add(data.getUID());
//                // Log.v("DATA", "" + data.getId() + data.getName() + data.getCity());
//                User email = new User(data.getUID(), data.getName(), data.getEmail(),  data.getPassword(),data.getGEnder(), data.getProfile_image());
//                messages.add(email);
//                listAdapter.notifyDataSetChanged();
////
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });
//
//
//        return view;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//
//
//    }
//
//    private void logOut() {
//        FirebaseAuth.getInstance().signOut();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//    }
//
//
////
//}

//