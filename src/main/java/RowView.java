import java.util.function.Function;

public class RowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> implements IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> {

    private final C0 c0;
    private final C1 c1;
    private final C2 c2;
    private final C3 c3;
    private final C4 c4;
    private final C5 c5;
    private final C6 c6;
    private final C7 c7;
    private final C8 c8;
    private final C9 c9;

    public RowView(C0 c0) { this(c0,null); }
    public RowView(C0 c0, C1 c1) { this(c0,c1,null); }
    public RowView(C0 c0, C1 c1, C2 c2) { this(c0,c1,c2,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3) { this(c0,c1,c2,c3,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4) { this(c0,c1,c2,c3,c4,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4, C5 c5) { this(c0,c1,c2,c3,c4,c5,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4, C5 c5, C6 c6) { this(c0,c1,c2,c3,c4,c5,c6,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4, C5 c5, C6 c6, C7 c7) { this(c0,c1,c2,c3,c4,c5,c6,c7, null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4, C5 c5, C6 c6, C7 c7, C8 c8) { this(c0,c1,c2,c3,c4,c5,c6,c7,c8,null); }
    public RowView(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4, C5 c5, C6 c6, C7 c7, C8 c8, C9 c9) {
        this.c0 = c0;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.c9 = c9;
    }

    //Shallow copy constructor
    public RowView(RowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> original) {
        this(
                original.column0(),
                original.column1(),
                original.column2(),
                original.column3(),
                original.column4(),
                original.column5(),
                original.column6(),
                original.column7(),
                original.column8(),
                original.column9()
        );
    }

    @Override public C0 column0() { return c0; }
    @Override public C1 column1() { return c1; }
    @Override public C2 column2() { return c2; }
    @Override public C3 column3() { return c3; }
    @Override public C4 column4() { return c4; }
    @Override public C5 column5() { return c5; }
    @Override public C6 column6() { return c6; }
    @Override public C7 column7() { return c7; }
    @Override public C8 column8() { return c8; }
    @Override public C9 column9() { return c9; }

    @Override
    public <R> R map(Function<IRowView<C0, C1, C2, C3, C4, C5, C6, C7, C8, C9>, R> f) {
        return f.apply(this);
    }
}
