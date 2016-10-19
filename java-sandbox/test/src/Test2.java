public class Test2 {

  public static void main(String[] args) {

    String[] array = {"One", "Two", "Three", "Four"};
    for (String var : array)
      System.out.println("Element: " + var);
    
    changeVar(array);
    
  }
  
  public static void changeVar(String[] str) {
    String[] st = str;

    for (int i = 0; i < st.length; i++) {
    	st[i] = "new";
    	}

    for (String var : st )
      System.out.println("New element is \"" + var + "\"."); 
  }

}