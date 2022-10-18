package com.elapsefeather.tagedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.elapsefeather.tagedittext.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<TagData> tagList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initTag();
        initView();
    }

    private void initTag() {
        tagList.clear();
        for (int i = 1; i <= 20; i++) {
            tagList.add(new TagData("name" + i));
        }
    }

    private void initView() {
        binding.send.setOnClickListener(v -> {
            if (binding.tagEdit.getText() == null || binding.tagEdit.getText().toString().equals(""))
                return;
            binding.tagText.setText(binding.tagEdit.getText().toString());
            binding.tagEdit.setText("");
        });

        binding.tagText.setTags(tagList);
        binding.tagText.setTagColor(getColor(R.color.purple_200));
        binding.tagEdit.setTags(tagList);
        binding.tagEdit.setTagColor(getColor(R.color.teal_700));
        binding.tagEdit.setAdapter(new TagAdapter(this, R.layout.item_tag, tagList));
    }
}