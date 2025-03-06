public class Main {

    //SPRING
    static ClassA classA;
    static ClassB classB;
    static ClassC classC;

    public static void main(String[] args) {

        classA = new ClassA(() -> classB, () -> classC);
        classB = new ClassB(() -> classA, () -> classC);
        classC = new ClassC(() -> classA, () -> classB);


        System.out.println(classA.toString());
        System.out.println(classB.toString());
        System.out.println(classC.toString());
    }
}
