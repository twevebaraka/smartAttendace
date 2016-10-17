package com.example.rabson.ea.TeacherDummyData;

import com.example.rabson.ea.R;

import java.util.ArrayList;

/**
 * Created by Rabson on 10/6/2016.
 */
public class TeacherCollection {

    public static ArrayList<Teacher> getTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        Teacher teacher = null;

        //adding data to the collections
        teacher = new Teacher();
        teacher.setTeacherName("Hamis Shaaban");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Anita Jovin");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Rose Mary");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Consolata Olamide");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Hilda Mbaga");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Mussa Kalokola");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Mwidaddy Jr");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Baraka Tweve");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Lucy Luu");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Mkali Mwenyewe");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("John Doe");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        teacher = new Teacher();
        teacher.setTeacherName("Mwaisela Lusekelo");
        teacher.setTeacherEdit(R.drawable.ic_mode_edit_black_24dp);
        teacher.setImage(R.drawable.avatar);
        teachers.add(teacher);

        //return our collections
        return teachers;
    }
}
