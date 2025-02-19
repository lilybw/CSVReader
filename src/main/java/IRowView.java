import java.util.function.Function;

public interface IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> {

    C0 column0();
    C1 column1();
    C2 column2();
    C3 column3();
    C4 column4();
    C5 column5();
    C6 column6();
    C7 column7();
    C8 column8();
    C9 column9();

    <R> R map(Function<IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9>,R> f);

}
