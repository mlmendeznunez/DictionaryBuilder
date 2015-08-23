import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("bobbs", Word.all()); //word or words?
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  get("/words/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/word-form.vtl");
     return new ModelAndView(model, layout);
   }, new  VelocityTemplateEngine());

  post("/words", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     String inputWord = request.queryParams("inputword");
     Word newDictionaryEntry = new Word(inputWord); 
     model.put("word", newDictionaryEntry);
     model.put("template", "templates/definition-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  post("/savedefinition", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
     String wordDefinition = request.queryParams("worddefinition");
     Definition newDefinition = new Definition(wordDefinition);
     word.addDefinition(newDefinition);
     
     model.put("word", word);
     model.put("template", "templates/definition-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  get("/words/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
    //model.put("contacts", Category.all());
    model.put("template", "templates/definition-list.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }//end of main,
}//end of class
