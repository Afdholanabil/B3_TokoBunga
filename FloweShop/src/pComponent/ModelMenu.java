package pComponent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;


public class ModelMenu {
    

    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public MenuType getType() {
        return type;
    }


    public void setType(MenuType type) {
        this.type = type;
    }
    private String icon;
    private String name;
    private MenuType type;

    public ModelMenu() {
    }

    public ModelMenu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    public Icon tooIcon(){
        return new ImageIcon(getClass().getResource("/pImages/"+ icon+".png"));
    }
    
    public static enum MenuType {
        TITLE,MENU,EMPTY
    }
}
