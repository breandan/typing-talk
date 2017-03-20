package com.company.inheritance;

class View { }

abstract class Layout extends View {
    public abstract Layout rotate();

//    public abstract void setOrientation(Horizontal layout);
}

class Vertical extends Layout {
    @Override
    public Horizontal rotate() {
        return new Horizontal();
    }

    public void setOrientation(Layout layout) {

    }

    @Override
    public String toString() {
        return "Vertical";
    }
}

class Horizontal extends Layout {
    @Override
    public Vertical rotate() {
        return new Vertical();
    }

    @Override
    public String toString() {
        return "Horizontal";
    }
}

class Main {
    public static void main(String[] args) {
        Layout horizontal = new Horizontal();
        Layout vertical = new Vertical();

        System.out.println("Horizontal rotated: " + horizontal.rotate());
        System.out.println("Vertical rotated: " + vertical.rotate());
    }
}
