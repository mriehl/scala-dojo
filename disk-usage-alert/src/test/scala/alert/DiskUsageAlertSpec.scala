package alert

import org.specs2.matcher.ValueCheck
import org.specs2.mutable.Specification

class DiskUsageAlertSpec extends Specification {

  val dfOutput =
    """
      |Filesystem      Size  Used Avail Use% Mounted on
      |udev            7.8G     0  7.8G   0% /dev
      |tmpfs           1.6G  9.9M  1.6G   1% /run
      |/dev/sda1        30G  9.6G   19G  34% /
      |tmpfs           7.8G   65M  7.8G   1% /dev/shm
      |tmpfs           5.0M  4.0K  5.0M   1% /run/lock
      |tmpfs           7.8G     0  7.8G   0% /sys/fs/cgroup
      |/dev/sda6       3.7G  1.9G  1.7G  53% /var
      |/dev/sda7        83G   17G   63G  90% /data
      |tmpfs           1.6G  8.0K  1.6G   1% /run/user/126
      |tmpfs           1.6G  8.0K  1.6G   1% /run/user/42140
      |
    """.stripMargin

  "Disk usage alert" should {
    "list devices low on disk space with 80% threshold" in {
      val lowDiskSpaceDevices = DiskUsageAlert.listLowDiskSpaceDevices(dfOutput, thresholdInPercent = 80)
      lowDiskSpaceDevices.must(have).size(1)
      lowDiskSpaceDevices must beEqualTo(Seq("/dev/sda7"))
    }

    "list devices low on disk space with 95% threshold" in {
      val lowDiskSpaceDevices = DiskUsageAlert.listLowDiskSpaceDevices(dfOutput, thresholdInPercent = 95)
      lowDiskSpaceDevices must beEmpty
    }

    "list devices low on disk space with 30% threshold" in {
      Seq("foobar") must containAllOf(Seq("foo"))
      val lowDiskSpaceDevices = DiskUsageAlert.listLowDiskSpaceDevices(dfOutput, thresholdInPercent = 30)
      lowDiskSpaceDevices must have size 3
      lowDiskSpaceDevices must contain("/dev/sda")
      lowDiskSpaceDevices must containAllOf(Seq("/dev/sda1", "/dev/sda6", "/dev/sda7"))
    }
  }
}
