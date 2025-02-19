import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowViewTest {

    @Test
    void construction() {
        var view = new RowView<>(0,1,2,3,4,5,6,7,8,9);
        assertEquals(0,view.column0());
        assertEquals(1,view.column1());
        assertEquals(2,view.column2());
        assertEquals(3,view.column3());
        assertEquals(4,view.column4());
        assertEquals(5,view.column5());
        assertEquals(6,view.column6());
        assertEquals(7,view.column7());
        assertEquals(8,view.column8());
        assertEquals(9,view.column9());
    }


}