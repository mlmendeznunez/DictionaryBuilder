import java.util.ArrayList;
import java.time.LocalDateTime;

public class Word { //class Word
    private int mId;
    private String mInputWord;
    private static ArrayList<Word> instances = new ArrayList<Word>();
    private ArrayList<Definition> mWordDefinition;

  public Word(String inputword) {
    mInputWord = inputword;
    instances.add(this); 
    mId = instances.size(); 
    mWordDefinition = new ArrayList<Definition>();
  }

  public String getInputWord(){
    return mInputWord;
  }

  public int getId(){
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mWordDefinition;
  }

  public void addDefinition(Definition definition){ 
    mWordDefinition.add(definition); 
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear(); 
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

} //class Task
