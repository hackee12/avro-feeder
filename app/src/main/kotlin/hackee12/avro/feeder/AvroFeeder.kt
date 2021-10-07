package hackee12.avro.feeder

import hackee12.avro.feeder.path.FeederPath
import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericRecordBuilder

abstract class AvroFeeder {
    fun getRecord(
        cxt: FeederContext,
        sourceBytes: ByteArray,
        targetSchema: Schema,
        parentPath: FeederPath
    ): GenericData.Record {
        val genericBuilder = GenericRecordBuilder(targetSchema)
        targetSchema.fields.forEach { field ->
            genericBuilder.set(
                field,
                resolveNestedField(cxt, sourceBytes, parentPath, field)
            )
        }
        return genericBuilder.build()
    }

    abstract fun resolveNestedField(
        cxt: FeederContext,
        sourceBytes: ByteArray,
        parentPath: FeederPath,
        field: Schema.Field
    ): Any
}