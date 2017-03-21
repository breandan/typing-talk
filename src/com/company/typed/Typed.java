package com.company.typed;

class Layout<T extends LayoutProtocol> {
    public final T t;
    private boolean vertical;

    public Layout(T t) {
        this.t = t;
    }

    public boolean isVertical() {
        return t instanceof Vertical;
    }
}

class HorizontalLayout extends Layout<Horizontal> {
    public HorizontalLayout(Horizontal horizontal) {
        super(horizontal);
    }
}


class VerticalLayout extends Layout<Vertical> {
    public VerticalLayout(Vertical vertical) {
        super(vertical);
    }
}


interface LayoutProtocol {
    LayoutProtocol rotate();

}

class Vertical implements LayoutProtocol {
    public Horizontal rotate() {
        return new Horizontal();
    }

    @Override
    public String toString() {
        return "Vertical{}";
    }
}

class Horizontal implements LayoutProtocol {
    public Vertical rotate() {
        return new Vertical();
    }

    @Override
    public String toString() {
        return "Horizontal{}";
    }
}

class Main {
    public static void main(String[] args) {
//        List<Horizontal> layouts = new LinkedList<>();
//        List<Vertical> layouts = new LinkedList<>();
//        List<Layout<LayoutProtocol>> layouts = new LinkedList();
        Layout<Horizontal> horizontalLayout = new Layout<Horizontal>(new Horizontal());
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
