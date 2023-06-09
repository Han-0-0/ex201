package com.example.ex201;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

//    @ 1. view 모델을 상속받은 myviewmodel 을 만듬
    public class MyViewModel extends ViewModel {
    private MutableLiveData<String> currentName;

    //        @ 2. livedata 를 안에 만들어줌
        private MutableLiveData<List<User>> users;

//        @ 3. 유저의 mutable 라이브데이터를 리턴해주는 메서드
//          mutable 라이브데이터가 null 일시 mutable 라이브데이터를 생성하고 loadUsers 메서드 실행후 리턴 , null 이 아닐시 그냥 리턴
        public LiveData<List<User>> getUsers() {
            if (users == null) {
                users = new MutableLiveData<List<User>>();
                loadUsers();
            }
            return users;
        }
//        @ 4. 유저의 기록을 로드하는 메서드?
        private void loadUsers() {
            // Do an asynchronous operation to fetch users.
        }

//        @ live data 객체생성 파트의 메서드 - 현재이름 리턴하기
    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

    }
