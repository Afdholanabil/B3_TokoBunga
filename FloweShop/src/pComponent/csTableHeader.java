package pComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.table.DefaultTableCellRenderer;


public class csTableHeader extends DefaultTableCellRenderer{

    public csTableHeader() {
        setPreferredSize(new Dimension(0, 35));
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(102,67,33));
        g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
    }
    
    
}
