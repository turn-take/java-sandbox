package database.table;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * テーブルクラス
 */
public class MyTable {

    // テーブル名
    String tableName;
    // テーブル本体
    // x軸でカラム、y軸でレコードを表す。
    Field[][] tableBody;
    // カラム数
    int columnNumber;
    // 現在注目している行を示すポインタ
    int pointer = 0;
    // テーブル構造
    TableStructure tableStructure;

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
     */
    public void addRecord(NewRecord newRecord) throws SQLException {

        int srcColumnNumber = newRecord.columnNumber;

        // カラム数チェック
        if (srcColumnNumber > columnNumber) {
            throw new SQLException(String.format("カラム数が多いです。 expected = %d < actual = %d", columnNumber, newRecord.columnNumber));
        }
        if (!newRecord.isColumnNameBased && srcColumnNumber != columnNumber) {
            throw new SQLException(String.format("カラム数が一致しません。 expected = %d but actual = %d", columnNumber, newRecord.columnNumber));
        }

        // カラム名チェック
        if (newRecord.isColumnNameBased) {
            for (int i = 0; i < srcColumnNumber; i++) {
                String srcColumnName = newRecord.columnNames[i];
                if (Arrays.stream(tableStructure.columnNames)
                        .noneMatch(Predicate.isEqual(srcColumnName))) {
                    throw new SQLException(String.format("%sというカラムは存在しません。", srcColumnName));
                }
            }
        }

        // 新規レコード
        Field[] record = new Field[columnNumber];

        // 型チェック
        for (int i = 0; i < srcColumnNumber; i++) {
            if (!newRecord.isColumnNameBased && !newRecord.dataArray[i].getDataType().equals(tableStructure.dataTypes[i])) {
                throw new SQLException(String.format("カラムインデックス：%dの型が不正です。 expected = %s but actual = %s.",
                        i,
                        tableStructure.dataTypes[i],
                        newRecord.dataArray[i].getDataType()));
            }

            if (newRecord.isColumnNameBased) {
                String srcColumnName = newRecord.columnNames[i];
                for (int j = 0; j < columnNumber; j++) {
                    if (tableStructure.columnNames[j].equals(srcColumnName)) {
                        if (!tableStructure.dataTypes[j].equals(newRecord.dataArray[i].getDataType())) {
                            throw new SQLException(String.format("カラムインデックス：%dの型が不正です。 expected = %s but actual = %s.",
                                    i,
                                    tableStructure.dataTypes[i],
                                    newRecord.dataArray[i].getDataType()));
                        }
                    }
                }
            }
            Field field = new Field(newRecord.dataArray[i]);
            record[i] = field;
        }
        // 現在のポインタの位置にレコードを追加する。
        tableBody[pointer] = record;
        // ポインタを一つ上に移動させる
        pointer++;
    }

    /**
     * テーブル構造クラス
     * テーブルを作成する前にこのクラスを利用してテーブル構造を定義する。
     */
    static class TableStructure {
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
    static class ColumnDefine {
        String columnName;
        DataType dataType;
    }

    /**
     * このテーブルで扱う型の一覧
     */
    enum DataType {
        DOUBLE,
        INTEGER,
        STRING,
        BOOLEAN;
    }

    // データ型インターフェース
    static abstract class Data<T>{
        T value;

        @SuppressWarnings("unchecked") // ClassCastExceptionを明示的に発生させるので
        Data(Object value) throws ClassCastException{
            this.value = (T) value;
        }

        // 型を取得する
        abstract DataType getDataType();

        // 値を取得する
        T getValue() {
            return value;
        };
    };

    static class MyDouble extends Data<Double> {
        final DataType dataType = DataType.DOUBLE;

        public MyDouble(Object value){
            super(value);
        }

        @Override
        DataType getDataType() {
            return this.dataType;
        }
    }

    static class MyInteger extends Data<Integer> {
        final DataType dataType = DataType.INTEGER;

        public MyInteger(Object value){
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }
    }

    static class MyString extends Data<String> {
        final DataType dataType = DataType.STRING;

        public MyString(Object value) {
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }
    }

    static class MyBoolean extends Data<Boolean>{
        final DataType dataType = DataType.BOOLEAN;

        public MyBoolean(Object value) {
            super(value);
        }

        @Override
        public DataType getDataType() {
            return this.dataType;
        }
    }

    /**
     * フィールドクラス
     */
    static class Field {
        // このフィールドで扱うデータ
        Data<?> value;

        public Field(Data<?> value) {
            this.value = value;
        }
    }

    /**
     * 新規レコードクラス
     */
    static class NewRecord {
        int columnNumber;
        String[] columnNames;
        Data<?>[] dataArray;
        //　カラム名を利用するかのフラグ
        final boolean isColumnNameBased;

        // データだけでレコードを作成する。
        NewRecord(Data<?>[] dataArray) {
            isColumnNameBased = false;
            this.columnNumber = dataArray.length;
            this.dataArray = dataArray;
        }

        // データとカラム名でレコードを作成する。
        NewRecord(DataAndColumnName[] columnDefines) {
            isColumnNameBased = true;
            this.columnNumber = columnDefines.length;
            columnNames = new String[columnNumber];
            dataArray = new Data<?>[columnNumber];

            for (int i = 0; i < columnNumber; i++) {
                columnNames[i] = columnDefines[i].columnName;
                dataArray[i] = columnDefines[i].data;
            }
        }

        /**
         * データとカラム名のひとまとまりクラス
         */
        static class DataAndColumnName {
            Data<?> data;
            String columnName;
        }
    }



}
