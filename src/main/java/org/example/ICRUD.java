package org.example;

public interface ICRUD {
    //4개의 함수를 정의한다.
    public Object add(); // 데이터 추가할 때 사용한다.
    public int update(Object obj); // 데이터 수정할 때 사용한다.
    public int delete(Object obj); // 데이터 삭제할 때 사용한다.
    public void select(int id); //데이터를 조회할 때 사용한다.

}

