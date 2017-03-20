package com.company.interfacing;

import java.util.LinkedList;
import java.util.List;

interface Layout {

}

class Vertical implements Layout {

}

class Horizontal implements Layout {

}

class Main {
    public static void main(String[] args) {
//        List<Horizontal> layouts = new LinkedList<>();
//        List<Vertical> layouts = new LinkedList<>();
        List<Layout> layouts = new LinkedList<>();
        Horizontal horizontalLayout = new Horizontal();
        Vertical verticalLayout = new Vertical();
        layouts.add(horizontalLayout);
        layouts.add(verticalLayout);
        filterVerticals(layouts);
    }

    static List<Vertical> filterVerticals(List<Layout> layouts) {
        List<Vertical> verticals = new LinkedList<>();
        for (Layout layout : layouts) {
            if(layout instanceof Vertical)
                verticals.add((Vertical) layout);
        }

        return verticals;
    }

}
