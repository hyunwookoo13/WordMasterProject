package org.example;

public class Word {

    //같은 클래스에서는 접근 가능하고, 외부에서 접근하 못하게 하기 위해 접근자를 private로 한다.
    private int id;
    private int level;
    private String word;
    private String meaning;
    //근데 이 데이터 클래스를 만들때 필요에 따라서 생성자를 만들게 되는데 기본형은 자동으로 만들어지지 않으므로 만들어준다.
    //멤버 변수를 파라미터로 받는 이런 성자들을 많이 사용하기 때문에
    Word(){}
    Word(int id, int level, String word, String meaning){
        this.id = id;
        this.level = level;
        this.word=word;
        this.meaning=meaning;
    }

    //외부에서 변경할 수 있도록 게터와 세터를 만들어준다.
    //우클릭해서 source로 가면 쉽게 만들수 있다.
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        String slevel = "";
        for(int i=0;i<level;i++) slevel += "*";
        String str = String.format("%-3s", slevel)
                + String.format("%15s", word) + "  " + meaning  ;
        return str;
    }
}
