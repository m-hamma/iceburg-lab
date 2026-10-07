package org.hm.repository;

import org.apache.iceberg.PartitionSpec;
import org.apache.iceberg.Schema;
import org.apache.iceberg.hadoop.HadoopTables;
import org.apache.iceberg.types.Types;
import org.hm.model.User;
import org.apache.iceberg.Table;

public class UserIcebergRepository {

    public Schema buildSchema() {

        return new Schema(
                Types.NestedField.required(
                        1,
                        "id",
                        Types.LongType.get()
                ),
                Types.NestedField.required(
                        2,
                        "userName",
                        Types.StringType.get()
                ),
                Types.NestedField.required(
                        3,
                        "role",
                        Types.StringType.get()
                ),
                Types.NestedField.required(
                        4,
                        "enabled",
                        Types.BooleanType.get()
                )
        );
    }

    public void insert(User user) {

        System.out.println(
                "Insert user : " + user
        );

    }
    public void createTable() {

        String tablePath = "warehouse/users";

        HadoopTables tables = new HadoopTables();

        Table table = tables.create(
                buildSchema(),
                PartitionSpec.unpartitioned(),
                tablePath
        );

        System.out.println(
                "Table créée : " + table.location()
        );
    }
}