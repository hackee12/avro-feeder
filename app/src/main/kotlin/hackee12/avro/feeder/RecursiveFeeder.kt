package hackee12.avro.feeder

import org.apache.avro.Schema

class RecursiveFeeder : AvroFeeder() {
    override fun terminateTarget(cxt: FeederContext, recordBytes: ByteArray, field: Schema.Field): Any {
        val dataSchema = resolveDataSchema(field.schema())
        when (val fieldType = dataSchema.type) {
            Schema.Type.RECORD -> TODO()
            Schema.Type.ENUM -> TODO()
            Schema.Type.ARRAY -> TODO()
            Schema.Type.MAP -> TODO()
            Schema.Type.UNION -> TODO()
            Schema.Type.FIXED -> TODO()
            Schema.Type.STRING -> TODO()
            Schema.Type.BYTES -> TODO()
            Schema.Type.INT -> TODO()
            Schema.Type.LONG -> TODO()
            Schema.Type.FLOAT -> TODO()
            Schema.Type.DOUBLE -> TODO()
            Schema.Type.BOOLEAN -> TODO()
            Schema.Type.NULL -> TODO()
        }
    }

    private fun resolveDataSchema(schema: Schema): Schema =
        if (schema.type == Schema.Type.UNION) {
            schema.types.filterNot { t -> t.type == Schema.Type.NULL }.first()
        } else schema
}