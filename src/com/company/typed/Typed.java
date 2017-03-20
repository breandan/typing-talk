package com.company.typed;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

class Layout<T> {

}

interface LayoutProtocol {
    default int c() {
        return 42;
    }
}

class Vertical implements LayoutProtocol {
    int a() {
        return 1;
    }

}

class Horizontal implements LayoutProtocol {
    int b() {
        return 2;
    }
}

class Main {
    public static void main(String[] args) {
//        List<Horizontal> layouts = new LinkedList<>();
//        List<Vertical> layouts = new LinkedList<>();
        List<Layout<LayoutProtocol>> layouts = new LinkedList();
        Layout<Horizontal> horizontalLayout = new Layout<>();
        Layout<Vertical> verticalLayout = new Layout<>();
//        layouts.add(horizontalLayout);
//        layouts.add(verticalLayout);
//        filterVerticals(layouts);
    }

//    public static List<Layout<Vertical>> filterVerticals(List<Layout<? extends LayoutProtocol>> layouts) {
//        List<Layout<Vertical>> verticalLayouts = new LinkedList<>();
//        System.out.println(layouts.getClass());
//        for (Layout<? extends LayoutProtocol> layout : layouts) {
//            if(layout instanceof Layout<Vertical>)
//            verticalLayouts.add()
//        }
//    }
}
