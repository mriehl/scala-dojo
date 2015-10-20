package alert

object DiskUsageAlert {

  def listLowDiskSpaceDevices(dfOutput: String, thresholdInPercent: Int): Seq[String] = {
    val pattern = """^([^ ]+).* (\d+)%.*""".r

    dfOutput
      .split("\n")
      .collect{
        case pattern(dev, percentage) if percentage.toInt > thresholdInPercent => dev
      }
  }

}
