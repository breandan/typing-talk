package com.company.typed;

class Layout<T extends LayoutProtocol> {
    private final T t;
    private boolean vertical;

    public Layout(T t) {
        this.t = t;
    }

    public boolean isVertical() {
        return t instanceof Vertical;
    }
}

interface LayoutProtocol {
    LayoutProtocol rotate();
}

class Vertical implements LayoutProtocol {
    public Horizontal rotate() {
        return new Horizontal();
    }
}

class Horizontal implements LayoutProtocol {
    public Vertical rotate() {
        return new Vertical();
    }
}

class Main {
    public static void main(String[] args) {
//        List<Horizontal> layouts = new LinkedList<>();
//        List<Vertical> layouts = new LinkedList<>();
//        List<Layout<LayoutProtocol>> layouts = new LinkedList();
        Layout<Horizontal> horizontalLayout = new Layout<>(new Horizontal());
        Layout<Vertical> verticalLayout = new Layout<>(new Vertical());


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
