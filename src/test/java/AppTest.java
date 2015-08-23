import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("My Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    
    fill("#inputword").with("Home");
    submit(".btn");
    assertThat(pageSource()).contains("Home");
    
    fill("#worddefinition").with("place to live");
    submit(".btn");
    assertThat(pageSource()).contains("place to live");
    
    fill("#worddefinition").with("family");
    submit(".btn");
    assertThat(pageSource()).contains("family");

    click("a", withText("Done adding definitions; go home!"));

    assertThat(pageSource()).contains("Home");

    click("a", withText("Home")); //navigate to definition page
    assertThat(pageSource()).contains("place to live");
    assertThat(pageSource()).contains("family");
  }
} //end AppTest Class

