package cz.mg.sql;

import cz.mg.sql.blocks.rows.read.Order;
import cz.mg.sql.rows.SqlReadRowsBuilder;
import cz.mg.sql.utilities.SqlBaseBuilder;


public class VisualTest {
    public static void main(String[] args) {
        testAll(
            testCreateRows(),
            testReadRows(),
            testUpdateRows(),
            testDeleteRows(),
            testCreateTable(),
            testDeleteTable()
        );
    }

    private static void testAll(SqlBaseBuilder... builders){
        for(SqlBaseBuilder builder : builders){
            test(builder);
            if(builder != builders[builders.length - 1]) separator();
        }
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

    private static SqlBaseBuilder testCreateRows(){
        return new SqlBuilder()
            .createRows("FooBar")
            .column("foo")
            .column("bar");
    }

    private static SqlBaseBuilder testReadRows(){
        return new SqlReadRowsBuilder()
            .readRows("FooBar", "foobar")
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
    }

    private static SqlBaseBuilder testUpdateRows(){
        return new SqlBuilder()
            .updateRows("FooBar")
            .column("foo")
            .column("bar")
            .where("foo = 1")
            .where("bar = 1");
    }

    private static SqlBaseBuilder testDeleteRows(){
        return new SqlBuilder()
            .deleteRows("FooBar")
            .where("foo = 1")
            .where("bar = 1");
    }

    private static SqlBaseBuilder testCreateTable(){
        return new SqlBuilder()
            .createTable("FooBar")
            .column("foo", "NUMBER")
            .column("bar", "NUMBER");
    }

    private static SqlBaseBuilder testDeleteTable(){
        return new SqlBuilder()
            .deleteTable("FooBar");
    }
}
