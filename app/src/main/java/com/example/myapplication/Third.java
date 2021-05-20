package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Third#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Third extends Fragment {
String s1[],s2[],s3[];
RecyclerView recyclerView;
MeowBottomNavigation bottomNavigation;
ViewPager2 viewPager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Third() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Third.
     */
    // TODO: Rename and change types and number of parameters
    public static Third newInstance(String param1, String param2) {
        Third fragment = new Third();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_third, container, false);
        viewPager=getActivity().findViewById(R.id.recyclerView);
//        bottomNavigation=view.findViewById(R.id.bottomNavigation);
        s1=getResources().getStringArray(R.array.Programming_Languages);
        s2=getResources().getStringArray(R.array.Description);
        s3=getResources().getStringArray(R.array.Subject);
        recyclerView=view.findViewById(R.id.recyclerView);
        MyAdapter adapter=new MyAdapter(s1,s2,s3,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_fingerprint_24));
//        bottomNavigation.show(1,true);

//        float height=bottomNavigation.getWidth()+bottomNavigation.getX();
//        float negHeight=bottomNavigation.getWidth();
//        float coordinate=bottomNavigation.getX();
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (dy > 0 && coordinate==bottomNavigation.getX()) {
//                    bottomNavigation.animate().translationXBy(-bottomNavigation.getWidth()).setDuration(1000);
//                    Toast.makeText(getContext(), ""+bottomNavigation.getX()+" "+bottomNavigation.getWidth(), Toast.LENGTH_LONG).show();
//                } else if (dy < 0 &&bottomNavigation.getX()==-negHeight) {
//                    bottomNavigation.animate().translationXBy(bottomNavigation.getWidth()).setDuration(1000);
//                }
//            }
//        });

        return view;
    }
}