package cz.mg.sql;


import cz.mg.sql.block.select.Order;
import cz.mg.sql.data.SqlCreateBuilder;
import cz.mg.sql.data.SqlDeleteBuilder;
import cz.mg.sql.data.SqlReadBuilder;
import cz.mg.sql.data.SqlUpdateBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class VisualTest {
    public static void main(String[] args) {
        testCreate();
        separator();
        testRead();
        separator();
        testUpdate();
        separator();
        testDelete();
    }

    private static void test(SqlBaseBuilder builder){
        System.out.println(builder.build(Formatting.SINGLE_LINE).getText());
        System.out.println();
        System.out.println(builder.build(Formatting.MULTI_LINE).getText());
    }

    private static void separator(){
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    private static void testCreate(){
        SqlCreateBuilder builder = new SqlBuilder()
            .create("FooBar")
            .column("foo")
            .column("bar");

        test(builder);
    }

    private static void testRead(){
        SqlReadBuilder builder = new SqlReadBuilder()
            .read("FooBar", "foobar")
            .column("foo", "f")
            .column("bar", "b")
            .column("SUM(price)")
            .column("MAX(price)")
            .join("NoName", "noname", "foobar.n = noname.id")
            .where("f > 1")
            .where("b > 1")
            .groupBy("f, b")
            .having("SUM(price) > 0")
            .orderBy("SUM(price)", Order.ASCENDING)
            .orderBy("MAX(price)", Order.DESCENDING);

        test(builder);
    }

    private static void testUpdate(){
        SqlUpdateBuilder builder = new SqlUpdateBuilder()
            .update("FooBar")
            .column("foo")
            .column("bar")
            .where("foo = 1")
            .where("bar = 1");

        test(builder);
    }

    private static void testDelete(){
        SqlDeleteBuilder builder = new SqlDeleteBuilder()
            .delete("FooBar")
            .where("foo = 1")
            .where("bar = 1");

        test(builder);
    }
}
