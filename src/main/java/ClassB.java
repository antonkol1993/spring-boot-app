import java.util.function.Supplier;

public class ClassB {

    private Supplier<ClassA> a;
    private Supplier<ClassC> c;

    public ClassB(Supplier<ClassA> a, Supplier<ClassC> c) {
        this.a = a;
        this.c = c;
    }

    @Override
    public String toString() {
        return "ClassB " + a.get().hashCode() + " " + c.get().hashCode();
    }
}
