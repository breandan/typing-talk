package com.company.typedModified;

import java.util.LinkedList;
import java.util.List;

class Layout<T extends LayoutProtocol> {

}

class LayoutProtocol {
    int c() {
        return 42;
    }
}

class Vertical extends LayoutProtocol {
    int a() {
        return 1;
    }

}

class Horizontal extends LayoutProtocol {
    int b() {
        return 2;
    }
}

class Main {
    public static void main(String[] args) {
//        List<Horizontal> layouts = new LinkedList<>();
//        List<Vertical> layouts = new LinkedList<>();
        List<LayoutProtocol> layouts = new LinkedList();
        Horizontal horizontalLayout = new Horizontal();
        Vertical verticalLayout = new Vertical();
        layouts.add(horizontalLayout);
        layouts.add(verticalLayout);

        for (LayoutProtocol layout : layouts) {
            System.out.println(layout);
        }
    }
}
