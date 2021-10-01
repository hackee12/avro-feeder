package hackee12.avro.feeder

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericRecordBuilder

abstract class AvroFeeder {
    fun getRecord(cxt: FeederContext, recordBytes: ByteArray, recordSchema: Schema): GenericData.Record {
        val genericBuilder = GenericRecordBuilder(recordSchema)
        recordSchema.fields.forEach { field ->  genericBuilder.set(field, terminateTarget(cxt, recordBytes, field)) }
        return genericBuilder.build()
    }

    abstract fun terminateTarget(cxt: FeederContext, recordBytes: ByteArray, field: Schema.Field): Any
}