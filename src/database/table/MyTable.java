package database.table;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * テーブルクラス
 * 型付きの二次元の表を提供する。
 */
public class MyTable {

    // テーブル名
    private String tableName;
    // テーブル本体
    // x軸でカラム、y軸でレコードを表す。
    private Field[][] tableBody;
    // カラム数
    private int columnNumber;
    // 現在注目している行を示すポインタ
    private int pointer = 0;
    // テーブル構造
    private TableStructure tableStructure;

    // コンストラクタ
    // テーブル名とテーブル構造を受け取る
    public MyTable(String tableName, TableStructure tableStructure) {
        this.tableName = tableName;
        this.tableStructure = tableStructure;
        // テーブルのカラム数(x軸を設定する)
        this.columnNumber = tableStructure.columnNumber;
        this.tableBody = new Field[this.columnNumber][];
    }

    /**
     * レコードを追加する。
     * @param newRecord 新規レコード
     */
    public void addRecord(NewRecord newRecord) throws SQLException {
        int newRecordColumnNumber = newRecord.columnNumber;

        // カラム数チェック
        if (newRecordColumnNumber != columnNumber) {
            throw new SQLException(String.format("カラム数が一致しません。 expected = %d but actual = %d.", columnNumber, newRecordColumnNumber));
        }

        // 新規レコード
        Field[] record = new Field[columnNumber];

        // 型チェックとフィールド作成
        for (int i = 0; i < columnNumber; i++) {
            Data<?> data;
            // 型チェックとデータ作成
            try {
                 data = tableStructure.dataTypes[i].function.apply(newRecord.dataArray[i]);
            } catch (ClassCastException e) {
                throw new SQLException(String.format("カラム名:%sの型が不正です。", tableStructure.columnNames[i]));
            }
            // フィールド作成
            Field field = new Field(data);
            // レコードにフィールドを追加
            record[i] = field;
        }

        // テーブルにレコードを追加
        tableBody[pointer] = record;
        // ポインタを一つ上に移動
        pointer++;
    }

    /**
     * テーブル構造クラス
     * テーブルを作成する前にこのクラスを利用してテーブル構造を定義する。
     */
    public static class TableStructure {
        // カラム数
        int columnNumber;
        // カラム名一覧
        String[] columnNames;
        //　型一覧
        DataType[] dataTypes;

        // コンストラクタ
        //　カラム定義の配列からテーブル構造を構築する。
        TableStructure(ColumnDefine[] columnDefines) {
            this.columnNumber = columnDefines.length;
            this.columnNames = new String[columnDefines.length];
            this.dataTypes = new DataType[columnDefines.length];

            for (int i = 0; i < columnDefines.length; i++) {
                columnNames[i] = columnDefines[i].columnName;
                dataTypes[i] = columnDefines[i].dataType;
            }
        }
    }

    /**
     * カラム定義クラス
     */
    public static class ColumnDefine {
        String columnName;
        DataType dataType;

        public ColumnDefine(String columnName, DataType dataType) {
            this.columnName = columnName;
            this.dataType = dataType;
        }
    }

    /**
     * このテーブルで扱う型の一覧
     */
    public enum DataType {
        DOUBLE(MyDouble::new),
        INTEGER(MyInteger::new),
        STRING(MyString::new),
        BOOLEAN(MyBoolean::new);

        private final ObjectToDataFunction function;

        DataType(ObjectToDataFunction function) {
            this.function = function;
        }
    }

    /**
     * Object型から各種データクラスを生成する関数型インターフェース
     */
    @FunctionalInterface
    interface ObjectToDataFunction {
        /**
         * Object型からデータクラスを取得する。
         * @param object 基となるオブジェクト
         * @return データクラス
         * @throws ClassCastException データクラス生成時に型変換ができなかった場合
         */
        Data<?> apply(Object object) throws ClassCastException;
    }

    /**
     * データの抽象クラス
     * @param <T> このデータクラスが扱う何らかの型
     */
    public static abstract class Data<T extends Serializable>{
        final T value;

        Data(Object value) throws ClassCastException{
            this.value = as(value);
        }

        /**
         * 型を取得する
          */
        abstract DataType getDataType();

        /**
         * 値を取得する。
         * @return 値
         */
        public T getValue() {
            return value;
        };

        /**
         * 型変換用のメソッド
         * 継承先で実装される。
         */
        abstract T as(Object o) throws ClassCastException;

    }

    /**
     * Double型を扱うデータクラス
     */
    public static class MyDouble extends Data<Double> {
        final DataType dataType = DataType.DOUBLE;

        public MyDouble(Object value) throws ClassCastException{
            super(value);
        }

        @Override
        DataType getDataType() {
            return this.dataType;
        }

        @Override
        Double as(Object o) {
            return (Double) o;
        }
    }

    /**
     * Integer型を扱うデータクラス
     */
    public static class MyInteger extends Data<Integer> {
        final DataType dataType = DataType.INTEGER;

        public MyInteger(Object value) throws ClassCastException{
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }

        @Override
        Integer as(Object o) {
            return (Integer) o;
        }
    }

    /**
     * String型を扱うデータクラス
     */
    public static class MyString extends Data<String> {
        final DataType dataType = DataType.STRING;

        public MyString(Object value) throws ClassCastException{
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }

        @Override
        String as(Object o) {
            return (String) o;
        }
    }

    /**
     * Boolean型を扱うデータクラス
     */
    public static class MyBoolean extends Data<Boolean>{
        final DataType dataType = DataType.BOOLEAN;

        public MyBoolean(Object value) throws ClassCastException{
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }

        @Override
        Boolean as(Object o) {
            return (Boolean)o;
        }
    }

    /**
     * フィールドクラス
     */
    private static class Field {
        // このフィールドで扱うデータ
        Data<?> value;

        public Field(Data<?> value) {
            this.value = value;
        }
    }

    /**
     * 新規レコードクラス
     */
    public static class NewRecord {
        int columnNumber;
        Object[] dataArray;

        NewRecord(Object[] dataArray) {
            this.columnNumber = dataArray.length;
            this.dataArray = dataArray;
        }
    }
}
