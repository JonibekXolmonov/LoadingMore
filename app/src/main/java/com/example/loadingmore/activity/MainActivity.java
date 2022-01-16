package com.example.loadingmore.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.loadingmore.R;
import com.example.loadingmore.adapter.TeacherAdapter;
import com.example.loadingmore.listener.OnButtonReachedListener;
import com.example.loadingmore.model.Teacher;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teacher> teachers = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refreshTeacherList();

        refreshAdapter();
    }

    void refreshAdapter() {
        TeacherAdapter teacherAdapter = new TeacherAdapter(teachers);
        recyclerView.setAdapter(teacherAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    teacherAdapter.addTeachers(teachers);
                    refreshTeacherList();
                    makeToast();
                    teacherAdapter.addTeachers(fillTeachersList());
                }
            }
        });
    }

    void makeToast() {
        Toast.makeText(this, "You reached the bottom", Toast.LENGTH_SHORT).show();
    }


    ArrayList<Teacher> fillTeachersList() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            if (i % 5 == 0)
                teacherList.add(new Teacher(setDefaultName(), setDefaultSubject(), false, R.drawable.image_teacher));
            else
                teacherList.add(new Teacher(setDefaultName(), setDefaultSubject(), true, R.drawable.image_teacher));
        }
        return teacherList;
    }

    void refreshTeacherList() {
        teachers.addAll(fillTeachersList());
    }

    private String setDefaultSubject() {
        String[] names = {"Math", "English", "Physics", "Biology", "Discrete math", "Geology", "Philosophy"};

        return names[new Random().nextInt(names.length)];
    }

    private String setDefaultName() {
        String[] subjects = {"Jamshid Sobirov", "Jahongir Mannonov", "Jonibek Xolmonov", "Asliddin Kenjayev", "Sardor Ergashev", "Saidahmad Ataullayev", "Javohir Karimov"};

        return subjects[new Random().nextInt(subjects.length)];
    }
}