package cz.mg.sql;

public class VisualTest {
    public static void main(String[] args) {
        System.out.println(createSimpleSql(Formatting.SINGLE_LINE).getText());
        System.out.println();
        System.out.println(createSimpleSql(Formatting.MULTI_LINE).getText());
        System.out.println();
    }

    private static Sql createSimpleSql(Formatting formatting){
        return new SqlBuilder(formatting)
            .select("foo", "f")
            .from("FooBar", "fooBar")
            .where("f = 1")
            .build();
    }
}
