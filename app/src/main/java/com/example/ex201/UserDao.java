package com.example.ex201;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

//쿼리 메서드
//    쿼리 메서드는 앱 데이터베이스에서 데이터를 쿼리하거나 좀 더 복잡한 삽입, 업데이트, 삭제를 실행해야 할 때 사용합니다.

//    @Query("SELECT Name FROM UserEntity1")
//    List<UserEntity1> getName();

    @Query("SELECT * FROM UserEntity")
    List<UserEntity> getAll();

    @Query("SELECT selected FROM userentity WHERE id=:id")
    int getSelected(int id);

    @Query("DELETE FROM UserEntity WHERE selected = 0")
    void delete1();

    @Query("UPDATE UserEntity SET selected = 0 WHERE id =:id ")
    void setTrue(int id);

    @Query("UPDATE UserEntity SET selected =:bool WHERE id =:id ")
    void setSelected(int id,int bool);

    // 'user' 테이블 에서 *(전부) 를 선택해서(select) 반환
//    @Query("SELECT * FROM userentity WHERE uid IN (:userIds)")
//    List<UserEntity> loadAllByIds(int[] userIds);
    // uid가 userids 매개변수 인것만을 ,
    //'user' 에서 *(전부) 를 선택
//    @Query("SELECT * FROM userentity WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    User findByName(String first, String last);
    // first_name 이 first 매개변수와 같고 , last_name 이 last 매개변수와 같은것을 하나만
    // user 에서 모두 골라 반환
//편의메서드

    //삽입
    @Insert
    void insert(UserEntity userEntity);
    @Insert
    void insertAll(UserEntity... userEntities);
    //삭제
    @Delete
    void delete(UserEntity userEntity);

//    @Delete
//    void deleteAll(UserEntity... userEntities);
    //업데이트
    @Update
    public void updateUsers(UserEntity... userEntities);
    
}
