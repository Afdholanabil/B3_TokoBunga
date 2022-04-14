package pSwing;

import com.raven.table.TableCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;
import pComponent.ScrollBarCustom;
import pComponent.csTableHeader;
            
public class csTable extends TableCustom{

    public csTable() {
    }
    
    public void addTabStyle(JScrollPane scroll){
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel pnl = new JPanel();
        //pnl.setBackground(new Color(60,60,60));
        setShowHorizontalLines(true);        
        setSelectionBackground(new Color(220,220,220));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pnl);
        setRowHeight(33);
        //getTableHeader().setBackground(new Color(255,255,255));
        getTableHeader().setDefaultRenderer(new csTableHeader());
        setGridColor(new Color(220,220,220));
        setSelectionForeground(new Color(0,0,0));
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component com = super.prepareRenderer(renderer, row, column);
        if (!isCellSelected(row, column)){
            com.setBackground(new Color(255,255,255));
        }
        return  com;
    }
    
    
    
}
