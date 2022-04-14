package pSwing;

import java.awt.Color;
import javax.swing.JPanel;
import pComponent.WrapLayout;

public class PanelItem extends JPanel{

    public PanelItem() {
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }

    
}
