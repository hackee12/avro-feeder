package hackee12.avro.feeder

import hackee12.avro.feeder.path.FeederPath
import org.apache.avro.Schema

class RecursiveFeeder : AvroFeeder() {
    override fun resolveNestedField(
        cxt: FeederContext,
        sourceBytes: ByteArray,
        parentPath: FeederPath,
        field: Schema.Field
    ): Any {
        val dataSchema = resolveDataSchema(field.schema())
        return when (val fieldType = dataSchema.type) {
            Schema.Type.NULL -> TODO()
            Schema.Type.UNION -> TODO()
            Schema.Type.ENUM -> TODO()
            Schema.Type.FIXED -> TODO()
            Schema.Type.STRING,
            Schema.Type.BYTES,
            Schema.Type.INT,
            Schema.Type.LONG,
            Schema.Type.FLOAT,
            Schema.Type.DOUBLE,
            Schema.Type.BOOLEAN -> resolvePrimitiveType(cxt, sourceBytes, parentPath, field)
            Schema.Type.RECORD -> resolveRecordType(cxt, sourceBytes, parentPath, field)
            Schema.Type.ARRAY -> TODO()
            Schema.Type.MAP -> TODO()
        }
    }

    private fun resolveDataSchema(schema: Schema): Schema =
        if (schema.type == Schema.Type.UNION) {
            schema.types.filterNot { t -> t.type == Schema.Type.NULL }.first()
        } else schema

    private fun resolvePrimitiveType(
        cxt: FeederContext,
        recordBytes: ByteArray,
        parentPath: FeederPath,
        field: Schema.Field
    ): Any = TODO()

    private fun resolveRecordType(
        cxt: FeederContext,
        recordBytes: ByteArray,
        parentPath: FeederPath,
        field: Schema.Field
    ): Any = TODO()
}