package com.example.lab1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab1.databinding.FragmentThirdBinding;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;
    private ArrayList<String> database = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    private EditText editText;
    private Button addButton;
    private ListView listView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, database);

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = view.findViewById(R.id.editText);
        addButton = view.findViewById(R.id.button_add);

        listView = view.findViewById(R.id.listview_third);
        listView.setAdapter(adapter);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();
                if(!userInput.isEmpty()) {
                    database.add(userInput);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}