package com.example.gadsassignment1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gadsassignment1.topSkill.TopSkillCustomAdapter;
import com.example.gadsassignment1.topSkill.TopSkillModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopIQSkillsFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopIQSkillsFragment extends Fragment {

    ListView listTopSkills;
    View view;

    public static List<TopSkillModel> topSkillModelList = new ArrayList<>();
    TopSkillModel topSkillModel;
   TopSkillCustomAdapter topSkillCustomAdapter;
    private Object Context;

    /*// TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/

    public TopIQSkillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param// param1 Parameter 1.
     * @param// param2 Parameter 2.
     * @return A new instance of fragment TopIQSkillsFragment.
     */
    /*// TODO: Rename and change types and number of parameters
    public static TopIQSkillsFragment newInstance(String param1, String param2) {
        TopIQSkillsFragment fragment = new TopIQSkillsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_top_i_q_skills, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listTopSkills = (ListView) view.findViewById(R.id.listTopIQ);
        fetchData();
    }

    private void fetchData() {
        String url = "https://gadsapi.herokuapp.com/api/skilliq";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String name = jsonObject.getString("name");
                        String skill = jsonObject.getString("score");
                        String country = jsonObject.getString("country");
                        String badge = jsonObject.getString("badgeUrl");

                        topSkillModel = new TopSkillModel(name, skill, country, badge);
                        topSkillModelList.add(topSkillModel);

                    }
                    topSkillCustomAdapter = new TopSkillCustomAdapter(getActivity(), topSkillModelList);
                    listTopSkills.setAdapter(topSkillCustomAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}