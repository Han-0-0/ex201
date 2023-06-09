package com.example.ex201;

import static androidx.lifecycle.Lifecycle.State.STARTED;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity {
    TextView nameTextView;
    Button button;
    private MyLocationListener myLocationListener;
    Callback callback;
    LifecycleOwner myLifecycleOwner;
    RecyclerView recyclerView;

    static UserDatabase database;
    static List<UserEntity> list;

    //    시스템이 먼저 액티비티 생성할 때 실행 . 메서드에서 활동의 전체 수명 주기 동안 한 번만 발생해야 하는 기본 애플리케이션 시작 로직을 실행
//    (사용자 인터페이스 선언(XML 레이아웃 파일에 정의됨), 멤버 변수 정의, 일부 UI 구성 등의 활동)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"User-db").build();
        List<UserEntity> list= database.userDao().getAll();


        class DataWorkerRunnable implements Runnable {

            @Override
            public void run() {
                try {
                    List<UserEntity> list= database.userDao().getAll();
                    MainActivity.list=list;
//                    Button button1 = (Button) findViewById(R.id.button1);
//                    button1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            class InsertRunnable implements Runnable {
//                                @Override
//                                public void run() {
//                                    try {
//                                        database.userDao().insert(new UserEntity("test2"));
//                                        myAdapter.notifyDataSetChanged();
//                                    }catch (Exception e){
//
//                                    }
//                                }
//                            }
//                            InsertRunnable insertRunnable = new InsertRunnable();
//                            Thread t = new Thread(insertRunnable);
//                            t.start();
//                        }
//                    });
//                    MainActivity.list=list;

                }catch (Exception e){

                }
            }
        }
        DataWorkerRunnable dataWorkerRunnable = new DataWorkerRunnable();
        Thread t = new Thread(dataWorkerRunnable);
        t.start();

//        myLocationListener = new MyLocationListener(this,callback);
//        myLocationListener.start();


///        myLocationListener = new MyLocationListener(this, getLifecycle(), callback);
//        Util.checkUserStatus(result -> {
//            if (result) {
//                myLocationListener.enable();
//            }
//        });


////                 뷰모델 사용
////        @ 1. myviewmodel 을 생성
//        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
////        @ 2. myviewmodel 의 메서드 사용
//        model.getUsers().observe(this, users -> {
//            // update UI
//        });
//
//
////        Live Data 객체 관찰
////        -데이터 받아서 텍스트뷰에 입력
//        // Get the ViewModel. - 뷰모델 만들기
//        model = new ViewModelProvider(this).get(MyViewModel.class);
//
//        // Create the observer which updates the UI. - 옵저버 만들기
//        final Observer<String> nameObserver = new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable final String newName) {
//                // Update the UI, in this case, a TextView.
//                nameTextView.setText(newName);
//            }
//        };
//
//        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.getCurrentName().observe(this, nameObserver);
//
//
////        live data 객체 업데이트
////        -데이터에 새값넣기
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String anotherName = "John Doe";
////                model.getCurrentName().setValue(anotherName);
////setValue(T)를 호출하면 관찰자는 John Doe 값과 함께 onChanged() 메서드를 호출
////모든 경우에 setValue() 또는 postValue()를 호출하면 관찰자가 트리거되고 UI가 업데이트됩니다.
////참고: 기본 스레드에서 LiveData 객체를 업데이트하려면 setValue(T) 메서드를 호출해야 합니다.
////코드가작업자 스레드에서 실행된다면 대신 postValue(T) 메서드를 사용하여 LiveData 객체를 업데이트할 수 있습니다.
//            }
//        });


//        Button button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                insert();
//            }
//        });

//        리사이클러뷰 시작

//        1. 리사이클러뷰
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
//        2. 레이아웃매니져
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
//        3. 데이터
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("good!");


        //        4. 어뎁터


        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);


//        Button button = (Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myAdapter.notifyDataSetChanged();
//            }
//        });



//        4. 어뎁터
//        MyAdapter myAdapter = new MyAdapter(arrayList);
//        recyclerView.setAdapter(myAdapter);
//
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        Button button = (Button) findViewById(R.id.button1);
//        Button button2 = (Button) findViewById(R.id.button2);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                arrayList.add(editText.getText().toString());
//                myAdapter.notifyItemInserted(arrayList.size());
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myAdapter.notifyItemInserted(arrayList.size());
//
//            }
//        });



    }

    public void insert() {
//        데이터베이스에 인서트
        class InsertRunnable implements Runnable{

            @Override
            public void run() {
                try {
                    database.userDao().insert(new UserEntity("HI"));

                }catch (Exception e){

                }
            }
        }
        InsertRunnable insertRunnable = new InsertRunnable();
        Thread t = new Thread(insertRunnable);
        t.start();

    }





    //     onCreate() 메서드가 실행을 완료하고 호출함
//     onStart()가 호출되면 활동이 사용자에게 표시되고, 앱은 액티비티를 포그라운드에 보내 상호작용할 수 있도록 준비
    @Override
    protected void onStart() {
        super.onStart();
    }

    //     onStart() 메서드가 실행을 완료하고 호출함 / onPause 중에 액티비티가 다시시작되었을때 호출함
//    이 상태에 들어갔을 때 앱이 사용자와 상호작용합니다. 어떤 이벤트가 발생하여 앱에서 포커스가 떠날 때까지 앱이 이 상태에 머무릅니다
    @Override
    protected void onResume() {
        super.onResume();
    }

    //    - 사용자가 액티비티를 떠날시 호출
//  액티비티가 포그라운드에 있지 않게 되었다는 것을 나타냅니다(다만 사용자가 멀티 윈도우 모드에 있을 경우에는 여전히 표시 될 수도 있음)
//  일시중지 상태일 때 계속 실행(또는 적절히 계속 실행)되어서는 안 되지만 잠시 후 다시 시작할 작업을 일시중지하거나 조정합니다
    @Override
    protected void onPause() {
        super.onPause();
    }

    //    - 액티비티가 사용자에게 더 이상 표시되지 않을때 호출 /시스템은 액티비티의 실행이 완료되어 종료될 시점에 onStop()을 호출할 수도 있습니다.
//    UI 관련 리소스와 작업을 완전히 해제하거나 조정할 때는 onStop()을 사용하는 것이 좋습니다.
//    컴포넌트가 화면에 보이지 않을 때 실행할 필요가 없는 기능을 모두 정지할수있음
//    (예를 들어 애니메이션을 일시중지하거나, 세밀한 위치 업데이트에서 대략적인 위치 업데이트로 전환)
//    CPU 를 비교적 많이 소모하는 종료 작업을 실행해야 합니다. 예를 들어 정보를 데이터베이스에 저장
    @Override
    protected void onStop() {
        super.onStop();
    }


    //(사용자가 액티비티를 완전히 닫거나 액티비티에서 finish()가 호출되어)액티비티가 종료되는 경우 /구성 변경(예: 기기 회전 또는 멀티 윈도우 모드)으로 인해 시스템이 일시적으로 액티비티를 소멸시키는 경우
//      액티비티가 소멸되기 전에 필요한 것을 정리
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


//    class MyLocationListener {
//        public MyLocationListener(Context context, Callback callback) {
//            // ...
//        }
//
//        public MyLocationListener(Context context, Lifecycle lifecycle, Callback callback) {
//        }
//
//        void start() {
//            // connect to system location service
//        }
//
//        void stop() {
//            // disconnect from system location service
//        }
//    }

    class MyLocationListener implements DefaultLifecycleObserver {
        private boolean enabled = false;
        Lifecycle lifecycle;
        public MyLocationListener(Context context, Lifecycle lifecycle, Callback callback) {
//       ...
        }

        @Override
        public void onStart(LifecycleOwner owner) {
            if (enabled) {
                // connect
            }
        }

        public void enable() {
            enabled = true;
            if (lifecycle.getCurrentState().isAtLeast(STARTED)) {
                // connect if not connected
            }
        }

        @Override
        public void onStop(LifecycleOwner owner) {
            // disconnect if connected
        }
    }

}
