import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class WordTest {

  @Test
  public void getInputWord_returnsName_true() {
    Word testWord = new Word("Home");
    assertEquals("Home", testWord.getInputWord());
  }

  @Test
  public void getID_returnsWordID(){
    Word testWord = new Word("Home");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinition_initiallyreturnsEmptyArrayList(){
    Word testWord = new Word("Home");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void all_returnsTwoWords() {
    Word firstWord = new Word ("Home");
    Word secondWord = new Word ("Garden");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("Home");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("Home");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
    public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("Home");
    Definition testWordDefinition = new Definition("A place where people live");
    testWord.addDefinition(testWordDefinition);
    assertTrue(testWord.getDefinitions().contains(testWordDefinition));
  }
} //end WordTest
