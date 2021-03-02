package com.xzm.myshop.entity.vo;

import com.xzm.myshop.entity.po.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//菜单vo对象 提供给菜单列表使用
@Component
public class MenuVO {
    //属性：主菜单信息（参照原始表）
    private Menu menu;

    //子菜单信息：一个集合，参照原始表集合
    private List<Menu> menus= new ArrayList<>();

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
