package hackee12.avro.feeder.path

data class FeederPath(val path: String)

fun FeederPath.join(child: String) = FeederPath(this.path + "." + child)