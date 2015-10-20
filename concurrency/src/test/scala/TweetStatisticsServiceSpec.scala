import de.is24.TweetStatisticsService
import org.specs2.mutable.Specification

import scala.concurrent.Await
import scala.concurrent.duration._

class TweetStatisticsServiceSpec extends Specification {

  "A tweet statistics service" should {

    "determine who wrote more words in tweets" in {
      val service = new TweetStatisticsService
      val topTweeter = Await.result(service.whoWroteMostWords(Seq("mriehl", "phaun")),10.seconds)
      topTweeter must be equalTo "mriehl"
    }
  }

}