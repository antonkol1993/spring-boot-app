import java.util.function.Supplier;

public class ClassA {

    private Supplier<ClassB> b;
    private Supplier<ClassC> c;

    public ClassA(Supplier<ClassB> b, Supplier<ClassC> c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "ClassA " + b.get().hashCode() + " " + c.get().hashCode();
    }

}
