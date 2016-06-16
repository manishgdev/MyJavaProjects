import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
   
public class Main extends JFrame {
  
   public Main() {
      getContentPane().setLayout(new FlowLayout());
  
      Vector v = new Vector();
      final JList list = new JList(new ConditionableItem[] {
                                       new ConditionableItem("Item 1"),
                                       new ConditionableItem("Item 2", false),
                                       new ConditionableItem("Item 3", false),
                                       new ConditionableItem("Item 4")
                                   });
 
      list.setCellRenderer(new ConditionableCellRenderer());
      list.addListSelectionListener(new ConditionableListSelectionListener());
      getContentPane().add(new JScrollPane(list));   
  
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent event) {
            System.out.println("Selected items were:");
            Object sv[] = list.getSelectedValues();
            for (int i=0; i<sv.length; i++)
               System.out.println(sv[i]);
  
            System.exit(0);  
         }     
      });
  
      setSize(200, 300);
   }
    
   public static void main(String[] args) {
      (new Main()).show();
   }
}
  
class ConditionableCellRenderer extends DefaultListCellRenderer implements ListCellRenderer {
   public Component getListCellRendererComponent(
      JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)   
   {
      setText((value == null) ? "" : value.toString());
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      }
  
      if (!((Conditionable) value).isEnabled()) {
         setBackground(list.getBackground());
         setForeground(UIManager.getColor("Label.disabledForeground"));
      }
  
      setEnabled(list.isEnabled());
      setFont(list.getFont());
  
      return this;
   }
}
  
class ConditionableListSelectionListener implements ListSelectionListener {
   public void valueChanged(ListSelectionEvent e) {
      JList list = (JList) e.getSource();
      ListModel lm = list.getModel();
      for (int i=e.getFirstIndex(); i<=e.getLastIndex(); i++) {
         if (list.getSelectionModel().isSelectedIndex(i)) {
            if (!((Conditionable) lm.getElementAt(i)).isEnabled()) {
               list.removeSelectionInterval(i, i);
            }
         }
      }
   }
}
  
class ConditionableItem implements Conditionable {
   Object  object;
   boolean isEnabled;
                             
   public ConditionableItem(Object object, boolean isEnabled) {
      this.object = object;
      this.isEnabled = isEnabled;
   }
                              
   ConditionableItem(Object object) {
      this(object, true);
   }
                            
   public boolean isEnabled() {
      return isEnabled;
   }
                             
   public void setEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
   }
                             
   public String toString() {
      return object.toString();
   }
}
                          
interface Conditionable {
   public boolean isEnabled();
   public void setEnabled(boolean enabled);
   public String toString();
}
