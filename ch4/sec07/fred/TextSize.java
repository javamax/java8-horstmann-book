package fred;

import javafx.scene.text.*;

public class TextSize {
   private double em;
   public TextSize() {
      em = new Text("").getLayoutBounds().getHeight();
   }
   public double getEm() {
      return em;
   }
}
