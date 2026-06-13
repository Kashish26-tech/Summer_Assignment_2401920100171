interface Playable {
    void play();
}

class Veena implements Playable {
    @Override
    public void play() {
        System.out.println("Playing Veena");
    }
}

class Saxophone implements Playable {
    @Override
    public void play() {
        System.out.println("Playing Saxophone");
    }
}

public class Test {

    public static void main(String[] args) {

        // a) Veena object
        Veena v = new Veena();
        v.play();

        // b) Saxophone object
        Saxophone s = new Saxophone();
        s.play();

        // c) Using Playable reference
        Playable p1 = new Veena();
        Playable p2 = new Saxophone();

        p1.play();
        p2.play();
    }
}
