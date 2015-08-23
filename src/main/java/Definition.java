import java.time.LocalDateTime;
import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private String mWordDefinition; 
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private int mId;

  public Definition(String worddefinition) {
  mWordDefinition = worddefinition;
  mCreatedAt = LocalDateTime.now();
  mCompleted = false;
  instances.add(this);
  mId = instances.size();
  }

  public String getWordDefinition() {
    return mWordDefinition;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
} //class Definition ends here
