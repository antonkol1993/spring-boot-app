import java.util.function.Supplier;

public class ClassC {

    private Supplier<ClassA> a;
    private Supplier<ClassB> b;

    public ClassC(Supplier<ClassA> a, Supplier<ClassB> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "ClassC " + a.get().hashCode() + " " + b.get().hashCode();
    }
}
