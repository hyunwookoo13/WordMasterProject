package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
	/*
	 => 난이도(1,2,3) & 새 단어 입력: 1 driveway
	  뜻 입력 : 차고 진입로
	  새 단어가 단어장에 추가되었습니다.
	 */

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;

    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        System.out.print("\n");


        return new Word(0, level, word, meaning);
    }

    public void addItem() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다. \n");
    }

    @Override
    public int update(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void select(int id) {
        // TODO Auto-generated method stub

    }

    public void listAll() {
        System.out.println("-----------------------------");
        for(int i=0;i<list.size();i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-----------------------------");
    }
    public ArrayList<Integer> listAll(String keyword) { //overloading, 같은 변수의 이름이지만, 역할을 하는 것을 불러와 사용할 수 있도록 할 수 있다.
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;
        System.out.println("-----------------------------");
        for(int i=0;i<list.size();i++) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i); //자동 변환이 되어서 list로 들어간다.
            j++;
        }
        System.out.println("-----------------------------");
        return idlist;
    }


    public void updateItem() {
        System.out.print("=> 수정할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택: ");
        int id = s.nextInt();
        s.nextLine(); // 엔터가 들어가는 것을 막아주기 위해서
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택: ");
        int id = s.nextInt();
        s.nextLine(); // 엔터가 들어가는 것을 막아주기 위해서

        System.out.print("=> 정말로 삭제하실래요?(Y/N) : ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")){ // 대소문자 상관없이 받을 수 있다.
            list.remove((int)idlist.get(id-1)); // 정수형 객체로 되어 있기 때문에 삭제가 어렵다. 그래서 정수형으로 캐스팅을 해준다.
            System.out.println("단어가 삭제되었습니다. ");
        }else {
            System.out.println("취소되었습니다. ");
        }
    }
}
